package com.database.dao;
import com.database.po.Brand;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao {

public int  insertBrand(Brand brand);

public int  updateBrand(Brand brand);

public List<Brand>  getBrandList(Brand brand);

public int  getBrandListCount(Brand brand);

public Brand  getBrandById(String id);

}