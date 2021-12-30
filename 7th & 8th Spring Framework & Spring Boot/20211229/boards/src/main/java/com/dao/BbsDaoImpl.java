package com.dao;

import com.dto.BbsDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BbsDaoImpl implements BbsDao{

    @Autowired
    SqlSession sec;

    String ns = "bbs.";

    public List<BbsDto> bbslist() {
        return sec.selectList(ns + "bbslist");
    }

    public List<BbsDto> writebbs() {
        return sec.selectList(ns + "writebbs");
    }

}
