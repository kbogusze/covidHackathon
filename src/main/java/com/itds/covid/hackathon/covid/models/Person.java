package com.itds.covid.hackathon.covid.models;

import org.springframework.data.annotation.Id;

public class Person {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    String phoneNumber;
    String email;

    Boolean TermConsent;
    Boolean ContactConsent;

    String cardIdNumber;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
