package com.database.handler;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;import com.database.utils.PageVo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.database.po.Order;
import com.database.service.OrderService;
import com.database.utils.HandlerBase;
import com.database.utils.Constant;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/order")
public class OrderHandler  extends HandlerBase{
	private PageVo pageVo = new PageVo();
	@Resource 
	private OrderService orderService;

	@RequestMapping("/getOrderList")
	@ResponseBody
	public PageVo getOrderList(Integer page,Integer limit, Order order){
		if(order==null){
			order=new Order();
		}
		order.setPageSize(limit);
		order.setCurrPage(page);
		pageVo=orderService.getOrderList(order);
		pageVo.setSuccess(true);
		return pageVo;
	}
	@RequestMapping("/insertOrder")
	@ResponseBody
	public PageVo insertOrder(Order order){
		pageVo = new PageVo();
		String userName=Constant.getUserName(request);
		order.setCreateUser(userName);
		boolean success=orderService.insertOrder(order);
		pageVo.setSuccess(success);
		return pageVo;
	}
	@RequestMapping("/updateOrder")
	@ResponseBody
	public PageVo updateOrder(Order order){
		pageVo = new PageVo();
		boolean success=orderService.updateOrder(order);
		pageVo.setSuccess(success);
		return pageVo;
	}
}