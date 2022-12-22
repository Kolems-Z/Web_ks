package com.zhangaoyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhangaoyun.pojo.PageBean;
import com.zhangaoyun.pojo.Product;
import com.zhangaoyun.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
/*分页条件查询*/
@WebServlet("/TJSelServlet")
public class TJSelServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ok");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        /*获取条件查询对象*/
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        System.out.println(s);
        Product product = JSON.parseObject(s, Product.class);
        System.out.println(product);

        PageBean<Product> productPageBean = productService.selectByPageAndCondition(currentPage, pageSize, product);

        String jsonString = JSON.toJSONString(productPageBean);
        System.out.println(jsonString);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
