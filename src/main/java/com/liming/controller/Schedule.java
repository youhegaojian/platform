package com.liming.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liming.domain.ApscTaskDetailSchedule;
import com.liming.domain.ApscTaskSchedule;
import com.liming.service.ApscTaskDefineScheduleService;
import com.liming.service.ApscTaskDetailScheduleService;
import com.liming.service.ApscTaskScheduleService;
import com.liming.utils.JSONResult;
import com.liming.utils.PageUtils;

@Controller
public class Schedule {

    @Autowired
    private ApscTaskDefineScheduleService defineService;
    @Autowired
    private ApscTaskScheduleService service;
    @Autowired
    private ApscTaskDetailScheduleService detailService;

    

//    @RequestMapping("/index")
//    public String index(ModelMap map) {
//        return "thymeleaf/index";
//    }

//    @RequestMapping("/login")
//    public String login(ModelMap map) {
//        return "thymeleaf/login";
//    }

//    @RequestMapping("/console")
//    public String console(ModelMap map) {
//        return "thymeleaf/sche/console";
//    }

    @RequestMapping("/sche/sche_define")
    public String sche_define(ModelMap map) {
        return "thymeleaf/sche/sche_define";
    }

    @RequestMapping("/sche/sche_list")
    public String sche_list(ModelMap map) {
        return "thymeleaf/sche/sche_list";
    }

    @RequestMapping("/sche/detail_list")
    public String detail_list(ModelMap map) {
        return "thymeleaf/sche/detail_list";
    }

//    @RequestMapping("/doLogin")
//    @ResponseBody
//    public JSONResult doLogin(HttpServletRequest request) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        if("admin".equals(username)){
//            if("123456a?".equals(password)){
//            	HttpSession session = request.getSession();
//            	session.setAttribute("username", username);
//                return JSONResult.ok("登陆成功",1);
//            }else{
//                return JSONResult.ok("密码输入有误,请重新输入",1);
//            }
//        }else{
//            return JSONResult.ok("用户名不存在",1);
//        }
//
//    }
    
    @RequestMapping("/logout")
    @ResponseBody
    public void doLogout(HttpServletRequest request, HttpServletResponse response) {

    	try {
	    	HttpSession session = request.getSession(false);
	    	String username = (String) session.getAttribute("username");
	    	if (username != null) {
	    		session.removeAttribute("username");
	    		response.sendRedirect("login");
	    	}
	    	
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

    }


    @RequestMapping("/sche/defineScheList")
    @ResponseBody
    public JSONResult defineScheList(HttpServletRequest request) {
        PageUtils pu = new PageUtils(request);
        return defineService.getList(pu.getPage(),pu.getPageSize());
    }

    @RequestMapping("/sche/ScheList")
    @ResponseBody
    public JSONResult ScheList(HttpServletRequest request) {

        String type = request.getParameter("type");
        PageUtils pu = new PageUtils(request);
        return service.getList(pu.getPage(), pu.getPageSize(),type);
    }

    @RequestMapping("/sche/ScheDetailList")
    @ResponseBody
    public JSONResult ScheDetailList(HttpServletRequest request) {

        String task_id = request.getParameter("task_id");
        PageUtils pu = new PageUtils(request);
        
        return detailService.getList(pu.getPage(), pu.getPageSize(),task_id);
    }
    
    @RequestMapping("/sche/UpdateScheduleState")
    @ResponseBody
    public JSONResult UpdateScheduleState(HttpServletRequest request) {
    	
    	String taskId = request.getParameter("taskId");
    	String state = request.getParameter("state");
    	ApscTaskSchedule apscTaskSchedule=new ApscTaskSchedule();
    	apscTaskSchedule.setTaskId(taskId);
    	apscTaskSchedule.setState(state);
    	boolean succ=service.update(apscTaskSchedule);
    	
    	return JSONResult.ok(succ, 1);
    }
    
    @RequestMapping("/sche/DeleteDetail")
    @ResponseBody
    public JSONResult DeleteDetail(HttpServletRequest request) throws UnsupportedEncodingException {
    	String taskId = request.getParameter("taskId");
    	String fileId =request.getParameter("fileId");
    	String type = request.getParameter("type");
    	String tabName = request.getParameter("tabName");
    	String userId = request.getParameter("userId");
    	
    	ApscTaskDetailSchedule apscTaskDetailSchedule=new ApscTaskDetailSchedule();
    	apscTaskDetailSchedule.setTaskId(taskId);
    	apscTaskDetailSchedule.setFileId(fileId);
    	apscTaskDetailSchedule.setType(type);
    	apscTaskDetailSchedule.setTabName(tabName);
    	apscTaskDetailSchedule.setUserId(userId);
    	boolean succ=detailService.deletebyall(apscTaskDetailSchedule);
    	
    	return JSONResult.ok(succ, 1);
    }




}
