package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
      System.out.println("Hello,world!");

      Point p1 = new Point (11,22);
      Point p2 = new Point (22,31);

      System.out.println("Rastoyanie mejdu dvumya tochkami "+"p1 i p2"+"="+p1.distance( p2) );


    }





}