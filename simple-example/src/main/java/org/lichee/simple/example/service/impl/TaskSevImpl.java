package org.lichee.simple.example.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.lichee.simple.example.entity.Task;
import org.lichee.simple.example.repository.TaskDao;
import org.lichee.simple.example.service.TaskSev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * task 服务层 impl
 * 
 * @author lynch
 */
@Service("taskSev")
public class TaskSevImpl implements TaskSev {

	@Autowired
	private TaskDao taskDao;

	/**
	 * 列表
	 */
	public Page<Task> list(Pageable pageable) {

		return taskDao.findAll(pageable);
	}

	/**
	 * 列表
	 */
	public Page<Task> list(final int pageNumber, final int pageSize,
			final String name) {

		return taskDao.findAll(new Specification<Task>() {
			@Override
			public Predicate toPredicate(Root<Task> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {

				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> expressions = predicate.getExpressions();
				expressions.add(cb.like(root.<String> get("taskName"), "%" + name + "%")); // 关键字
				return predicate;
			}
		}, new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC, "taskId"));
	}

	/**
	 * 保存
	 */
	public void save(Task task) {

		taskDao.save(task);
	}

	/**
	 * 查询
	 */
	public Task get(Integer id) {

		return taskDao.findOne(id);
	}

	/**
	 * 删除
	 */
	public void delete(Integer id) {

		taskDao.delete(id);
	}

}
