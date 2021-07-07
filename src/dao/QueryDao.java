package dao;

import vo.User;

import java.sql.*;
import java.util.ArrayList;

public class QueryDao {
    public User query(String username){
//        ArrayList<User> list=new ArrayList<User>();
        User user=new User();
        try {
            Connection con;
            PreparedStatement pst;
            ResultSet rs;
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t_excise?useUnicode=true&characterEncoding=utf8", "root", "root");
            //3.创建语句
            String sql = "select * from t_user where user_name=? ";
            pst = con.prepareStatement(sql);
            //4.执行语句
            pst.setString(1, username);
            rs = pst.executeQuery();
            //5.结果处理
           while(rs.next()){
//               User user=new User();
               user.setUserName(rs.getString("user_name"));
               user.setPassword(rs.getString("password"));
//               user.setGender(rs.getString("user_gender"));
//               user.setBirth(rs.getDate("user_birth"));
//               user.setTel(rs.getString("user_tel"));
//               user.setChrName(rs.getString("chr_name"));
//               list.add(user);
//               System.out.println(user.getUserName()+user.getTel()+user.getGender());
           }
            //6.释放连接
            rs.close();
            pst.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return  user;
    }
}
