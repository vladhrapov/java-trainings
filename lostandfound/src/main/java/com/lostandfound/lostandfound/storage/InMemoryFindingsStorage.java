package com.lostandfound.lostandfound.storage;

import java.util.List;

import com.lostandfound.lostandfound.model.Finding;

public class InMemoryFindingsStorage implements IFindingsStorage
{
    // ToDo: (1) Create field called findings of type List<Finding>.

    public List<Finding> GetData()
    {
        // ToDo: (1) Add into the collection 5 items
        // They must be meaningful, and some should contain the same keywords, product names, etc.

        // ToDo: (1) Return this field called findings
        return List.of(new Finding());
    }
}