package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getHelper().isThereAContact()) {
      app.getHelper().createContact(new ContactData("otvet0", "otvet1", "otvet2", "otvet3", "44 otvet4", "1234567890", "2345678901", "3456789012", "otvet5@gmail.com", "test1"));
    }
    List<ContactData> before = app.getHelper().getContactList();
    app.getHelper().selectContact(before.size() - 1);
    app.getHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"otvet0", "otvet1", "otvet2", "otvet3", "44 otvet4", "1234567890", "2345678901", "3456789012", "otvet5@gmail.com", null);
    app.getHelper().fillContactForm(contact,false);
    app.getHelper().submitContactModification();
    app.getHelper().returnToHomePage();
    List<ContactData> after = app.getHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
