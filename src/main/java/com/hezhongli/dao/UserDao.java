package com.hezhongli.dao;

import com.hezhongli.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert into usertable
        Statement stmt = con.createStatement();
        int rs = stmt
                .executeUpdate("INSERT INTO usertable(username,password,email,gander,birthdate)" +
                        " Values('" + user.getUsername() + "'" + "," + "'" + user.getPassword() + "'" + "," + "'" + user.getEmail() + "'" + ","
                        + "'" + user.getGender() + "'" + "," + "'" + user.getBirthdate() + "')");
        if (rs == 1) {
            System.out.println("增加成功!");
        } else {
            System.out.println("增加失败!!!");
        }
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        Statement stmt = con.createStatement();
        int rs = stmt.executeUpdate("DELETE FROM usertable where id =" + user.getId());
        if (rs == 1) {
            System.out.println("删除成功!");
            return rs;
        }
        System.out.println("删除失败!!!");
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        Statement stmt = con.createStatement();
        int rs = stmt.executeUpdate("UPDATE usertable set password='" + user.getPassword() + "', email='" + user.getEmail() + "', gender='" + user.getGender() + "', birthdate='" + user.getBirthdate() + "'where id=" + user.getId());

        if (rs == 1) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！！！");
        }
        return rs;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("SELECT * from usertable where id=" + id);
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGander(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("SELECT * from usertable where username='" + username + "' and password='" + password + "'");
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGander(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("SELECT * from usertable where username='" + username + "'");
        List<User> u = new ArrayList<>();
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGander(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            u.add(user);
        }
        return u;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("SELECT * from usertable where password='" + password + "'");
        List<User> u = new ArrayList<>();
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGander(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            u.add(user);
        }
        return u;
    }

    @Override
    public List<User> findByEmail(Connection con, String Email) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("SELECT * from usertable where Email='" + Email + "'");
        List<User> u = new ArrayList<>();
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGander(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            u.add(user);
        }
        return u;
    }

    @Override
    public List<User> findByGender(Connection con, String gander) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("SELECT * from usertable where gander='" + gander + "'");
        List<User> u = new ArrayList<>();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGander(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            u.add(user);
        }
        return u;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthdate) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("SELECT * from usertable where birthdate='" + birthdate + "'");
        List<User> u = new ArrayList<>();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGander(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            u.add(user);
        }
        return u;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("SELECT * from usertable");
        List<User> u = new ArrayList<>();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGander(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            u.add(user);
        }
        return u;
    }
}
