package org.lichee.simple.example.service.impl;

import java.util.Date;

import org.lichee.simple.example.entity.SeUser;
import org.lichee.simple.example.repository.UserDao;
import org.lichee.simple.example.service.UserSev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user 服务层 impl
 * 
 * @author lynch
 */
@Service("userSev")
public class UserSevImpl implements UserSev {

	@Autowired
	private UserDao userDao;

	/**
	 * 用户注册
	 */
	public void registerUser(SeUser user) {
		
		user.setUserCreateTime(new Date());
		userDao.save(user);
	}

	/**
	 * 查询用户名唯一
	 */
	public SeUser findUserByUserName(String userName) {
		
		return userDao.findUserByUserName(userName);
	}

//	/**
//	 * 列表
//	 */
//	public Page<Task> list(Pageable pageable) {
//
//		return taskDao.findAll(pageable);
//	}
//
//	/**
//	 * 列表
//	 */
//	public Page<Task> list(final int pageNumber, final int pageSize,
//			final String name) {
//
//		return taskDao.findAll(new Specification<Task>() {
//			@Override
//			public Predicate toPredicate(Root<Task> root,
//					CriteriaQuery<?> query, CriteriaBuilder cb) {
//
//				Predicate predicate = cb.conjunction();
//				List<Expression<Boolean>> expressions = predicate.getExpressions();
//				expressions.add(cb.like(root.<String> get("taskName"), "%" + name + "%")); // 关键字
//				return predicate;
//			}
//		}, new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC, "taskId"));
//	}
//
//	/**
//	 * 保存
//	 */
//	public void save(Task task) {
//
//		taskDao.save(task);
//	}
//
//	/**
//	 * 查询
//	 */
//	public Task get(Integer id) {
//
//		return taskDao.findOne(id);
//	}
//
//	/**
//	 * 删除
//	 */
//	public void delete(Integer id) {
//
//		taskDao.delete(id);
//	}

}
