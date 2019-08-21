package com.liming.service;

import com.liming.utils.JSONResult;

import java.util.List;

import com.liming.domain.ApscTaskDetailSchedule;

/**
 * Copyright: Copyright (c) 2019 liming
 * 
 * @Description: 该类的功能描述
 * @author: ALPHA.GJ.
 * @date: 2019年5月9日 上午8:30:37
 */
public interface ApscTaskDetailScheduleService {

	JSONResult getList(int page, int pageSize);

	JSONResult getList(int page, int pageSize, String task_id);

	void insert(ApscTaskDetailSchedule apscTaskDetailSchedule);

	void update(ApscTaskDetailSchedule apscTaskDetailSchedule);

	List<ApscTaskDetailSchedule> getFinishRecByTaskIdAndFileId(ApscTaskDetailSchedule apscTaskDetailSchedule);

	void updateFinishRecByTaskIdAndFileId(ApscTaskDetailSchedule apscTaskDetailSchedule);

	void delete(ApscTaskDetailSchedule apscTaskDetailSchedule);

	List<ApscTaskDetailSchedule> getTaskDetailScheduleList(ApscTaskDetailSchedule apscTaskDetailSchedule);

	boolean deletebyall(ApscTaskDetailSchedule apscTaskDetailSchedule);

	List<ApscTaskDetailSchedule> getList(ApscTaskDetailSchedule apscTaskDetailSchedule);
	
	List<ApscTaskDetailSchedule> getyData(ApscTaskDetailSchedule apscTaskDetailSchedule);
	
	List<ApscTaskDetailSchedule> getBarData(ApscTaskDetailSchedule apscTaskDetailSchedule);
	
	List<ApscTaskDetailSchedule> getMonth();
}
