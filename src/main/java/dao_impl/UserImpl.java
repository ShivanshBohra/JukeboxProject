package dao_impl;

import dao_interfaces.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserImpl implements UserInterface {
    Scanner sc = new Scanner(System.in);
//    DBConnection obj;

    @Override
    public boolean createAccount() {
        boolean flag = false;
        System.out.println("ENTER YOUR NAME");
        String name = sc.next();
        System.out.println("ENTER YOUR PASSWORD");
        String password = sc.next();
        System.out.println("ENTER YOUR MOBILE NUMBER");
        String mobileNo = sc.next();
        Connection con = DBConnection.getCon();
        PreparedStatement pstmt = null;
        try {
            String query = "insert into user(user_name,password,mobile_no) values(?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, mobileNo);
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            con = null;
        }
        return flag;
    }

    @Override
    public boolean login() {
        boolean flag = false;
        System.out.println("ENTER YOUR NAME");
        String name = sc.next();
        System.out.println("PLEASE ENTER YOUR PASSWORD");
        String password = sc.next();
        Connection con = DBConnection.getCon();
        try {
            PreparedStatement pspt = con.prepareStatement("select user_name ,password from user where 'user_name' =? and 'password'=? ");
            pspt.setString(1, name);
            pspt.setString(2, password);
            boolean result = pspt.execute();
            flag = true;
            if (result) {
                System.out.println("LOGIN SUCCESSFULLY");
                System.out.println("WELCOME");
                flag = true;
            } else {
                System.out.println("CREDENTIALS DO NOT MATCH");
                System.out.println("PROVIDE THE CORRECT CREDENTIALS");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }
}
