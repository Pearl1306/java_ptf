package ru.stqa.pft.addressbook.model;

import java.util.Objects;

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
  private String group;

  public ContactData(String firstname, String lastname, String title, String company, String address, String home, String mobile, String work, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstname, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            '}';
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

  public String getGroup() {
    return group;
  }
}
