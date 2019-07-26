/*
package com.zicms.web.sys.controller;

import com.zicms.web.sys.utils.SysUserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

*/
/**
 * @author Administrator
 * 
 *//*

@Controller
@RequestMapping("/")
public class LoginController {
    */
/**
     * 管理主页
     * 
     * @param model
     * @param request
     * @return
     *//*

    @RequestMapping(value = "/")
    public String toIndex(Model model, HttpServletRequest request) {
        request.getSession().removeAttribute("code"); // 清除code
        model.addAttribute("menuList", SysUserUtils.getUserMenus());
        return "index";
    }
}
*/
