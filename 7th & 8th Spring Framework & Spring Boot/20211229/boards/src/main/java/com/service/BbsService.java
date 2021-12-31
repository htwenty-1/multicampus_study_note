package com.service;

import com.dto.BbsDto;
import com.dto.BbsParam;

import java.util.List;

public interface BbsService {
    List<BbsDto> bbslist(BbsParam param);
    boolean writebbs(BbsDto dto);
    BbsDto getBbs(int seq);
    void reply(BbsDto dto);

}
