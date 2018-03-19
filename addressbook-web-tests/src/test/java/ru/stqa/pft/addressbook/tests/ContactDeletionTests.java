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
      app.contact().create(new ContactData("otvet0", "otvet1", "otvet2", "otvet3", "44 otvet4", "1234567890", "2345678901", "3456789012", "otvet5@gmail.com", "test1"));
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
