package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

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
    Groups groups=app.db().groups();
    // File photo = new File("src/test/resources/rose.jpg");
    if (groups.size() == 0) {

    }
    ContactData newContact = new ContactData().withFirstname("test_name").withLastname("test_lastname")
            .withAddress("44 otvet4").withHome("1234567890").
            withMobile("2345678901").withWork("3456789012").withEmail("otvet5@gmail.com")
            .withEmail2("ee@gmail.com").withEmail3("gg@gmail.com").inGroup(groups.iterator().next());
    Contacts before = app.db().contacts();
    app.goTo().home();
    app.contact().addNewContact();
      app.contact().fillContactForm(newContact, true);
      app.contact().submit();
      app.contact().returnToHomePage();
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withAdded(contact.
            withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));


  }
   /*     app.goTo().home();
  Contacts before = app.contact().all();
  ContactData contact = new ContactData().withFirstname("otvet0")
          .withLastname("otvet1").withTitle("otvet2").withCompany("otvet3").
                  withAddress("44 otvet4").withHome("1234567890").withMobile("2345678901").
                  withWork("3456789012").withAllPhones("1234567890\n 2345678901\n 3456789012\n").withEmail("otvet5@gmail.com").withEmail2("otvet6@gmail.com")
          .withEmail3("otvet7@gmail.com").withAllEmails("otvet5@gmail.com\n otvet6@gmail.com\n otvet7@gmail.com\n").withGroup("test1");
    app.contact().create(contact);
  assertThat(app.contact().count(), equalTo(before.size() + 1));
  Contacts after = app.contact().all();
  assertThat(after, equalTo(before.withAdded(contact.
          withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

*/
  @Test(enabled = false)
  public void currentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/rose.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }

}
