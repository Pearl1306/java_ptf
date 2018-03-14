package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("New"))) {
      return;

    }
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("mainTable"))){
      return;
    }
    click(By.linkText("home"));
  }
}
