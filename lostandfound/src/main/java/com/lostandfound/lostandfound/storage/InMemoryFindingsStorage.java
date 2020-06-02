package com.lostandfound.lostandfound.storage;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import com.lostandfound.lostandfound.entities.ContactInfo;
import com.lostandfound.lostandfound.entities.Finding;
import com.lostandfound.lostandfound.models.FindingViewModel;

public class InMemoryFindingsStorage implements IFindingsStorage {
    private List<Finding> findings;

    public InMemoryFindingsStorage() {
        InitializeStorage();
    }

    @Override
    public List<Finding> GetData() {
        return findings;
    }

    @Override
    public Finding Save(FindingViewModel finding) throws Exception {
        int id = findings.get(findings.size() - 1).getId() + 1;
        Finding savingFinding = new Finding(id, finding.getKeywords(), finding.getDescription(),
                finding.getContactInfo());
        boolean savedSuccessfully = findings.add(savingFinding);

        if (!savedSuccessfully) {
            throw new Exception("Unable to save Finding");
        }

        return savingFinding;
    }

    @Override
    public int remove(int id) throws Exception {
        boolean removedSuccessfully = findings.removeIf(f -> f.getId() == id);

        if (!removedSuccessfully) {
            throw new Exception(String.format("Can't find item to remove, with id: %s", id));
        }

        return id;
    }

    private List<Finding> InitializeStorage() {
        ContactInfo nastya = new ContactInfo("Nastya", "5543676", new String("Kiev"));
        ContactInfo kolya = new ContactInfo("Kolya", "7668095", new String("Kharkiv"));

        Finding table = new Finding(1, Arrays.asList(new String[] { "table", "brown table", "wood table" }),
                "wood, brown", nastya);
        Finding samsungA40 = new Finding(2,
                Arrays.asList(new String[] { "phone", "Samsung", "Samsung A40", "black phone" }), "Samsung A40, black",
                nastya);
        Finding shephardDog = new Finding(3, Arrays.asList(new String[] { "dog", "shepherd", "black dog" }),
                "shepherd, black", nastya);
        Finding harryPotterBook = new Finding(4, Arrays.asList(new String[] { "book", "Harry Potter" }), "Harry Potter",
                nastya);
        Finding airPods2 = new Finding(5,
                Arrays.asList(new String[] { "headphones", "AirPods2", "white headphones", "white Airpods2" }),
                "AirPods2, white", nastya);
        Finding jbl = new Finding(6,
                Arrays.asList(new String[] { "headphones", "JBL", "white headphones", "white JBL" }), "JBL, white",
                kolya);
        Finding samsungS8 = new Finding(7,
                Arrays.asList(new String[] { "phone", "Samsung", "Samsung S8", "black Samsung S8", "black phone" }),
                "Samsung S8, black", kolya);

        findings = new ArrayList<Finding>();
        findings.add(table);
        findings.add(samsungA40);
        findings.add(shephardDog);
        findings.add(harryPotterBook);
        findings.add(airPods2);
        findings.add(jbl);
        findings.add(samsungS8);

        return findings;
    }
}