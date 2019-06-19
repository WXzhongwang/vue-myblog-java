package com.ssm.controller;


import java.util.List;

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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.base.util.AjaxResponder;
import com.ssm.domain.Article;
import com.ssm.service.ArticleService;

/**
 * Article Controller
 * @author shengwangzhong
 * @date: 2019-064-19 16:28
 */
@Controller
@RequestMapping(value = "/articles")
@CrossOrigin
public class ArticleController {
	@Autowired 
	ArticleService articleService;
	
	
	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public AjaxResponder add(Article article,HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;
		articleService.addArticle(article);
		article.setThumpUpCount(0);
		article.setVisitRecordCount(0);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", article);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public AjaxResponder get(@PathVariable("id") Integer id){
		AjaxResponder result = null;
		Article article = articleService.getArticle(id);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", article);
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public AjaxResponder edit(@PathVariable("id") Integer id) {
		AjaxResponder result = null;
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", null);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public AjaxResponder delte(@PathVariable("id") Integer id) {
		AjaxResponder result = null;
		
		return result;
	}	

	@ResponseBody
	@RequestMapping(value = "/hot", method = RequestMethod.GET)
	public AjaxResponder getAll(HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;	
		Article article = new Article();
		//article.setIsHot(1);
		List<Article> articles = articleService.getHotArticles(article);		
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", articles);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public AjaxResponder getAll(Article article,HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;		
		List<Article> articles = articleService.getAll(article);		
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", articles);
		return result;
	}
	
	@ResponseBody
	
	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public AjaxResponder findByPage(@RequestParam("page")Integer page, @RequestParam("size")Integer size, HttpServletRequest request,HttpServletResponse response){
		AjaxResponder result = null;		
		System.out.println("Page: " + page + ", Size: " + size);
		PageInfo<Article> articles = articleService.findByPage(page, size, null);		
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", articles);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/sidebar", method=RequestMethod.GET)
	public AjaxResponder get(HttpServletRequest request, HttpServletResponse response){
		AjaxResponder result = null;
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", articleService.getSideBar());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public AjaxResponder getArticleList(HttpServletRequest request, HttpServletResponse response){
		AjaxResponder result = null;
		List<Article> list = articleService.getAll(null);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", list);
		return result;
	}
}
