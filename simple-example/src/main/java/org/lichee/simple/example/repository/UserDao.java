package org.lichee.simple.example.repository;

import org.lichee.simple.example.entity.SeUser;
import org.lichee.simple.example.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 测试dao inf
 */
public interface UserDao extends JpaRepository<SeUser, Integer>,
		JpaSpecificationExecutor<Task> {

	 /**
	 * 根据一个测试的id来查询
	 */
	SeUser getByUserName(String userName);
	
	/**
	 * 查询用户名唯一
	 */
	SeUser findUserByUserName(String userName);
	
	
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
