package com.database.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.dao.CustomerDao;
import com.database.po.Customer;
import com.database.po.CustomerRecord;
import com.database.utils.PageVo;

@Service
public class CustomerService {


@Autowired
private CustomerDao customerDao;

	public Boolean  insertCustomer(Customer customer){

		Boolean flag=false;
		if(customerDao.insertCustomer(customer)>0){
		flag=true;
		}
		return flag;
	}

	public Boolean  updateCustomer(Customer customer){

		Boolean flag=false;
		if(customerDao.updateCustomer(customer)>0){
		flag=true;
		}
		return flag;
	}

	public PageVo  getCustomerList(Customer customer){

		PageVo  pageVo= new PageVo();
		List<Customer> list=null;
		list=customerDao.getCustomerList(customer);
		pageVo.setRoot(list);
		pageVo.setTotal(customerDao.getCustomerListCount(customer));
		return pageVo;
	}

	public Customer  getCustomer(String id){

		Customer obj =null;
		obj=customerDao.getCustomerById(id);
		return obj;
	}
	
	public PageVo  getCustomerRecordList(CustomerRecord customerRecord){

		PageVo  pageVo= new PageVo();
		List<CustomerRecord> list=null;
		list=customerDao.getCustomerRecordList(customerRecord);
		pageVo.setRoot(list);
		pageVo.setTotal(customerDao.getCustomerRecordListCount(customerRecord));
		return pageVo;
	}

}