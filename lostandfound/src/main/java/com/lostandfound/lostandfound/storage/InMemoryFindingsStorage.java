package com.lostandfound.lostandfound.storage;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import com.lostandfound.lostandfound.model.ContactInfo;
import com.lostandfound.lostandfound.model.Finding;

public class InMemoryFindingsStorage implements IFindingsStorage
{
    private List<Finding> findings;

    public List<Finding> GetData()
    {
        ContactInfo nastya = new ContactInfo("Nastya", "5543676", new String("Kiev")  );
        ContactInfo kolya = new ContactInfo("Kolya", "7668095", new String("Kharkiv")  );

        Finding table = new Finding(15, Arrays.asList(new String[]{ "table", "brown table", "wood table" }), "wood, brown", nastya);
        Finding phone = new Finding(837, Arrays.asList(new String[]{ "phone", "Samsung A40", "black phone" }), "Samsung A40, black", nastya);
        Finding dog = new Finding(245, Arrays.asList(new String[]{ "dog", "shepherd", "black dog" }), "shepherd, black", nastya);
        Finding book = new Finding(11, Arrays.asList(new String[]{ "book", "Harry Potter" }), "Harry Potter", nastya);
        Finding headphones = new Finding(15, Arrays.asList(new String[]{ "headphones", "AirPods2", "white headphones", "white Airpods2" }), "AirPods2, white", nastya);
        Finding headphones2 = new Finding(15, Arrays.asList(new String[]{ "headphones", "JBL", "white headphones", "white JBL" }), "JBL, white", kolya);
        Finding phone2 = new Finding(837, Arrays.asList(new String[]{ "phone", "Samsung S8", "black Samsung S8", "black phone" }), "Samsung S8, black", kolya);

        findings = new ArrayList<Finding>();
        findings.add(table);
        findings.add(phone);
        findings.add(dog);
        findings.add(book);
        findings.add(headphones);
        findings.add(headphones2);
        findings.add(phone2);

        return findings;
    }
}