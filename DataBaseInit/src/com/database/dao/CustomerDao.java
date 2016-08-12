package com.database.dao;
import com.database.po.Customer;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {

public int  insertCustomer(Customer customer);

public int  updateCustomer(Customer customer);

public List<Customer>  getCustomerList(Customer customer);

public int  getCustomerListCount(Customer customer);

public Customer  getCustomerById(String id);

}