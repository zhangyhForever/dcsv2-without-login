package com.zicms.web.test.service;

import com.zicms.entities.Student;
import com.zicms.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author       : forever
 * @ Date         : Created in 2019/7/26
 * @ Description  : what to do ...
 */

@Service
public class StudentService {

    @Autowired
    private StudentMapper mapper;

    public Student findOne() {
        return  mapper.findOne();
    }
}
