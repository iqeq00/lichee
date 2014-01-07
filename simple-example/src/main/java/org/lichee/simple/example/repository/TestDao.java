package org.lichee.simple.example.repository;

import org.lichee.simple.example.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 测试dao inf
 */
public interface TestDao extends JpaRepository<Test, Integer>,
		JpaSpecificationExecutor<Test> {

	// /**
	// * 根据一个测试的id来查询
	// */
	// Test getByTestId(Integer testId);
	//
	// /**
	// * 根据一个测试的id来查询
	// */
	// @Query("FROM Test AS t WHERE t.testId = ?1")
	// Test getTest(Integer testId);
	//
	// /**
	// * 查询所有的用户
	// */
	// @Query("FROM Test ")
	// List<Test> getList();
}
