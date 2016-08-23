package com.database.dao;
import com.database.po.Roles;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesDao {

public int  insertRoles(Roles roles);

public int  updateRoles(Roles roles);

public List<Roles>  getRolesList(Roles roles);

public int  getRolesListCount(Roles roles);

public Roles  getRolesById(String id);

}