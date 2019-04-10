package com.syxt.dao;

import java.util.List;
import java.util.Set;



public interface IDAO<K,V>{
	
	public boolean doCreate(V vo)throws Exception;
	
	public boolean doUpdate(V vo)throws Exception;
	
	public boolean doRemoveBatch(Set<K>ids)throws Exception;
	
	public V findById(K id)throws Exception;
	
	public List<V>findAll()throws Exception;
	
	public List<V>findAllSplit(Integer currentPage,Integer lineSize,String column,String keyWord)throws Exception;
	
	public Integer findAllCount(String column,String keyWord)throws Exception;

}
