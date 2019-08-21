package com.liming.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.liming.utils.DateUtils;

@Table(name = "apsc_task_schedule")
public class ApscTaskSchedule {
    /**
     * 主键         
     */
    @Column(name = "task_id")
    @Id
    private String taskId;

    /**
     * 任务类型     
     */
    private String type;

    /**
     * 状态         
     */
    private String state;

    /**
     * 任务开始时间 
     */
    @Column(name = "begin_time")
    private String beginTime;

    /**
     * 任务结束时间 
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 任务id
     */
    private String taskid;
    public ApscTaskSchedule() {
		
	}
    public ApscTaskSchedule(String type,String task_id){
        String state = "2";
        String begin_time = DateUtils.getCurrDateTimeStr();

        this.taskId = task_id;
        this.state = state;
        this.beginTime = begin_time;
        this.type = type;
    }



    /**
     * 获取主键         
     *
     * @return task_id - 主键         
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置主键         
     *
     * @param taskId 主键         
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取任务类型     
     *
     * @return type - 任务类型     
     */
    public String getType() {
        return type;
    }

    /**
     * 设置任务类型     
     *
     * @param type 任务类型     
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取状态         
     *
     * @return state - 状态         
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态         
     *
     * @param state 状态         
     */
    public void setState(String state) {
        this.state = state;
    }


    /**
     * 获取任务开始时间 
     *
     * @return begin_time - 任务开始时间 
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * 设置任务开始时间 
     *
     * @param beginTime 任务开始时间 
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取任务结束时间 
     *
     * @return end_time - 任务结束时间 
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置任务结束时间 
     *
     * @param endTime 任务结束时间 
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取任务id
     *
     * @return taskid - 任务id
     */
    public String getTaskid() {
        return taskid;
    }

    /**
     * 设置任务id
     *
     * @param taskid 任务id
     */
    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
}