package com.lostandfound.lostandfound.storage;

import java.util.List;

import com.lostandfound.lostandfound.model.Finding;

public class InMemoryFindingsStorage implements IFindingsStorage
{
    private List<Finding> findings;
    // ToDo: (1) Create field called findings of type List<Finding>.

    public List<Finding> GetData()
    {
        Finding Table = new Finding(015, table, description, contactInfo);
        Finding Phone = new Finding(837, table, description, contactInfo);
        Finding Dog = new Finding(245, table, description, contactInfo);
        Finding Book = new Finding(011, table, description, contactInfo);
        Finding Headphones = new Finding(015, table, description, contactInfo);

        // ToDo: (1) Add into the collection 5 items
        // They must be meaningful, and some should contain the same keywords, product names, etc.

        // ToDo: (1) Return this field called findings
        return findings;
    }
}