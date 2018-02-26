package com.spring.dao;

import java.util.List;

import com.spring.model.oderDetail;


public interface OrderDetailsDao {
	List<oderDetail> getOrderDetails(Integer id);
	void delete(int oid,int pid);
	oderDetail getDetail(int oid,int pid);
	void save(oderDetail odr);
}
