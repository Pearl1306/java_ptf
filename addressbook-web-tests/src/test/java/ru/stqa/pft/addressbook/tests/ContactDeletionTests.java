package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePriconditions(){
    app.goTo().home();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData().withFirstname("otvet0").withLastname("otvet1"));
    }
  }

  @Test
  public void testContactDeletion(){
    List<ContactData> before=app.contact().list();
    int index = before.size() -1;
    app.contact().delete(index);
    List<ContactData> after =app.contact().list();
    Assert.assertEquals(after.size(),index);
    before.remove(index);
    Assert.assertEquals(before,after);
  }


}
