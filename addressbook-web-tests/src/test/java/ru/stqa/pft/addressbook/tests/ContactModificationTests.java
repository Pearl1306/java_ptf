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
    app.goTo().home();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstname("otvet0")
              .withLastname("otvet1").withHome("1234567890")
              .withMobile("2345678901").withWork("3456789012"));
    }
  }
  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).
            withFirstname("otvet0").withLastname("otvet1").withTitle("otvet2").
            withCompany("otvet3").withAddress("44 otvet4").withHome("1234567890").
            withMobile("2345678901").withWork("3456789012").withEmail("otvet5@gmail.com").withGroup(null);
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size() ));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }



}
