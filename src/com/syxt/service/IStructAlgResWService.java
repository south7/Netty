package com.syxt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.syxt.vo.StructAlgResW;


public interface IStructAlgResWService {
   
	public boolean insert(StructAlgResW vo)throws Exception;
	
	public boolean update(StructAlgResW vo)throws Exception;
   
	public boolean delete(Set<Integer> ids)throws Exception;
	
	public StructAlgResW get(int id)throws Exception;
	
	public List<StructAlgResW> list() throws Exception;
	
	public Map<String,Object>list(int currentPage,int lineSize,String column,String keyWord)throws Exception;
}
