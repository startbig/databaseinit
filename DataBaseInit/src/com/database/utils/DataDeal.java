package com.database.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.po.allmut;

public class DataDeal {
 
	  

 
	    public static void main(String[] args) throws Exception {  
	    	int i=1;
	      String  sql = "	select a.disease,a.gene,CONCAT('p.',a.descr) as descr,a.dbsnp,CONCAT('c.',a.hgvs) as hgvs,"
	      		+ "al.refseq,al.omimid,db.MAFfreq as maffreq,CONCAT('PMID:',pmid,char(10),get_data(a.acc_num)) as "
	      		+ "wenxian,CONCAT(a.gene,' ',CONCAT('c.',a.hgvs)) as gene_hagvs,(case when a.chromosome is not null "
	      		+ "and  a.startCoord is not null and a.endCoord is not null and   a.startCoord=a.endCoord then "
	      		+ "CONCAT(CONCAT('chr',a.chromosome,':'),a.startCoord) when a.chromosome is not null and  "
	      		+ "a.startCoord is not null and a.endCoord is not null and  a.startCoord!=a.endCoord then "
	      		+ "CONCAT(CONCAT('chr',a.chromosome,':'),a.startCoord,'..',a.endCoord)  else null end) as "
	      		+ "chromosome,a.tag,a.comments from  allmut a left join allgenes al on(a.gene=al.gene) "
	      		+ "left join dbsnp db on(a.acc_num=db.hgmd_acc) limit 12800,179235";//SQL语句  
	      Class.forName("com.mysql.jdbc.Driver"); 
	      Connection   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hgmd_pro?characterEncoding=utf8", "root", "wrnmdppo");
	        PreparedStatement  pst = conn.prepareStatement(sql);//准备执行语句  
	        try {  
	        	ResultSet   ret = pst.executeQuery();//执行语句，得到结果集  
	        	allmut a=null;
	            while (ret.next()) { 
	                a=new allmut();
	                String Disease = ret.getString(1);  
	                String Gene = ret.getString(2);  
	                String Descr = ret.getString(3);  
	                String Dbsnp = ret.getString(4);  
	                String Hgvs = ret.getString(5);  
	                String Refseq = ret.getString(6);  
	                String Omimid = ret.getString(7);  
	                String Maffreq = ret.getString(8);  
	                String Wenxian = ret.getString(9);  
	                String Gene_hagvs = ret.getString(10);  
	                String Chromosome = ret.getString(11); 
	                String Tag = ret.getString(12); 
	                String Comments = ret.getString(13); 
	                a.setDisease(Disease);
	                a.setGene(Gene);
	                a.setDescr(Descr);
	                a.setDbsnp(Dbsnp);
	                a.setHgvs(Hgvs);
	                a.setRefseq(Refseq);
	                a.setOmimid(Omimid);
	                a.setMaffreq(Maffreq);
	                a.setWenxian(Wenxian);
	                a.setGene_hagvs(Gene_hagvs);
	                a.setChromosome(Chromosome);
	                a.setTag(Tag);
	                a.setComments(Comments);
	                testProcNoOut(a);
	                System.out.println(i);
	                i++;
	            }//显示数据  
	            ret.close();  
	            pst.close();//关闭连接  
	            conn.close();
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  finally {  
	            if (null != pst) {  
	            	pst.close();  
	            }  
	            if (null != conn) {  
	                conn.close();  
	            }  
	        }   
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
