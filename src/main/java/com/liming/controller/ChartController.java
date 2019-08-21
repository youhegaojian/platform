package com.liming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liming.domain.ApscTaskDetailSchedule;
import com.liming.service.ApscTaskDetailScheduleService;

@Controller
public class ChartController {

	@Autowired
	private ApscTaskDetailScheduleService apscTaskDetailScheduleService;

	@RequestMapping("/chart/echarts_line")
	public String echarts_line() {
		return "thymeleaf/chart/echarts_line";
	}

	@RequestMapping("/chart/echarts_line_list")
	@ResponseBody
	public Map<String, Object> echarts1(HttpServletRequest request) {
		Map<String, Object> maps = new HashMap<String, Object>();
		ApscTaskDetailSchedule apsc=new ApscTaskDetailSchedule();
		String month=request.getParameter("month");
		apsc.setMonth(month);
		List<ApscTaskDetailSchedule> detailList = apscTaskDetailScheduleService.getList(apsc);
		List<ApscTaskDetailSchedule> yList = apscTaskDetailScheduleService.getyData(apsc);
		List<ApscTaskDetailSchedule> monthList=apscTaskDetailScheduleService.getMonth();
		maps.put("monthList", monthList);
		maps.put("detailList", detailList);
		maps.put("yList", yList);
		return maps;
	}

	@RequestMapping("/chart/echarts_bar_list")
	@ResponseBody
	public List<ApscTaskDetailSchedule> echarts_bar(HttpServletRequest request) {
		ApscTaskDetailSchedule apsc = new ApscTaskDetailSchedule();
		String time = request.getParameter("time");
		String tpye = request.getParameter("type");
		apsc.setTime(time);
		apsc.setType(tpye);
		List<ApscTaskDetailSchedule> list = apscTaskDetailScheduleService.getBarData(apsc);
		return list;
	}
}
