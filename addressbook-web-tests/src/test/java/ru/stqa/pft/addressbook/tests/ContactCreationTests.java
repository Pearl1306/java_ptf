package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.xml")));
    String xml = "";
    String line = reader.readLine();
    while(line != null){
      xml+=line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>)xstream.fromXML(xml);
    return contacts.stream().map((g)->new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContacts")
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
