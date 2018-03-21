package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Set<GroupData> before=app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after =app.group().all();
    Assert.assertEquals(after.size(),before.size()+1);

    group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
    /**after.stream().mapToInt((g)-> g.getId()).max().getAsInt()-
     * -berem kolekciyu kotoraya soderjit gruppy s uje izvestnymi indet-i
     * prevrashyaem ee v potok,zatem potok tipa groupData prevratim v potok indent-v t.e.celyh chisel
     * pri pomoshi funkcii "mapToInt", ona v kachestve parametrov prinimaet opisanie togo kak ob'ekt
     * prevrashaetsya v chislo, peredaem v kachestve parametra ananimnuyu funkciyu s parametrom"g"-gruppa
     * a v kachestve rezultata vydaet indet-r etoy gruppy.U potoka chisel est funkciya "max" i
     * preobrazuem rezultat v celoe chislo -ETO I BUDET MAX inden-m iz vseh grupp
     */


    before.add(group);
    Assert.assertEquals(before,after);
  }


}
