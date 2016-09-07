package com.database.dao;
import com.database.po.RolesResources;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesResourcesDao {

public int  insertRolesResources(RolesResources rolesResources);

public int  updateRolesResources(RolesResources rolesResources);

public List<RolesResources>  getRolesResourcesList(RolesResources rolesResources);

public int  getRolesResourcesListCount(RolesResources rolesResources);

public List<RolesResources>  getRolesResourcesById(String id);

}