package com.database.dao;
import com.database.po.Order;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

public int  insertOrder(Order order);

public int  updateOrder(Order order);

public List<Order>  getOrderList(Order order);

public int  getOrderListCount(Order order);

public Order  getOrderById(String id);

}