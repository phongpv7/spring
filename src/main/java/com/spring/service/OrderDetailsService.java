package com.spring.service;

import java.util.List;

import com.spring.model.oderDetail;

public interface OrderDetailsService {
	List<oderDetail> getOrderDetails(Integer id);
	
	void delete(int oid,int pid);
	
	oderDetail getDetail(int oid,int pid);
	
	void save(oderDetail odr);
}
