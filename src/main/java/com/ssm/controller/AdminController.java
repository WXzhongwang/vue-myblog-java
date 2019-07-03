package com.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.base.util.AjaxResponder;
import com.ssm.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
@CrossOrigin
public class AdminController {
	@Resource
	private AdminService adminService;

	@ResponseBody
	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public AjaxResponder checkLogin(HttpServletRequest request, HttpServletResponse response) {
		AjaxResponder result = null;
		try {
			boolean flag = adminService.adminLogin();
			result = AjaxResponder.getInstance(Boolean.TRUE, "登录成功", true);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = AjaxResponder.getInstance(Boolean.TRUE, "登录成功", false);
		}
		return result;
	}
}
