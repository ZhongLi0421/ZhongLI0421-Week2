package com.hezhongli.controller;

import com.hezhongli.dao.ProductDao;
import com.hezhongli.model.Category;
import com.hezhongli.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException{
        con =(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Category category=new Category();
        try {
            List<Category> categoryList=category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            ProductDao productDao=new ProductDao();
            List<Product> productList=null;
            if(request.getParameter("categoryId")==null)
            {
                productList=productDao.findAll(con);
            }else
            {
                int categoryId=Integer.parseInt(request.getParameter("categoryId"));
                productList=productDao.findByCategoryId(categoryId,con);
            }
            request.setAttribute("productList",productList);
            String path="/WEB-INF/views/shop.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
