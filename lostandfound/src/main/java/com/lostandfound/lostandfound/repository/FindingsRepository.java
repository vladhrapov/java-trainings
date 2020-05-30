package com.lostandfound.lostandfound.repository;

import java.util.List;

import com.lostandfound.lostandfound.model.Finding;

/**
 * FindingsRepository
 */
public class FindingsRepository implements IFindingsRepository
{
    public List<Finding> GetByKeyword(List<String> keywords)
    {
        // ToDo: (2) Get from in memory storage findings by keyword

        return List.of();
    }
}
