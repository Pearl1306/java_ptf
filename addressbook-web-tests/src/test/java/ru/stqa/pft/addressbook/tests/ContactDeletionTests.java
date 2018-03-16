package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    if(!app.getHelper().isThereAContact()){
      app.getHelper().createContact(new ContactData("otvet0", "otvet1", "otvet2", "otvet3", "44 otvet4", "1234567890", "2345678901", "3456789012", "otvet5@gmail.com", "test1"));
    }
    int before= app.getHelper().getContactCount();
    app.getHelper().selectContact();
    app.getHelper().deleteSelectedContact();
    app.getHelper().gotoContainer();
    int after= app.getHelper().getContactCount();
    Assert.assertEquals(after ,before -1);
  }
}
