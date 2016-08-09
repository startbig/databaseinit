package com.database.service;
import com.database.po.Order;

import com.database.dao.OrderDao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.utils.PageVo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService {

@Autowired
private OrderDao orderDao;

	public Boolean  insertOrder(Order order){

		Boolean flag=false;
		if(orderDao.insertOrder(order)>0){
		flag=true;
		}
		return flag;
	}

	public Boolean  updateOrder(Order order){

		Boolean flag=false;
		if(orderDao.updateOrder(order)>0){
		flag=true;
		}
		return flag;
	}

	public PageVo  getOrderList(Order order){

		PageVo  pageVo= new PageVo();
		List<Order> list=null;
		list=orderDao.getOrderList(order);
		pageVo.setRoot(list);
		pageVo.setTotal(orderDao.getOrderListCount(order));
		return pageVo;
	}

	public Order  getOrder(String id){

		Order obj =null;
		obj=orderDao.getOrderById(id);
		return obj;
	}

}