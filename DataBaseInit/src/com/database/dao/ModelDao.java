package com.database.dao;
import com.database.po.Model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ModelDao {

public int  insertModel(Model model);

public int  updateModel(Model model);

public List<Model>  getModelList(Model model);

public int  getModelListCount(Model model);

public Model  getModelById(String id);

}