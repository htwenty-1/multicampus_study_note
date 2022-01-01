package com.dao;

import com.dto.BbsDto;
import com.dto.BbsParam;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BbsDaoImpl implements BbsDao{

    @Autowired
    SqlSession sec;

    String ns = "Bbs.";

    @Override
    public List<BbsDto> bbslist(BbsParam param) {
        return sec.selectList(ns + "bbslist");
    }

    @Override
    public int writebbs(BbsDto dto) {
        return sec.insert(ns + "writebbs", dto);
    }

    @Override
    public BbsDto getBbs(int seq) {
        return sec.selectOne(ns + "getBbs", seq);
    }

    @Override
    public int replyBbsUpdate(BbsDto dto) {
        return sec.update(ns + "replyBbsUpdate", dto);
    }

    @Override
    public int replyBbsInsert(BbsDto dto) {
        return sec.insert(ns + "replyBbsInsert", dto);
    }

}
