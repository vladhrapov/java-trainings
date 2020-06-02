package com.lostandfound.lostandfound.repository;

import java.util.List;
import java.util.NoSuchElementException;

import com.lostandfound.lostandfound.entities.Finding;
import com.lostandfound.lostandfound.models.FindingViewModel;

public interface IFindingsRepository {
    Finding get(int id) throws NoSuchElementException, NullPointerException;

    List<Finding> search(String[] keywords);

    Finding create(FindingViewModel finding) throws Exception;

    int remove(int id) throws Exception;
}