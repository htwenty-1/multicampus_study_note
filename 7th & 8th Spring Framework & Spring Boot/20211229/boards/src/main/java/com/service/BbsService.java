package com.service;

import com.dto.BbsDto;

import java.util.List;

public interface BbsService {
    List<BbsDto> bbslist();
    boolean writebbs(BbsDto dto);
    BbsDto getBbs(int seq);
}
