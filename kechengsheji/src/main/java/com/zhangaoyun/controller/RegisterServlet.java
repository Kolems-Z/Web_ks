package com.zhangaoyun.controller;

import com.zhangaoyun.pojo.User;
import com.zhangaoyun.service.UserService;
import com.zhangaoyun.util.SqlSessionFactoryUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            user.setEmail(email);
            user.setPassId(id);
            user.setPassWord(passWord);
            userService.insertAll(user);
            writer.write("1");
            /*writer.write("<script>alert('注册成功')</script>");
            writer.write("2s后跳转界面...");
            response.setHeader("Refresh","2;URL=http://localhost:8080/kechengsheji_war/xiaomi.html");*/
        }
        else{
            writer.write("0");
            /*writer.write("<script>alert('用户名已存在')</script>");
            writer.write("2s后跳转回注册界面...");
            response.setHeader("Refresh","2;URL=http://localhost:8080/kechengsheji_war/html/register.html");*/
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
