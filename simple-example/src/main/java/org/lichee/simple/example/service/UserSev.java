package org.lichee.simple.example.service;

import org.lichee.simple.example.entity.SeUser;

/**
 * user 服务层 inf
 * 
 * @author lynch
 */
public interface UserSev {

	/**
	 * 用户注册
	 */
	void registerUser(SeUser user);

	/**
	 * 查询用户名唯一
	 */
	SeUser findUserByUserName(String userName);

//	/**
//	 * 列表
//	 */
//	Page<Task> list(Pageable pageable);
//
//	/**
//	 * 列表
//	 */
//	Page<Task> list(int pageNumber, int pageSize, String name);
//
//	/**
//	 * 保存
//	 */
//	void save(Task task);
//
//	/**
//	 * 查询
//	 */
//	Task get(Integer id);
//
//	/**
//	 * 删除
//	 */
//	void delete(Integer id);

}
