package com.dao;

import com.dto.BbsDto;

import java.util.List;

public interface BbsDao {

    List<BbsDto> bbslist();
    List<BbsDto> writebbs();

}
