package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.base.util.AjaxResponder;
import com.ssm.domain.VisitRecord;
import com.ssm.service.VisitRecordService;

@Controller
@RequestMapping(value = "/visitRecord")
public class VisitRecordController {
	@Autowired
	private VisitRecordService visitRecordService;

	@RequestMapping(value = "/findList")
	public AjaxResponder findList() {
		AjaxResponder result = null;
		List<VisitRecord> list = visitRecordService.getAll(null);
		result = AjaxResponder.getInstance(Boolean.TRUE, "查询成功", list);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "add")
	public AjaxResponder edit(VisitRecord visitRecord) {
		AjaxResponder result = null;
		visitRecordService.add(visitRecord);
		result = AjaxResponder.getInstance(Boolean.TRUE, "创建成功", null);
		return result;
	}

}
