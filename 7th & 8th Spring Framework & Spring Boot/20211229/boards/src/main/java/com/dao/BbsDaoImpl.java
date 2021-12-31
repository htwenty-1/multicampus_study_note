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
        int cnt = sec.insert(ns + "writebbs", dto);
        return cnt;
    }

    @Override
    public BbsDto getBbs(int seq) {
        return sec.selectOne(ns + "getBbs", seq);
    }

    @Override
    public int replyBbsUpdate(BbsDto dto) {
        int n = sec.update(ns + "replyBbsUpdate", dto);
        return n;
    }

    @Override
    public int replyBbsInsert(BbsDto dto) {
        int n = sec.insert(ns + "replyBbsInsert", dto);
        return n;
    }

}
