package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
   /** app.goTo().groupPage();
    if (!app.goup().isThereAGroup()) {
      app.goup().create(new GroupData("test1", "null", "null"));
    }**/
    app.goTo().groupPage();
    if (app.goup().list().size()==0) {
      app.goup().create(new GroupData("test1", "null", "null"));
    }
  }

  @Test
public void testGroupModification(){
    List<GroupData> before=app.goup().list();
    int index = before.size() -1;
    GroupData group = new GroupData(before.get(index).getId(),"test1", "test2", "test3");
    app.goup().modify(index, group);
    List<GroupData> after =app.goup().list();
    Assert.assertEquals(after.size(),before.size());
    before.remove(index);
    before.add(group);
      Comparator<? super GroupData> byId=(g1,g2)-> Integer.compare(g1.getId(),g2.getId());
      before.sort(byId);
      after.sort(byId);
    Assert.assertEquals(before,after);
    //preobrazovanie spiska vo mnojestva pri pomoshi "HashSet"
  }


}
