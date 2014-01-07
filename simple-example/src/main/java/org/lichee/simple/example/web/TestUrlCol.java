package org.lichee.simple.example.web;

import javax.validation.Valid;

import org.lichee.simple.example.entity.Test;
import org.lichee.simple.example.service.TestSev;
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

@Controller
@RequestMapping(value = "/testurl")
public class TestUrlCol {

	@Autowired
	private TestSev testSev;

	/**
	 * 查询列表
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
		@RequestParam(value = "page", defaultValue = "1") int pageNumber,
		@RequestParam(value = "pager.size", defaultValue = "10") int pageSize,
		Model model) {

		Page<Test> tests = testSev.getTestList(pageNumber, pageSize, "");
		model.addAttribute("tests", tests);
		return "testurl/testList";
	}

	/**
	 * 添加页面
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {

		model.addAttribute("test", new Test());
		model.addAttribute("action", "create");
		return "testurl/testForm";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid Test test, RedirectAttributes redirectAttributes) {

		testSev.saveTest(test);
		redirectAttributes.addFlashAttribute("message", "创建测试成功");
		return "redirect:/testurl/";
	}

	/**
	 * 详情
	 */
	@RequestMapping(value = "update/{testId}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("testId") Integer testId, Model model) {
		model.addAttribute("test", testSev.getTest(testId));
		model.addAttribute("action", "update");
		return "testurl/testForm";
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("test") Test test,
			RedirectAttributes redirectAttributes) {
		testSev.saveTest(test);
		redirectAttributes.addFlashAttribute("message", "更新测试成功");
		return "redirect:/testurl/";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "delete/{testId}")
	public String delete(@PathVariable("testId") Integer testId,
			RedirectAttributes redirectAttributes) {
		testSev.deleteTest(testId);
		redirectAttributes.addFlashAttribute("message", "删除任务成功");
		return "redirect:/testurl/";
	}

	@ModelAttribute
	public void getTest(
		@RequestParam(value = "testId", defaultValue = "-1") Integer testId,
		Model model) {

		if (testId != -1) {
			model.addAttribute("test", testSev.getTest(testId));
		}
	}

}
