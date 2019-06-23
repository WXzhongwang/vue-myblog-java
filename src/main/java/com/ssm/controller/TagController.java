package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.base.util.AjaxResponder;
import com.ssm.domain.Tag;
import com.ssm.service.TagService;


@CrossOrigin
@Controller
@RequestMapping(value = "/tags")
public class TagController {
	@Autowired
	TagService tagService;
	
	@ResponseBody
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public AjaxResponder getAllTags(HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", tagService.getAll());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/test/test", method=RequestMethod.GET)
	public AjaxResponder test(HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", "test");
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/new/save", method=RequestMethod.POST)
	public AjaxResponder saveTag(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="name")String name,
			@RequestParam(value="description")String description
			){
		AjaxResponder result = null;	
		Tag tag = new Tag();
		tag.setName(name);
		tag.setDescription(description);
		tagService.addTag(tag);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", null);
		return result;
	}
}
