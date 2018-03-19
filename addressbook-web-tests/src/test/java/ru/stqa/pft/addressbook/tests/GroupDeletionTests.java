package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.goup().list().size()==0) {
      app.goup().create(new GroupData("test1", "null", "null"));
    }
  }

  @Test
  public void testsGroupDeletion() {
    List<GroupData> before = app.goup().list();
    int index = before.size() - 1;
    app.goup().delete(index);
    List<GroupData> after = app.goup().list();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    //peremennaya "before" ssylaetsya ne na stariy spisok, a na stariy spisok v kotor udalen nenujniy element

    Assert.assertEquals(after, before);

  }



}
