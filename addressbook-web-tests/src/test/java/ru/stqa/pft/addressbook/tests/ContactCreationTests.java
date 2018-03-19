package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
    app.goTo().home();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("otvet0", "otvet1", "otvet2", "otvet3", "44 otvet4", "1234567890", "2345678901", "3456789012", "otvet5@gmail.com", "test1");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2)-> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
