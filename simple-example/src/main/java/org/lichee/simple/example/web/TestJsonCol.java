package org.lichee.simple.example.web;

import java.util.HashMap;
import java.util.Map;

import org.lichee.simple.example.entity.Test;
import org.lichee.simple.example.service.TestSev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/testjson")
public class TestJsonCol {

	private TestSev testSev;
	
	/**
	 * 查询列表页面
	 */
	@RequestMapping(value = "/testListJsp")
	public String testListJsp() {
		
		return "test/testList";
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = "/testList")
	@ResponseBody
	public Map<String, Object> testList(Integer rows, Integer page) {
		
		Map<String, Object> map = new HashMap<String, Object>(2);
		try {
			Page<Test> pageModel = testSev.getTestList(new PageRequest(page-1,rows, Sort.Direction.DESC, "testId"));
			map.put("total", pageModel.getTotalElements());
			map.put("rows", pageModel.getContent());
		} catch (Exception e) {
		}
		return map;
	}
	
	/**
	 * 添加页面
	 */
	@RequestMapping(value = "/testAddJsp")
	public String testAddJsp() {
		
		return "test/testAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping(value = "/testAdd")
	@ResponseBody
	public Map<String, Object> testAdd(Test test) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			testSev.saveTest(test);
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
	@RequestMapping(value = "/testInfoJsp")
	public String testInfoJsp() {
		
		return "test/testInfo";
	}
	
	/**
	 * 更新
	 */
	@RequestMapping(value = "/testUpdate")
	@ResponseBody
	public Map<String, Object> testUpdate(Test test) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			testSev.saveTest(test);
			map.put("obj", test);
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
	@RequestMapping(value = "/testDelete/{testIds}")
	@ResponseBody
	public Map<String,Object> testDelete(@PathVariable("testIds") String testIds) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			for (String testId : testIds.split(",")) {
				if (testId != null) {
					testSev.deleteTest(Integer.parseInt(testId));
				}
			}
			map.put("success", true);
			map.put("msg", "删除成功!");
		} catch (Exception e) {
			map.put("msg", "删除失败!");
		}
		return map;
	}
	

	public TestSev getTestSev() {
		return testSev;
	}

	@Autowired
	public void setTestSev(TestSev testSev) {
		this.testSev = testSev;
	}
	
	
}
