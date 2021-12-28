package com.example.src.dto;

public class HumanDto {

    private String job;
    private int age;
    public HumanDto(String job, int age) {
        this.job = job;
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
