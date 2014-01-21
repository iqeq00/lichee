package org.lichee.simple.example.web.sitemesh;

import javax.validation.Valid;

import org.lichee.simple.example.entity.Task;
import org.lichee.simple.example.service.TaskSev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * bootstarp风格的rest范例
 * 
 * @author Lynch
 */
@Controller
@RequestMapping(value = "/sitemesh/task")
public class BsTaskCol {

	@Autowired
	private TaskSev taskSev;

	/**
	 * 查询列表
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "pager.size", defaultValue = "10") int pageSize,
			Model model) {

		Page<Task> tasks = taskSev.list(pageNumber, pageSize, "");
		model.addAttribute("tasks", tasks);
		return "sitemesh/task/taskList";
	}

	/**
	 * 添加页面
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {

		model.addAttribute("task", new Task());
		model.addAttribute("action", "create");
		return "sitemesh/task/taskForm";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid Task task, RedirectAttributes redirectAttributes) {

		taskSev.save(task);
		redirectAttributes.addFlashAttribute("message", "创建任务成功");
		return "redirect:/sitemesh/task/";
	}

	/**
	 * 详情
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("task", taskSev.get(id));
		model.addAttribute("action", "update");
		return "sitemesh/task/taskForm";
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("task") Task task,
			RedirectAttributes redirectAttributes) {
		taskSev.save(task);
		redirectAttributes.addFlashAttribute("message", "更新任务成功");
		return "redirect:/sitemesh/task/";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			RedirectAttributes redirectAttributes) {
		taskSev.delete(id);
		redirectAttributes.addFlashAttribute("message", "删除任务成功");
		return "redirect:/sitemesh/task/";
	}

	@ModelAttribute
	public void get(
			@RequestParam(value = "taskId", defaultValue = "-1") Integer taskId,
			Model model) {

		if (taskId != -1) {
			model.addAttribute("task", taskSev.get(taskId));
		}
	}

}
