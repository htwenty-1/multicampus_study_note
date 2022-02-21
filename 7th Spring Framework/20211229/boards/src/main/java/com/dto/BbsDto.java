package com.dto;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class BbsDto implements Serializable {

    private int seq;        // 글의 고유번호
    private String id;

    private int ref;        // 그룹번호
    private int step;       // 행번호
    private int depth;      // 깊이

    private String title;
    private String content;
    private String wdate;

    private int del;
    private int readcoount;

    public BbsDto() {}

    /*
        ref : 그룹 번호
        step: 행 번호
        depth: 깊이 번호
        ref - step - depth 순으로
        -------------------------
        세번째 글                                (2 - 0 - 0)
        두번째 글                                (1 - 0 - 0)
          ㄴ 두번째 글의 두번째 답글                 (1 - 1 - 1)
             ㄴ 두번째 글의 두번째 답글의 첫번째 답글   (1 - 2 - 2)
          ㄴ 두번째 글의 첫번째 답글                 (1 - 3 - 1)
        첫번째 글                                (0 - 0 - 0)
    */

    public BbsDto(int seq, String id, int ref, int step, int depth, String title, String content, String wdate, int del, int readcoount) {
        super();
        this.seq = seq;
        this.id = id;
        this.ref = ref;
        this.step = step;
        this.depth = depth;
        this.title = title;
        this.content = content;
        this.wdate = wdate;
        this.del = del;
        this.readcoount = readcoount;
    }

    public BbsDto(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


