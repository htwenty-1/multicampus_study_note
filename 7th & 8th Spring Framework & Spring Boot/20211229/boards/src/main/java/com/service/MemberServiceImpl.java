package com.service;

import com.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements com.service.MemberService {

    @Autowired
    MemberDao dao;

}
