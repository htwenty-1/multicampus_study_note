package com.service;

import com.dao.BbsDao;
import com.dto.BbsDto;
import com.dto.BbsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsServiceImpl implements BbsService{

    @Autowired
    BbsDao dao;

    @Override
    public List<BbsDto> bbslist(BbsParam param) {
        return dao.bbslist(param);
    }

    @Override
    public boolean writebbs(BbsDto dto) {
        return dao.writebbs(dto) > 0;
    }

    @Override
    public BbsDto getBbs(int seq) {
        return dao.getBbs(seq);
    }

    @Override
    public void reply(BbsDto dto) {
        int n = dao.replyBbsUpdate(dto);
        if(n == 0) {
            System.out.println("replyBbsUpdate fail~");
        }

        n = dao.replyBbsInsert(dto);
        if(n == 0) {
            System.out.println("replyBbsInsert fail~");
        }
    }
}
