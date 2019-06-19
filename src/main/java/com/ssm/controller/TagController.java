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

/**
 * Blog Controller
 * @author shengwangzhong
 * @date: 2019-064-19 16:28
 */
@Controller
@RequestMapping(value = "/tags")
@CrossOrigin
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
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public AjaxResponder saveTag(@RequestBody Tag tag, HttpServletRequest request, HttpServletResponse response){
		AjaxResponder result = null;	
		System.out.println(tag.getName());
		tagService.addTag(tag);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", null);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public AjaxResponder get(@PathVariable("id") Integer id){
		AjaxResponder result = null;
		
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public AjaxResponder edit(@PathVariable("id") Integer id) {
		AjaxResponder result = null;
		
		return result;
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public AjaxResponder delte(@PathVariable("id") Integer id) {
		AjaxResponder result = null;
		
		return result;
	}	
}
