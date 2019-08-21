package com.liming.domain;

import javax.persistence.*;

@Table(name = "apsc_task_define_schedule")
public class ApscTaskDefineSchedule {
    /**
     * 任务类型     
     */
    private String type;

    /**
     * 任务名称
     */
    @Column(name = "task_name")
    private String taskName;

    /**
     * 调用的类名称
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 调用的类方法名称
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 周期
     */
    private String period;

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
     * 获取任务名称
     *
     * @return task_name - 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名称
     *
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 获取调用的类名称
     *
     * @return class_name - 调用的类名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置调用的类名称
     *
     * @param className 调用的类名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取调用的类方法名称
     *
     * @return method_name - 调用的类方法名称
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置调用的类方法名称
     *
     * @param methodName 调用的类方法名称
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取周期
     *
     * @return period - 周期
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置周期
     *
     * @param period 周期
     */
    public void setPeriod(String period) {
        this.period = period;
    }
}