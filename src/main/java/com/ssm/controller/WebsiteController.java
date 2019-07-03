package com.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.base.util.AjaxResponder;
import com.ssm.service.ApplicationService;

@CrossOrigin
@Controller
@RequestMapping(value = "/websites")
public class WebsiteController {
	@Autowired
	private ApplicationService applicationService;

	@ResponseBody
	@RequestMapping(value = "/personalInformation/save", method = RequestMethod.POST)
	public AjaxResponder saveWebsiteSetting(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "individualitySignature") String individualitySignature,
			@RequestParam(value = "introduce") String introduce) {
		AjaxResponder result = null;
		System.out.println(name + "," + individualitySignature + "," + introduce);
		applicationService.update(name, individualitySignature, introduce);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", null);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/personalInformation", method = RequestMethod.GET)
	public AjaxResponder getWebsiteSetting(HttpServletRequest request, HttpServletResponse response) {
		AjaxResponder result = null;
		Map<String, String> applicationSetting = applicationService.getApplicationSetting();
		Map<String, String> personalInformation = new HashMap<String, String>();
		for (String key : applicationSetting.keySet()) {
			if (key.equals("name") || key.equals("individualitySignature") || key.equals("introduce")) {
				personalInformation.put(key, applicationSetting.get(key));
			}
		}
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", personalInformation);
		return result;
	}
}
