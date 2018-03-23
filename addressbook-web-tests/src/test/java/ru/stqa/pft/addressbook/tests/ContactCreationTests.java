package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
    app.goTo().home();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("otvet0")
            .withLastname("otvet1").withTitle("otvet2").withCompany("otvet3").
                    withAddress("44 otvet4").withHome("1234567890").withMobile("2345678901").
                    withWork("3456789012").withEmail("otvet5@gmail.com").withGroup("test1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
