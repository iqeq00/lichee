package org.lichee.simple.example.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.lichee.core.persistence.DynamicSpecifications;
import org.lichee.core.persistence.SearchFilter;
import org.lichee.core.persistence.SearchFilter.Operator;
import org.lichee.simple.example.entity.Task;
import org.lichee.simple.example.repository.TaskDao;
import org.lichee.simple.example.service.TaskSev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	 * 列表
	 */
	public Page<Task> list(int pageNumber, int pageSize,
			Map<String, Object> searchParams, String sortType) {
		
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Task> spec = buildSpecification(searchParams);

		return taskDao.findAll(spec, pageRequest);
	}
	
	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "taskId");
		} else if ("taskName".equals(sortType)) {
			sort = new Sort(Direction.ASC, "taskName");
		}
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Task> buildSpecification(Map<String, Object> searchParams) {
		
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Task> spec = DynamicSpecifications.bySearchFilter(filters.values(), Task.class);
		return spec;
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
