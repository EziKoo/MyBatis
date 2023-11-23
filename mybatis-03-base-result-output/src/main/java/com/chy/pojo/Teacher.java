package com.chy.pojo;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 10:49
 * @Description:
 */

public class Teacher {

    private String tId;

    private String tName;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                '}';
    }
}
