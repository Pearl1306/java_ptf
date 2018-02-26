package ru.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void Distance(){
    Point p1= new Point(11,22);
    Point p2= new Point (22,31);
    Assert.assertEquals(p1.distance(p2), 14.212670403551895);
  }
}
