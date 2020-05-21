package com.lostandfound.lostandfound.repository;

import java.util.List;

import com.lostandfound.lostandfound.model.Finding;

public interface IFindingsRepository
{
    List<Finding> GetByKeyword(List<String> keywords);
}