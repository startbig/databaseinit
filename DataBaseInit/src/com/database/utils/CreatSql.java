package com.database.utils;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.database.po.Answer;
import com.database.po.Question;
import com.database.po.TableColumn;


public class CreatSql {
public static String getCreatTableSql(String tableName,String tableComment,List<TableColumn> list){
	String sql="CREATE TABLE `"+tableName+"` (  `id` varchar(36)  NOT NULL    ";
	for (int i = 0; i < list.size(); i++) {
		TableColumn c=list.get(i);
		if(c.getColumnType().equals("DATETIME")){
			sql=sql+",`"+c.getColumnName()+"` DATETIME COMMENT '"+c.getColumnComment()+"'";

		}else if(c.getColumnType().equals("VARCHAR")){
			sql=sql+",`"+c.getColumnName()+"` varchar(45) COMMENT '"+c.getColumnComment()+"'";

		}else if(c.getColumnType().equals("INT")){
			sql=sql+",`"+c.getColumnName()+"` INT COMMENT '"+c.getColumnComment()+"'";

		}
		
	}
	sql=sql+",PRIMARY KEY (`id`))ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='"+tableComment+"'";
	System.out.println(sql);
	return sql;
	
}

public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	ObjectMapper om = JsonDataDeal.getMapperInstance(); 
	Question q=new Question();
	q.setQuestion("问题1");
	Answer a=new Answer();
	a.setAnswerOne("答案1");
	a.setAnswerTow("答案1");
	a.setAnswerThree("答案1");
	a.setAnswerFour("答案1");
	q.setAnswer(a);
	System.out.println(om.writeValueAsString(q));
}
}
