package com.service;

import com.dao.BbsDao;
import com.dto.BbsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsServiceImpl implements BbsService{

    @Autowired
    BbsDao dao;

    @Override
    public List<BbsDto> bbslist() {
        return dao.bbslist();
    }

    @Override
    public boolean writebbs(BbsDto dto) {
        return dao.writebbs(dto) > 0;
    }

    @Override
    public BbsDto getBbs(int seq) {
        return dao.getBbs(seq);
    }
}
