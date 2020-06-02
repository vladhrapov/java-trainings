package com.lostandfound.lostandfound.storage;

import java.util.List;

import com.lostandfound.lostandfound.entities.Finding;
import com.lostandfound.lostandfound.models.FindingViewModel;

public interface IFindingsStorage {
	List<Finding> GetData();

	Finding Save(FindingViewModel finding) throws Exception;

	int remove(int id) throws Exception;
}
