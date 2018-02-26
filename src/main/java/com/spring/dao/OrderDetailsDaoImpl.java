package com.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.spring.model.oderDetail;

@Repository("orderDetailsDao")
public class OrderDetailsDaoImpl extends AbstractDao<Integer, oderDetail> implements OrderDetailsDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<oderDetail> getOrderDetails(Integer id) {
		String string = "Select * from orderdetail ";
		if(id != null) {
			string = string + " where OrderID = :idsearch ";
		}
		SQLQuery query = getSession().createSQLQuery(string);
		if(id !=null) query.setParameter("idsearch", id);
		query.addEntity(oderDetail.class);
		List<oderDetail> list = query.list();
		return list;
	}

	@Override
	public void delete(int oid, int pid) {
		Query query = getSession().createSQLQuery("delete from orderdetail where OrderID = :oid and ProductID = :pid ");
		query.setInteger("oid", oid);
		query.setInteger("pid", pid);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public oderDetail getDetail(int oid, int pid) {
		String string = "Select * from orderdetail  where OrderID = :oid and ProductID = :pid ";
		SQLQuery query = getSession().createSQLQuery(string);
		query.setParameter("oid", oid);
		query.setParameter("pid", pid);
		query.addEntity(oderDetail.class);
		List<oderDetail> list = query.list();
		return list.get(0);
	}

	@Override
	public void save(oderDetail odr) {
		super.saveOrUpdate(odr);
	}

}
