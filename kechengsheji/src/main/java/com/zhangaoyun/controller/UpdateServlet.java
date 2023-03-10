package com.zhangaoyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhangaoyun.pojo.Product;
import com.zhangaoyun.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ok");
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        System.out.println(s);
        Product product = JSON.parseObject(s, Product.class);
        System.out.println(product);
        productService.upDateById(product);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("successful");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
