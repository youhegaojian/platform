package com.liming.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.liming.domain.ApscTaskSchedule;
import com.liming.utils.JSONResult;
@Mapper
public interface ApscTaskScheduleService {

    JSONResult getList(int page,int pageSize);
    List<ApscTaskSchedule> getList(String state);
    JSONResult getList(int page,int pageSize,String type);
    JSONResult getListOrderBegin(String state);

    ApscTaskSchedule getDomain(String state);
    ApscTaskSchedule getDomain(String date,String type);

    int insert(ApscTaskSchedule apscTaskSchedule);
    
    void updateByTaskid(ApscTaskSchedule apscTaskSchedule);
    
    boolean update(ApscTaskSchedule apscTaskSchedule);

    String generateId(String type);
    
    void delete(ApscTaskSchedule apscTaskSchedule);

}
