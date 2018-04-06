package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appManager.ApplicationManager;
import ru.stqa.pft.addressbook.appManager.ContactHelper;

public class TestBase {
  public ContactHelper helper;

  public static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }


}
