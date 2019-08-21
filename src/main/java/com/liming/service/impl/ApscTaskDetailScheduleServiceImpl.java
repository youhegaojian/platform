package com.liming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liming.domain.ApscTaskDetailSchedule;
import com.liming.domain.ApscTaskSchedule;
import com.liming.mapper.ApscTaskDetailScheduleMapper;
import com.liming.service.ApscTaskDetailScheduleService;
import com.liming.utils.JSONResult;

import tk.mybatis.mapper.entity.Example;

/**
 * Copyright: Copyright (c) 2019 liming
 * 
 * @Description: 该类的功能描述
 * @author: ALPHA.GJ.
 * @date: 2019年5月9日 上午8:31:43
 */
@Service
public class ApscTaskDetailScheduleServiceImpl implements ApscTaskDetailScheduleService {

	@Autowired
	private ApscTaskDetailScheduleMapper mapper;

	@Override
	public JSONResult getList(int page, int pageSize) {
		// 开始分页
		PageHelper.startPage(page, pageSize);
		Example example = new Example(ApscTaskDetailSchedule.class);
		List<ApscTaskDetailSchedule> list = mapper.selectByExample(example);
		PageInfo<ApscTaskDetailSchedule> pageInfo = new PageInfo<>(list);
		return JSONResult.ok(list, pageInfo.getTotal());
	}

	@Override
	public JSONResult getList(int page, int pageSize, String task_id) {
		// 开始分页
		PageHelper.startPage(page, pageSize);
		Example example = new Example(ApscTaskDetailSchedule.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("taskId", task_id);
		example.orderBy("beginTime").desc();
		List<ApscTaskDetailSchedule> list = mapper.selectByExample(example);
		PageInfo<ApscTaskDetailSchedule> pageInfo = new PageInfo<>(list);
		return JSONResult.ok(list, pageInfo.getTotal());
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void insert(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		mapper.insert(apscTaskDetailSchedule);

	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void update(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		mapper.updateByKey(apscTaskDetailSchedule);

	}

	@Override
	public List<ApscTaskDetailSchedule> getFinishRecByTaskIdAndFileId(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		/*
		 * select finish_rec from apsc_task_detail_schedule where task_id=" +
		 * sche.getDetail_sche_list().get(0).get("task_id") + " and file_id=" +
		 * sche.getDetail_sche_list().get(0).get("file_id");
		 */
		ApscTaskDetailSchedule atds = new ApscTaskDetailSchedule();
		atds.setTaskId(apscTaskDetailSchedule.getTaskId());
		atds.setFileId(apscTaskDetailSchedule.getFileId());
		Example example = new Example(ApscTaskDetailSchedule.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo(atds);
		List<ApscTaskDetailSchedule> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void updateFinishRecByTaskIdAndFileId(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		/*
		 * update apsc_task_detail_schedule set finish_rec='" + c2 + "',sum_rec='" + sum
		 * + "' where task_id=" + sche.getDetail_sche_list().get(0).get("task_id") +
		 * " and file_id=" + sche.getDetail_sche_list().get(0).get("file_id");
		 */
		ApscTaskDetailSchedule atds = new ApscTaskDetailSchedule();
		atds.setFinishRec(apscTaskDetailSchedule.getFinishRec());
		atds.setSumRec(apscTaskDetailSchedule.getSumRec());
		Example example = new Example(ApscTaskDetailSchedule.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("finishRec", apscTaskDetailSchedule.getFinishRec());
		criteria.andEqualTo("sumRec", apscTaskDetailSchedule.getSumRec());

		mapper.updateByExampleSelective(atds, example);

	}

	@Override
	public List<ApscTaskDetailSchedule> getTaskDetailScheduleList(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		Example example = new Example(ApscTaskDetailSchedule.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("taskId", apscTaskDetailSchedule.getTaskId());
		criteria.andEqualTo("fileId", apscTaskDetailSchedule.getFileId());
		List<ApscTaskDetailSchedule> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public void delete(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(apscTaskDetailSchedule.getTaskId());
	}

	@Override
	public boolean deletebyall(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		Example example = new Example(ApscTaskDetailSchedule.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("taskId", apscTaskDetailSchedule.getTaskId());
		criteria.andEqualTo("fileId", apscTaskDetailSchedule.getFileId());
		criteria.andEqualTo("type", apscTaskDetailSchedule.getType());
		criteria.andEqualTo("tabName", apscTaskDetailSchedule.getTabName());
		criteria.andEqualTo("userId", apscTaskDetailSchedule.getUserId());
		int result = mapper.deleteByExample(example);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ApscTaskDetailSchedule> getList(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		List<ApscTaskDetailSchedule> list = mapper.getList(apscTaskDetailSchedule);
		return list;
	}

	@Override
	public List<ApscTaskDetailSchedule> getyData(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		List<ApscTaskDetailSchedule> list = mapper.getyData(apscTaskDetailSchedule);
		return list;
	}

	@Override
	public List<ApscTaskDetailSchedule> getBarData(ApscTaskDetailSchedule apscTaskDetailSchedule) {
		List<ApscTaskDetailSchedule> list = mapper.getBarData(apscTaskDetailSchedule);
		return list;
	}

	@Override
	public List<ApscTaskDetailSchedule> getMonth() {
		List<ApscTaskDetailSchedule> list = mapper.getMonth();
		return list;
	}
}
