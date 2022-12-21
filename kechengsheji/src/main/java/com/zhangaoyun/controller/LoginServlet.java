package com.zhangaoyun.controller;

import com.zhangaoyun.pojo.User;
import com.zhangaoyun.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet");
        UserService userService = new UserService();
        List<User> users = userService.selectAll();
        String passid = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(passid);
        System.out.println(password);
        Integer id = Integer.parseInt(passid);
        PrintWriter writer = response.getWriter();
        User user = new User();
        int status = 0;
        try {
            user = userService.selectBypassid(id);
            System.out.println(user);
            if(password.equals(user.getPassWord())){
                writer.write("<script>alert"+"("+"'Login successful!@!@'"+")"+"</script>");

                status = 1;
                response.setHeader("Refresh","1;URL=http://localhost:8080/kechengsheji_war/xiaomi.html");
            }
            else{
                writer.write("<script>alert"+"("+"'failed，your password is wrong!@!@'"+")"+"</script>");
                response.setHeader("Refresh","1;URL=http://localhost:8080/kechengsheji_war/html/login.html");
        } }catch (Exception e) {
            writer.write("<script>alert"+"("+"'sorry!please check your id or password!@!@'"+")"+"</script>");
            response.setHeader("Refresh","1;URL=http://localhost:8080/kechengsheji_war/html/login.html");
        }

        /*try {
            user = userService.selectBypassid(id);
            System.out.println(user);
            if(password.equals(user.getPassWord())){
                      status = "1";
            }
            else{
                status = "0";
            }
        } catch (Exception e) {
           status = "0";    }
        System.out.println(status);
        response.setContentType("text/html;charset=utf-8");
        System.out.println("2");
        response.getWriter().write(status);
        System.out.println("3");
       *//* if (status==1){

            response.sendRedirect("/kechengsheji_war/xiaomi.html");
        }
*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
