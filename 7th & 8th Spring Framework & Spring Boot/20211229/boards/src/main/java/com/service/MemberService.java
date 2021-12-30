package com.service;

import com.dto.MemberDto;

public interface MemberService {

    boolean addMember(MemberDto dto);
    int getId(String id);

}
