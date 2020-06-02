package com.lostandfound.lostandfound.models;

import java.util.List;

import com.lostandfound.lostandfound.entities.ContactInfo;

public class FindingViewModel {
    private List<String> keywords;
    private String description;
    private ContactInfo contactInfo;

    public List<String> getKeywords() {
        return this.keywords;
    }

    public void setKeywords(List<String> keywords)
    {
        this.keywords = keywords;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public ContactInfo getContactInfo()
    {
        return this.contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo)
    {
        this.contactInfo = contactInfo;
    }
}