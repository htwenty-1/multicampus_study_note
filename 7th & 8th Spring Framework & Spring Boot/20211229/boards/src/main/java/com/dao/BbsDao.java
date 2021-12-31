package com.dao;

import com.dto.BbsDto;
import com.dto.BbsParam;

import java.util.List;

public interface BbsDao {

    List<BbsDto> bbslist(BbsParam param);

    int writebbs(BbsDto dto);

    BbsDto getBbs(int seq);

    int replyBbsUpdate(BbsDto dto);
    int replyBbsInsert(BbsDto dto);
}
