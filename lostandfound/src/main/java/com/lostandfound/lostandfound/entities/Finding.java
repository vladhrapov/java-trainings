package com.lostandfound.lostandfound.entities;

import java.util.List;

public class Finding
{
    private int id;
    private List<String> keywords;
    private String description;
    private ContactInfo contactInfo;

    public Finding(int id, List<String> keywords, String description, ContactInfo contactInfo) {
        this.id = id;
        this.keywords = keywords;
        this.description = description;
        this.contactInfo = contactInfo;
    }

    // ToDo: (1) Add constructor that takes: id, keywords, description, contact info
    // and sets them into private fields

    public int getId() {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

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
