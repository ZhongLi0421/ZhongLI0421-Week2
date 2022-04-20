package com.hezhongli.dao;

import com.hezhongli.model.Product;
import com.hezhongli.model.User;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into Product(ProductName,ProductDescription,picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if (product.getPicture() != null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        int rs = stmt.executeUpdate("DELETE FROM Product where id =" + productId);
        if (rs == 1) {
            System.out.println("删除成功!");
            return rs;
        }
        System.out.println("删除失败!!!");
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) {
        Product product=new Product();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT * from Product where ProductId=" + productId);
            while (rs.next()){
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("price"));
//                product.setPicture(rs.getAsciiStream("picture"));
                product.setCategoryId(rs.getInt("CategoryId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        List<Product> products=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT * from Product where CategoryId='" + categoryId + "'");
            while (rs.next()){
                Product product =new Product();
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getInt("price"));
                product.setPicture(rs.getAsciiStream("picture"));
                product.setCategoryId(rs.getInt("CategoryId"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> products=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT * from Product where price>='" + minPrice + "'" + "and price<='"+maxPrice+"'");
            while (rs.next()){
                Product product =new Product();
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getInt("price"));
                product.setPicture(rs.getAsciiStream("picture"));
                product.setCategoryId(rs.getInt("CategoryId"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> products=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT * from Product ");
            while(rs.next()){
                Product product =new Product();
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setPicture(rs.getAsciiStream("picture"));
                product.setCategoryId(rs.getInt("CategoryId"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> products=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT * from Product where ProductName='" + productName + "'");
            while (rs.next()){
                Product product =new Product();
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getInt("price"));
                product.setPicture(rs.getAsciiStream("picture"));
                product.setCategoryId(rs.getInt("CategoryId"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> products=new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT * from Product where ProducyId='" + productId + "'");
            Product product =new Product();
            if(rs.next()){
                product.setPicture(rs.getAsciiStream("picture"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public byte[] getPictureById(Integer productId,Connection con)throws SQLException{
        byte[] imgByte=null;
        String sql="select picture from product where productId=?";
        PreparedStatement pt =con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imgByte=blob.getBytes(1,(int)blob.length());
        }
        return imgByte;
    }
}
