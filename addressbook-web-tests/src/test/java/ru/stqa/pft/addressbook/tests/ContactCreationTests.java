package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContact() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withFirstname("test1").withLastname("lastname1").withAddress("address1")});
    list.add(new Object[]{new ContactData().withFirstname("test2").withLastname("lastname2").withAddress("address2")});
    list.add(new Object[]{new ContactData().withFirstname("test3").withLastname("lastname3").withAddress("address3")});
    return list.iterator();
  }

  @Test(dataProvider = "validContact")
  public void testsContactCreation(ContactData contact) {
      app.goTo().home();
      app.contact().addNewContact();
      File photo = new File("src/test/resources/rose.jpg");
      app.contact().fillContactForm(new ContactData().withFirstname("test_name").withLastname("test_lastname")
              .withPhoto(photo).withGroup("test1"), true);
      app.contact().submit();
      app.contact().returnToHomePage();

    }


  @Test(enabled = false)
  public void currentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/rose.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }

}
