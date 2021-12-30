package com.dto;

import java.io.Serializable;

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

    public BbsDto(String id, String title, String wdate) {
        this.id = id;
        this.title = title;
        this.wdate = wdate;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getReadcoount() {
        return readcoount;
    }

    public void setReadcoount(int readcoount) {
        this.readcoount = readcoount;
    }

    @Override
    public String toString() {
        return "BbsDto{" +
            "seq=" + seq +
            ", id='" + id + '\'' +
            ", ref=" + ref +
            ", step=" + step +
            ", depth=" + depth +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", wdate='" + wdate + '\'' +
            ", del=" + del +
            ", readcoount=" + readcoount +
            '}';
    }
}


