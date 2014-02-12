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
	SeUser getByUserName(String userName);


}
