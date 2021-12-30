package com.dao;

import com.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    SqlSession session;

    String ns = "Member.";

    @Override
    public int addMember(MemberDto dto) {
        return session.insert(ns + "addMember", dto);
    }

    @Override
    public int getId(String id) {
        return session.selectOne(ns + "getId", id);
    }

}
