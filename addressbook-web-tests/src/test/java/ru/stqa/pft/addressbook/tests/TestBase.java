package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appManager.ApplicationManager;
import ru.stqa.pft.addressbook.appManager.ContactHelper;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  public ContactHelper helper;

  public static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("start test "+ m.getName()+ " with parametrs "+ Arrays.asList(p));

  }
  @AfterMethod (alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("stop test "+ m.getName());

  }
  public void verifeGroupListInUI() {
    if(Boolean.getBoolean("verifyUI")) {
      Groups dbGoups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGoups.stream().map((g) -> new GroupData().withId(g.getId())
              .withName(g.getName())).collect(Collectors.toSet())));
    }
  }
}
