package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getHelper().selectContact();
    app.getHelper().initContactModification();
    app.getHelper().fillContactForm(new ContactData("otvet0", "otvet1", "otvet2", "otvet3", "44 otvet4", "1234567890", "2345678901", "3456789012", "otvet5@gmail.com"));
    app.getHelper().submitContactModification();
    app.getHelper().returnToHomePage();

  }

}
