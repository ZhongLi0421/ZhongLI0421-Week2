package com.hezhongli.controller;

import com.hezhongli.dao.ProductDao;
import com.hezhongli.model.Category;
import com.hezhongli.model.Product;
import jdk.internal.util.xml.impl.Input;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)  //16MB
public class AddProductServlet extends HttpServlet {

    Connection con = null;

    public void init() {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("CategoryList", categoryList);
            String path = "/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("productName");
        Double price = request.getParameter("price") != null ? Double.parseDouble(request.getParameter("price")) : 0.0;
        int categoryId = request.getParameter("categoryId") != null ? Integer.parseInt(request.getParameter("categoryId")) : 0;
        String productDescription = request.getParameter("productDescription");
        //picture
        InputStream inputStream=null;
        Part filePart = request.getPart("picture");
        if (filePart != null) {
            System.out.println("file name:" + filePart.getName() + "size" + filePart.getSize() + "file type" + filePart.getContentType());
            inputStream=filePart.getInputStream();  //obtain input stream of the upload file
        }
        //set in model
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);
        product.setPicture(inputStream);
        //call same in dao
        ProductDao dao = new ProductDao();
        int i = 0;
        try {
            i = dao.save(product, con);
            //redirect
            if (i > 0) {
                response.sendRedirect("productList");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
