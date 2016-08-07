package com.database.service.impl;

import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.UserService;
import com.database.dao.UserDao;
import com.database.po.User;

/**
 * 
 * UserServiceImpl数据库操作接口类
 * 
 **/

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userdao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	public User selectById(String id) {
		User user = userdao.selectById(id);
		return user;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	public PageVo selectUserList(User record) {
		PageVo pageVo = new PageVo();
		List<User> list = userdao.selectUserList(record);
		pageVo.setRoot(list);
		pageVo.setTotal(userdao.selectUserCount(record));
		return pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	public boolean deleteById(String id) {
		int flag = userdao.deleteById(id);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 删除（根据对象）
	 * 
	 **/
	public boolean deleteUser(User record) {
		int flag = userdao.deleteUser(record);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	public boolean insertUser(User record) {
		int flag = userdao.insertUser(record);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	public boolean updateUser(User record) {
		int flag = userdao.updateUser(record);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		User checkUser = userdao.loginUser(user);
		return checkUser;
	}

	@Override
	public int selectUserCount(User record) {
		// TODO Auto-generated method stub
		return userdao.selectUserCount(record);
	}

	@Override
	public int exist(User user) {
		// TODO Auto-generated method stub
		return userdao.exist(user);
	}

}