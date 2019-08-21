package com.liming.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liming.domain.ApscTaskSchedule;
import com.liming.service.ApscTaskScheduleService;
import com.liming.thread.ScheduleThread;

/**
 * @author ALPHA.GJ
 * @date 创建时间：2019年3月25日 下午6:29:26
 * @version 1.0
 **/
@Controller
public class JobController {

	@Autowired
	private ApscTaskScheduleService apscScheduleService;

	@RequestMapping("/sche/addTask")
    @ResponseBody
	protected ApscTaskSchedule addTask(HttpServletRequest request) throws Exception {
		String type = request.getParameter("type");
		String taskId = request.getParameter("taskid");

		String task_id = apscScheduleService.generateId(type);
		ApscTaskSchedule apscTaskSchedule = new ApscTaskSchedule(type,task_id);
		String state = "1";
		apscTaskSchedule.setState(state);
		apscTaskSchedule.setTaskid(taskId);
		apscScheduleService.insert(apscTaskSchedule);

		ScheduleThread st = new ScheduleThread();
		st.start();
		return apscTaskSchedule;
	}

}
