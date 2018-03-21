package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePriconditions(){
    app.goTo().home();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData().withFirstname("otvet0").withLastname("otvet1"));
    }
  }
  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).
            withFirstname("otvet0").withLastname("otvet1").withTitle("otvet2").
            withCompany("otvet3").withAddress("44 otvet4").withHome("1234567890").
            withMobile("2345678901").withWork("3456789012").withEmail("otvet5@gmail.com").withGroup(null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2)-> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
