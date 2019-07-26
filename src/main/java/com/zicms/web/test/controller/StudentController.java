package com.zicms.web.test.controller;

import com.zicms.entities.Student;
import com.zicms.web.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author       : forever
 * @ Date         : Created in 2019/7/26
 * @ Description  : what to do ...
 */

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/test")
    public String test(Model model){
        Student one = service.findOne();
        model.addAttribute("stu", one);
        return "hello";
    }

    @RequestMapping("/demo")
    public String demo(){
        return "index";
    }


}
