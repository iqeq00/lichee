package org.lichee.simple.example.service;

import org.lichee.simple.example.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * task 服务层 inf
 * 
 * @author lynch
 */
public interface TaskSev {

	/**
	 * 列表
	 */
	Page<Task> list(Pageable pageable);

	/**
	 * 列表
	 */
	Page<Task> list(int pageNumber, int pageSize, String name);

	/**
	 * 保存
	 */
	void save(Task task);

	/**
	 * 查询
	 */
	Task get(Integer id);

	/**
	 * 删除
	 */
	void delete(Integer id);

}
