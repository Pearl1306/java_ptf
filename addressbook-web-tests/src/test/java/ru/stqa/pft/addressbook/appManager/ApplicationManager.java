package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper ;
  private GroupHelper groupHelper ;
  private ContactHelper helper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {

    if ( browser==BrowserType.FIREFOX){
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    }else if (browser==BrowserType.CHROME) {
      wd = new ChromeDriver();
    }else if (browser==BrowserType.IE){
      wd = new InternetExplorerDriver();

    }
      {

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        helper = new ContactHelper(wd);
        sessionHelper.login("admin", "secret");
      }
    }

  
  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
  public ContactHelper getHelper() {
    return helper;
  }
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
