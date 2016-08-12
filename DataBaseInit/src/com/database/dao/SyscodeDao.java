package com.database.dao;
import com.database.po.Syscode;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface SyscodeDao {

public int  insertSyscode(Syscode syscode);

public int  updateSyscode(Syscode syscode);

public List<Syscode>  getSyscodeList(Syscode syscode);

public int  getSyscodeListCount(Syscode syscode);

public Syscode  getSyscodeById(String id);

public  List<Syscode>   getSyscodeAll();

public int deleteSyscode(String id);
}