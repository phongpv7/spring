package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.OrderDetailsDao;
import com.spring.model.oderDetail;
@Service("orderDetailsService")
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	private OrderDetailsDao dao;
	
	@Override
	public List<oderDetail> getOrderDetails(Integer id) {
		return dao.getOrderDetails(id);
	}

	@Override
	public void delete(int oid, int pid) {
		dao.delete(oid,pid);
	}

	@Override
	public oderDetail getDetail(int oid, int pid) {
		return dao.getDetail(oid,pid);
	}

	@Override
	public void save(oderDetail odr) {
		dao.save(odr);
	}

}
