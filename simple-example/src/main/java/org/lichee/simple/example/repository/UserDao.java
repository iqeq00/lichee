package org.lichee.simple.example.repository;

import org.lichee.simple.example.entity.SeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 测试dao inf
 */
public interface UserDao extends JpaRepository<SeUser, Integer>,
		JpaSpecificationExecutor<SeUser> {

	 /**
	 * 根据一个测试的id来查询
	 */
	SeUser getByUserName(String userName);
	
}
