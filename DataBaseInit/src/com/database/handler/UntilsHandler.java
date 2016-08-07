package com.database.handler;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.database.dao.allmutDao;
import com.database.po.Answer;
import com.database.po.Gene;
import com.database.po.Question;
import com.database.po.User;
import com.database.po.allmut;
import com.database.service.GeneService;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;
import com.database.utils.UtilsExcel;

@Controller
public class UntilsHandler extends HandlerBase {
	 @Resource  
	private GeneService geneService;
	 @Resource  
	 private  allmutDao dao;
	private PageVo pageVo = new PageVo();
	@RequestMapping("/analysisExcel")
	@ResponseBody
	public PageVo analysisExcel(@RequestParam(value = "file", required = false)MultipartFile file) throws IOException {
		  List<Gene> list=UtilsExcel.readExcelByGene(file.getInputStream());
		  
		   Gene  data=null;
		   User loginUser = (User) request.getSession().getAttribute("loginUser");  
		   Map map =null;
		   for (int i = 0; i < list.size(); i++) {
			   map =new HashMap();
			   data=list.get(i);
			   map.put("chip",data.getChip());
			   map.put("sampleNum",data.getSampleNum());
			   map.put("geneticMode",data.getGeneticMode());
			   map.put("gene",data.getGene());
			   map.put("sequence",data.getSequence());
			   map.put("nucleotide",data.getNucleotide());
			   map.put("aminophenol",data.getAminophenol());
			   map.put("geneRegion",data.getGeneRegion());
			   map.put("chromosome",data.getChromosome());
			   map.put("rsnum",data.getRsnum());
			   map.put("dbindel",data.getDbindel());
			   map.put("hapmap",data.getHapmap());
			   map.put("frequency",data.getFrequency());
			   map.put("localFrequency",data.getLocalFrequency());
			   map.put("featureChange",data.getFeatureChange());
			   map.put("mutationType",data.getMutationType());
			   map.put("literature",data.getLiterature());
			   map.put("siteRemark",data.getSiteRemark());
			   map.put("remark",data.getRemark());
			   map.put("diseasePhenotype",data.getDiseasePhenotype());
			   map.put("userName", loginUser.getUserName());
			   map.put("flag", "true");
			   System.out.println(i);
			   geneService.insertGeneList(map);
			
		}
		pageVo.setSuccess(true);
		return pageVo;  
	}
	@RequestMapping("/getQuestion")
	@ResponseBody
	public List<Question> getQuestion(){
		List<Question> list=new ArrayList<Question>();
		Question q=new Question();
		q.setQuestion("问题1");
		Answer a=new Answer();
		a.setAnswerOne("答案1");
		a.setAnswerTow("答案1");
		a.setAnswerThree("答案1");
		a.setAnswerFour("答案1");
		q.setAnswer(a);
		
		Question q2=new Question();
		q2.setQuestion("问题1");
		q2.setAnswer(a);
		list.add(q);
		list.add(q2);
		return  list;
	}
	@RequestMapping("/datainfo")
    public void dataDeal() throws Exception{
		int i=1;
    	List<allmut>  list=dao.selectallmutList();
    	for (allmut all:list) {
    		testProcNoOut(all);
    		System.out.println(i);
    		i++;
		}
    	System.out.println("操作完成");
    }
    
    public static void testProcNoOut(allmut a) throws Exception {  
        Connection conn = null;  
        CallableStatement callStmt = null;  
        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.34.128:1521:orcl", "test", "wrnmdppo");  
            // 存储过程 TEST_MICHAEL_NOOUT 其实是向数据库插入一条数据  
            callStmt = conn.prepareCall("{call date_synchro(?,?,?,?,?,?,?,?,?,?,?,?,?)}");  
   
            // 参数index从1开始，依次 1,2,3...  
            callStmt.setString(1, a.getDisease());  
            callStmt.setString(2, a.getGene());  
            callStmt.setString(3,a.getDescr() );  
            callStmt.setString(4, a.getDbsnp());  
            callStmt.setString(5, a.getHgvs());  
            callStmt.setString(6, a.getRefseq());  
            callStmt.setString(7, a.getOmimid());  
            callStmt.setString(8, a.getMaffreq());  
            callStmt.setString(9, a.getWenxian());  
            callStmt.setString(10, a.getGene_hagvs());  
            callStmt.setString(11, a.getChromosome());  
            callStmt.setString(12, a.getTag());  
            callStmt.setString(13, a.getComments());  
            callStmt.execute();  
        } catch (Exception e) {  
            e.printStackTrace(System.out);  
        } finally {  
            if (null != callStmt) {  
                callStmt.close();  
            }  
            if (null != conn) {  
                conn.close();  
            }  
        }  
    }  
}
