package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){

    if(!app.getHelper().isThereAContact()){
      app.getHelper().createContact(new ContactData("otvet0", "otvet1", "otvet2", "otvet3", "44 otvet4", "1234567890", "2345678901", "3456789012", "otvet5@gmail.com", "test1"));
    }
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before=app.getHelper().getContactList();
    app.getHelper().selectContact(before.size() -1);
    app.getHelper().deleteSelectedContact();
    app.getHelper().gotoContainer();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after =app.getHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(before.size() -1);
    Assert.assertEquals(before,after);
  }
}
