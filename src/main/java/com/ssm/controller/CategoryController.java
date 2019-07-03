package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.base.util.AjaxResponder;
import com.ssm.domain.Category;
import com.ssm.service.CategoryService;

/**
 * Blog Controller
 * 
 * @author shengwangzhong
 * @date: 2019-06-19 16:28
 */
@Controller
@RequestMapping(value = "/categories")
@CrossOrigin
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public AjaxResponder get(HttpServletRequest request, HttpServletResponse response) {
		AjaxResponder result = null;
		List<Category> categories = categoryService.getCategories();
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", categories);
		return result;
	}
}
