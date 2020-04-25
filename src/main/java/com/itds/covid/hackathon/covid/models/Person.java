package com.itds.covid.hackathon.covid.models;

import org.springframework.data.annotation.Id;

public class Person {

    @Id
    public String id;

    public String login;
    public String password;
    public String email;
    public String userType;
    public String firstName;
    public String lastName;
    public String address;
    public String phoneNumber;

    public String companyName;
    public String activityCategory;
    public String nipNumber;
    public String regonNumber;
    public String peselNumber;

    public String companyAddress;
    public String companyPhone;
    public String companyWebsite;

    Boolean TermConsent;
    Boolean ContactConsent;

    String cardIdNumber;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getlogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.login = password;
    }

    //applicant or guarantor
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.login = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getActivityCategory() {
        return activityCategory;
    }

    public void setActivityCategory(String activityCategory) {
        this.activityCategory = activityCategory;
    }

    public String getNipNumber() {
        return nipNumber;
    }

    public void setNipNumber(String nipNumber) {
        this.nipNumber = nipNumber;
    }

    public String getRegonNumber() {
        return regonNumber;
    }

    public void setRegonNumber(String regonNumber) {
        this.regonNumber = regonNumber;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public Boolean getTermConsent() {
        return TermConsent;
    }

    public void setTermConsent(Boolean termConsent) {
        TermConsent = termConsent;
    }

    public Boolean getContactConsent() {
        return ContactConsent;
    }

    public void setContactConsent(Boolean contactConsent) {
        ContactConsent = contactConsent;
    }

    public String getCardIdNumber() {
        return cardIdNumber;
    }

    public void setCardIdNumber(String cardIdNumber) {
        this.cardIdNumber = cardIdNumber;
    }
}
