package com.service;

import com.dto.BbsDto;

import java.util.List;

public interface BbsService {
    List<BbsDto> bbslist();
    List<BbsDto> bbswrite();
}
