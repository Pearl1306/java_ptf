package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    app.getHelper().selectContact();
    app.getHelper().deleteSelectedContact();
    app.getHelper().gotoContainer();
  }
}
