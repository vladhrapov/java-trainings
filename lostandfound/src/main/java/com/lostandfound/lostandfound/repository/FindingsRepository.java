package com.lostandfound.lostandfound.repository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.lostandfound.lostandfound.entities.Finding;
import com.lostandfound.lostandfound.models.FindingViewModel;
import com.lostandfound.lostandfound.storage.IFindingsStorage;

/**
 * FindingsRepository
 */
public class FindingsRepository implements IFindingsRepository {
    private IFindingsStorage findingsStorage;

    public FindingsRepository(IFindingsStorage findingsStorage) {
        this.findingsStorage = findingsStorage;
    }

    @Override
    public Finding get(int id) throws NoSuchElementException, NullPointerException {
        Finding finding = findingsStorage.GetData().stream().filter((Finding f) -> f.getId() == id).findFirst().get();

        return finding;
    }

    @Override
    public List<Finding> search(String[] keywords) {
        List<String> keywordsList = Arrays.asList(keywords).stream().map(keyword -> keyword.toLowerCase())
                .collect(Collectors.toList());

        List<Finding> findings = findingsStorage.GetData().stream().filter(f -> {
            boolean anyMatch = f.getKeywords().stream()
                    .anyMatch(keyword -> keywordsList.contains(keyword.toLowerCase()));
            return anyMatch;
        }).collect(Collectors.toList());

        return findings;
    }

    @Override
    public Finding create(FindingViewModel finding) throws Exception {
        return findingsStorage.Save(finding);
    }

    @Override
    public int remove(int id) throws Exception {
        return findingsStorage.remove(id);
    }
}
