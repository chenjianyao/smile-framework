package com.smile.demo.controller;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smileframework.quartz.dynamic.http.HttpQuartzJobFactoryDisallowConcurrentExecution;
import com.smileframework.quartz.dynamic.http.HttpQuartzManager;

@RestController
@RequestMapping("/quartz")
public class QuartzController {
	private final ModelMap MODELMAP = new ModelMap().addAttribute("status", "1").addAttribute("code", "00000000")
			.addAttribute("msg", "操作成功!");

	@Resource
	private HttpQuartzManager httpQuartzManager;

	@RequestMapping("/startJobs")
	public ModelMap startJobs() {
		httpQuartzManager.startJobs();
		return MODELMAP;
	}

	@RequestMapping("/shutdownJobs")
	public ModelMap shutdownJobs() {
		httpQuartzManager.shutdownJobs();
		return MODELMAP;
	}

	@RequestMapping("/add/{no}")
	public ModelMap add(@PathVariable String no) {
		httpQuartzManager.addJob("jobName" + no, "jobGroupName" + no, "triggerName" + no, "triggerGroupName" + no,
				HttpQuartzJobFactoryDisallowConcurrentExecution.class, "0/2 * * ? * *");
		return MODELMAP;
	}

	@RequestMapping("/remove/{no}")
	public ModelMap remove(@PathVariable String no) {
		httpQuartzManager.removeJob("jobName" + no, "jobGroupName" + no, "triggerName" + no, "triggerGroupName" + no);
		return MODELMAP;
	}

	@RequestMapping("/modify/{no}")
	public ModelMap modify(@PathVariable String no) {
		httpQuartzManager.modifyJobTime("jobName" + no, "jobGroupName" + no, "triggerName" + no, "triggerGroupName" + no,
				"0/5 * * ? * *");
		return MODELMAP;
	}

}
