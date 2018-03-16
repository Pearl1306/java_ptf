package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {
  public static void main(String[] args){
    //Massiv elementa [] kotoraya opisyvaet kolekcii ,parametry funkcii main yavlyaetsya massivom
    //sdelaem svoy sobstvenniy massiv
    String[]langs={"Java","C#","Python","PHP"};
    List<String> languages = Arrays.asList("Java","C#","Python","PHP");

    for (String l : languages){
      System.out.println("Ya hochu vyuchit "+ l );
    }

  }
}
