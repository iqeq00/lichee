package org.lichee.simple.example.web.easyui;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.lichee.simple.example.entity.Task;
import org.lichee.simple.example.service.TaskSev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * easyui风格的rest范例
 * 
 * @author Lynch
 */
@Controller
@RequestMapping(value = "/easyui/task")
public class EsTaskCol {

	@Autowired
	private TaskSev taskSev;
	
	/**
	 * 查询列表页面
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listJsp() {
		
		return "easyui/task/taskList";
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(Integer rows, Integer page) {
		
		Map<String, Object> map = new HashMap<String, Object>(2);
		try {
			Page<Task> tasks = taskSev.list(new PageRequest(page-1,rows, Sort.Direction.DESC, "taskId"));
			map.put("total", tasks.getTotalElements());
			map.put("rows", tasks.getContent());
		} catch (Exception e) {
		}
		return map;
	}
	
	/**
	 * 添加页面
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {

		model.addAttribute("task", new Task());
		model.addAttribute("action", "create");
		return "easyui/task/taskForm";
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> create(@Valid Task task) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			taskSev.save(task);
			map.put("success", true);
			map.put("msg", "添加成功！");
		} catch (Exception e) {
			map.put("msg", "添加失败！");
		}
		return map;
	}
	
	/**
	 * 查询页面
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateForm(Model model) {
		model.addAttribute("action", "update");
		return "easyui/task/taskForm";
	}
	
	/**
	 * 更新
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@Valid @ModelAttribute("task")Task task) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			taskSev.save(task);
			map.put("obj", task);
			map.put("success", true);
			map.put("msg", "修改成功！");
		} catch (Exception e) {
			map.put("msg", "修改失败！");
		}
		return map;
	}
	
	
	/**
	 * 删除 
	 */
	@RequestMapping(value = "delete/{ids}")
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("ids") String ids) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			for (String id : ids.split(",")) {
				if (id != null) {
					taskSev.delete(Integer.parseInt(id));
				}
			}
			map.put("success", true);
			map.put("msg", "删除成功!");
		} catch (Exception e) {
			map.put("msg", "删除失败!");
		}
		return map;
	}
	
	public void get(
			@RequestParam(value = "taskId", defaultValue = "-1") Integer taskId,
			Model model) {

		if (taskId != -1) {
			model.addAttribute("task", taskSev.get(taskId));
		}
	}
	
}
