package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String email;

  public ContactData(String firstname, String lastname, String title, String company, String address, String home, String mobile, String work, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getEmail() {
    return email;
  }
}
