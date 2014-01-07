package org.lichee.simple.example.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.lichee.simple.example.entity.Test;
import org.lichee.simple.example.repository.TestDao;
import org.lichee.simple.example.service.TestSev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service("testSev") 
public class TestSevImpl implements TestSev {

	private TestDao testDao;
	
	public Page<Test> getTestList(Pageable pageable){
		
		return testDao.findAll(pageable);
	}
	
	public void saveTest(Test test){
		
		testDao.save(test);
	}
	
	public Test getTest(Integer testId){
		
		return testDao.findOne(testId);
	}
	
	public void deleteTest(Integer testId){
		
		testDao.delete(testId);
	}

	public TestDao getTestDao() {
		return testDao;
	}

	@Autowired
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	@Override
	public Page<Test> getTestList(final int pageNumber, final int pageSize,
			final String name) {
		
		return testDao.findAll(new Specification<Test>(){
			@Override
			public Predicate toPredicate(Root<Test> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate predicate = cb.conjunction();
	            List<Expression<Boolean>> expressions = predicate.getExpressions();
	            expressions.add(cb.like(root.<String>get("testName"), "%"+name+"%"));           //关键字
	            return predicate;
			}}, new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC, "testId"));
	}
	
	
}
