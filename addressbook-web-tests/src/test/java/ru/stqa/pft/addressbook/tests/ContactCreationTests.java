package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
    app.goTo().home();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("otvet0")
            .withLastname("otvet1").withTitle("otvet2").withCompany("otvet3").
                    withAddress("44 otvet4").withHome("1234567890").withMobile("2345678901").
                    withWork("3456789012").withEmail("otvet5@gmail.com").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.
            withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }


}
