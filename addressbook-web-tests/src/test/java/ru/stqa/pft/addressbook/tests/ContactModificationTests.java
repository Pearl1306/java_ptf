package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePriconditions(){
    if (app.db().contacts().size()==0){
      app.goTo().home();
      app.contact().create(new ContactData().withFirstname("otvet0")
              .withLastname("otvet1").withHome("1234567890")
              .withMobile("2345678901").withWork("3456789012"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    app.goTo().home();
    ContactData modifiedContact = before.iterator().next();
    app.goTo().home();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).
            withFirstname("otvet0").withLastname("otvet1").withAddress("44 otvet4").withHome("1234567890").
            withMobile("2345678901").withWork("3456789012").withEmail("otvet5@gmail.com")
            .withEmail2("ee@gmail.com").withEmail3("gg@gmail.com").withGroup(null);
    app.goTo().home();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size() ));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }



}
