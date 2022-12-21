package com.zhangaoyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhangaoyun.pojo.Product;
import com.zhangaoyun.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddPServlet")
public class AddPServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*接受数据json，并转换成product */
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        System.out.println(s);
        Product product = JSON.parseObject(s, Product.class);

        productService.add(product);
       /* response.setContentType("text/html;charset=utf-8");*/
        response.getWriter().write("successful");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello");
        this.doGet(request, response);
    }
}
