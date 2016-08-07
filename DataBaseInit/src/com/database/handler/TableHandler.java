package com.database.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.Table;
import com.database.po.TableColumn;
import com.database.service.TableColumnService;
import com.database.service.TableService;
import com.database.utils.Constant;
import com.database.utils.CreatSql;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/table")
public class TableHandler extends HandlerBase{
	private PageVo pageVo = new PageVo();
    @Resource  
    private TableService tableService;
    @Resource  
    private TableColumnService tableColumnService;
    

	@RequestMapping("/selectTableList")
	@ResponseBody
	public PageVo selectTableList(Integer page,Integer limit, Table record){
		if(record==null){
			record=new Table();
		}
		record.setPageSize(limit);
		record.setCurrPage(page);
		pageVo=tableService.selectTableList(record);
		pageVo.setSuccess(true);
		return pageVo;
	}
	
	@RequestMapping("/selectTableColumnList")
	@ResponseBody
	public PageVo selectTableColumnList(Integer page,Integer limit, TableColumn record){
		if(record==null){
			record=new TableColumn();
		}
		record.setPageSize(limit);
		record.setCurrPage(page);
		pageVo=tableColumnService.selectTableColumnList(record);
		pageVo.setSuccess(true);
		return pageVo;
	}
	
	@RequestMapping("/insertTableList")
	@ResponseBody
	public PageVo insertTableList(@RequestBody Table record){
	    String id=Constant.getUUID();
		String sql=CreatSql.getCreatTableSql(record.getTableName(), record.getTableComment(), record.getTableColumn());
		tableService.createTable(sql);
		record.setId(id);
		record.setCreateUser(Constant.getUserName(request));
		tableService.insertTable(record);
		for (int i = 0; i <record.getTableColumn().size(); i++) {
			record.getTableColumn().get(i).setTableId(id);
			TableColumn table=record.getTableColumn().get(i);
			table.setTableId(id);
			tableColumnService.insertTableColumn(table);
		}
		pageVo.setSuccess(true);
		return pageVo;
	}
}
