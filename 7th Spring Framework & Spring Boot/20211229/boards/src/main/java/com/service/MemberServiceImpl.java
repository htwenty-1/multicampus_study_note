package com.service;

import com.dao.MemberDao;
import com.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements com.service.MemberService {

    @Autowired
    MemberDao dao;

    @Override
    public boolean addMember(MemberDto dto) {
        int cnt = dao.addMember(dto);

        return cnt > 0; // cnt > 0 ? true : false;
    }

    @Override
    public int getId(String id) {
        return dao.getId(id);
    }

    @Override
    public MemberDto login(MemberDto dto) {
        return dao.login(dto);
    }

}
