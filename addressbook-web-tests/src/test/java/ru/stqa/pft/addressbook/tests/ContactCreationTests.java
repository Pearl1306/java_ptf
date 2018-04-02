package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
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
