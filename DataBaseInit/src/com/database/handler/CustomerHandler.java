package com.database.handler;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;import com.database.utils.PageVo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.database.po.Customer;
import com.database.service.CustomerService;
import com.database.utils.HandlerBase;
import com.database.utils.Constant;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/customer")
public class CustomerHandler  extends HandlerBase{
	private PageVo pageVo = new PageVo();
	@Resource 
	private CustomerService customerService;

	@RequestMapping("/getCustomerList")
	@ResponseBody
	public PageVo getCustomerList(Integer page,Integer limit, Customer customer){
		if(customer==null){
			customer=new Customer();
		}
		customer.setPageSize(limit);
		customer.setCurrPage(page);
		pageVo=customerService.getCustomerList(customer);
		pageVo.setSuccess(true);
		return pageVo;
	}
	@RequestMapping("/insertCustomer")
	@ResponseBody
	public PageVo insertCustomer(Customer customer){
		pageVo = new PageVo();
		String userName=Constant.getUserName(request);
		customer.setCreateUser(userName);
		boolean success=customerService.insertCustomer(customer);
		pageVo.setSuccess(success);
		return pageVo;
	}
	@RequestMapping("/updateCustomer")
	@ResponseBody
	public PageVo updateCustomer(Customer customer){
		pageVo = new PageVo();
		String userName=Constant.getUserName(request);
		customer.setUpdateUser(userName);
		boolean success=customerService.updateCustomer(customer);
		pageVo.setSuccess(success);
		return pageVo;
	}
}