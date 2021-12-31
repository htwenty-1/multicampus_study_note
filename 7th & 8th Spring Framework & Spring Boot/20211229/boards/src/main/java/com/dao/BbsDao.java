package com.dao;

import com.dto.BbsDto;

import java.util.List;

public interface BbsDao {

    List<BbsDto> bbslist();

    int writebbs(BbsDto dto);

    BbsDto getBbs(int seq);

}
