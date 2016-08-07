package com.database.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.database.po.Gene;
import com.database.po.GeneExport;
import com.database.po.User;
import com.database.service.GeneExportService;
import com.database.service.GeneService;
import com.database.utils.ExportExcel;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;
@Controller
@RequestMapping("/down")
public class FileDownloadHandler extends HandlerBase {
	@Resource
	private GeneService geneService;
	@Resource
	private GeneExportService geneExportService;
	private PageVo pageVo = new PageVo();
	@RequestMapping("/GeneExcel")
	public void GeneExcel(Integer page,Integer limit,  Gene gene) throws IOException{
	     User loginUser = (User) request.getSession().getAttribute("loginUser");  
		 String loginName=loginUser.getLoginName();
		 
			GeneExport insertExport=new GeneExport();
			insertExport.setCreateUser(loginName);
			insertExport.setExportNum(20);
			insertExport.setCreateTime(new Date());
			geneExportService.insertGeneExport(insertExport);
//		if(gene==null){
//			gene=new Gene();
//		}
//		gene.setPageSize(limit);
//		gene.setCurrPage(page);
//		pageVo=geneService.selectGeneList(gene);
////		boolean flag=	geneService.isExport(gene, loginName);
//		OutputStream os = response.getOutputStream();
//		// 设置默认文件名为当前时间：年月日时分秒
//		String	fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()).toString();
//		response.reset();
//		response.setContentType("application/vnd.ms-excel"); // 改成输出excel文件
//		response.setHeader("Content-disposition", "attachment; filename="+ fileName + ".xls");
//	    ExportExcel.excelExportGenu(pageVo.getRoot(),os);

	}
//	public String downloadGeneExcel() throws WriteException, JsonParseException, JsonMappingException, IOException{
//		
//		 User user=(User) session.get(Constant.LOGINUSER);
//		   String loginName=user.getLoginName();
//		if(gene==null){
//			gene= new UGene();
//			}
//			gene.setCurrPage(page);
//			gene.setPageSize(limit);
//		boolean flag=	geneService.isExport(gene, loginName);
//		if(flag){
//		    path=ExportExcel.excelExportGenu( geneService.getUGeneList(gene).getRoot());
//			String userAgent = request.getHeader("User-Agent");
//			return FileUtils.downloadExcel(path,response,userAgent);	
//		}else{
//			   response.setContentType("text/html");
//			   response.getWriter().print("{success:false,msg:导出数据已经超出1000条");
//			return null;
//		}
}
