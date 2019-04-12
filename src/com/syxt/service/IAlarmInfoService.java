package com.syxt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.syxt.vo.AlarmInfo;


public interface IAlarmInfoService {
   
	public boolean insert(AlarmInfo vo)throws Exception;
	
	public boolean update(AlarmInfo vo)throws Exception;
   
	public boolean delete(Set<Integer> ids)throws Exception;
	
	public AlarmInfo get(int id)throws Exception;
	
	public List<AlarmInfo> list() throws Exception;
	
	public Map<String,Object>list(int currentPage,int lineSize,String column,String keyWord)throws Exception;
}
