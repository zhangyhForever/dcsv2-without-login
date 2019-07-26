package com.zicms.entities;

import javax.persistence.Table;

/**
 * @ Author       : forever
 * @ Date         : Created in 2019/7/26
 * @ Description  : what to do ...
 */

@Table(name = "student")
public class Student {

    private Long StuId;
    private String StuName;
    private Integer StuAge;

    public Long getStuId() {
        return StuId;
    }

    public void setStuId(Long stuId) {
        StuId = stuId;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public Integer getStuAge() {
        return StuAge;
    }

    public void setStuAge(Integer stuAge) {
        StuAge = stuAge;
    }
}
