package org.lichee.simple.example.service;

import org.lichee.simple.example.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TestSev {

	Page<Test> getTestList(Pageable pageable);
	
	void saveTest(Test test);
	
	Test getTest(Integer testId);
	
	void deleteTest(Integer testId);

	Page<Test> getTestList(int pageNumber, int pageSize,
			String name);
}
