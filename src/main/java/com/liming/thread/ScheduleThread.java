package com.liming.thread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liming.domain.ApscTaskSchedule;
import com.liming.service.ApscTaskScheduleService;
import com.liming.utils.DateUtils;
import com.liming.utils.SpringUtils;

/**
 * @author ALPHA.GJ
 * @date 创建时间：2019年3月29日 下午2:25:16
 * @version 1.0
 **/
@Component
public class ScheduleThread extends Thread {

	@Autowired
	private ApscTaskScheduleService apscScheduleService;

	public ScheduleThread() {
		
	}

	public void run() {
		// 循环判断
		// 查询数据库有没有正在排队的数据，获取数据
		System.out.println("--------开始循环查询...");
		// 获取正在计算中的任务列表
		apscScheduleService = SpringUtils.getBean("apscTaskScheduleService");
		String state = "2";
		List<ApscTaskSchedule> scheList = apscScheduleService.getList(state);

		if (scheList.size() < 1) {
//			如果正在计算中的任务小于 1,查询处于 等待执行中的任务。
			state = "1";
			List<ApscTaskSchedule> _scheList = apscScheduleService.getList(state);

			if (_scheList != null && _scheList.size() > 0) {
				ApscTaskSchedule apscTaskSchedule = _scheList.get(0);
				String type = apscTaskSchedule.getType();

				try {
					boolean flag = toExecTask(apscTaskSchedule,type);
					// 调用执行方法
					if (flag) {
						this.run();
					} else {
						// 更新数据，将状态改为计算出错
						apscTaskSchedule.setState("3");
						apscTaskSchedule.setEndTime(DateUtils.getCurrDateTimeStr());
						apscScheduleService.updateByTaskid(apscTaskSchedule);
						this.run();
					}
				} catch (Exception e) {
					// 更新数据，将状态改为计算出错
					apscTaskSchedule.setState("3");
					apscTaskSchedule.setEndTime(DateUtils.getCurrDateTimeStr());
					apscScheduleService.updateByTaskid(apscTaskSchedule);

					this.run();
					e.printStackTrace();
				}
			} else {
				System.out.println("没有等待处理的任务....");
			}
		} else {
			System.out.println("有1个任务正在计算，请稍后....");
		}

	}

	public synchronized boolean toExecTask(ApscTaskSchedule apscTaskSchedule, String type) {
		boolean flag = false;
		try {
			System.out.println("---线程");
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
