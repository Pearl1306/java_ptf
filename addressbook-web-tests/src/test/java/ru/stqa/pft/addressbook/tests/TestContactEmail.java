package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestContactEmail extends TestBase {


  @Test
  public void testContactEmail() {
    app.goTo().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s)-> ! s.equals(""))
            .map(TestContactEmail::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String emails){
    return emails.replaceAll("()","").replaceAll("\\s","");
  }

}