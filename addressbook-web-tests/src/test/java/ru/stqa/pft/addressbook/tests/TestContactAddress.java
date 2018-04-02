package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

public class TestContactAddress extends TestBase {

  @Test
  public void testContactPhone(){
    app.goTo().home();
    Contacts before = app.contact().all();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    Contacts after = app.contact().all();
 MatcherAssert.assertThat(after, Matchers.equalTo(before.with(contactInfoFromEditForm )));
  }

}
