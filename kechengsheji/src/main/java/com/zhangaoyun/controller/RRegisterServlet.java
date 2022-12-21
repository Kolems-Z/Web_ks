package com.zhangaoyun.controller;

import com.zhangaoyun.pojo.User;
import com.zhangaoyun.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RRegisterServlet")
public class RRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RR");
        UserService userService = new UserService();
        String email = request.getParameter("email");
        String passId = request.getParameter("username");
        String passWord = request.getParameter("password");
        System.out.println(email);
        System.out.println(passId);
        System.out.println(passWord);
        Integer id = Integer.parseInt(passId);
        response.setHeader("content-type","text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        User user = new User();
        User anotheruser = userService.selectBypassid(id);


        if(anotheruser==null){
           writer.write("");
        }
        else{
            writer.write("用户名已存在");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
