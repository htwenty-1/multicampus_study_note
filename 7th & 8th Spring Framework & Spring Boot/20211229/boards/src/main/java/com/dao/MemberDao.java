package com.dao;

import com.dto.MemberDto;

public interface MemberDao {

    int addMember(MemberDto dto);
    int getId(String id);

}
