package com.database.utils;


import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.builder.xml.dynamic.DynamicContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import com.database.po.User;


@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
public class GetSqlHelper   implements Interceptor {


public Object intercept(Invocation invocation) throws Throwable {

final Object[] args = invocation.getArgs();

//获取原始的ms
        MappedStatement ms = (MappedStatement) args[0];
        
        Object parameterObject = args[1];
BoundSql boundSql = ms.getBoundSql(parameterObject);
System.out.println("@@@@id:"+ms.getId());
System.out.println("@@@@sql:"+boundSql.getSql());
ParameterMapping mapping = boundSql.getParameterMappings().get(0);
System.out.println("@@@@getParametermapping"+mapping);
Configuration configuration = ms.getConfiguration();
DynamicContext context = new DynamicContext(configuration, parameterObject);
String originSql = context.getSql();
System.out.println("@@@@originSql:"+originSql);
return invocation.proceed();
}

public Object plugin(Object target) {

if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
}

public void setProperties(Properties properties) {
// TODO Auto-generated method stub
}

}
