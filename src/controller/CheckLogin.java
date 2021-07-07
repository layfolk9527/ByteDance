package controller;

import dao.QueryDao;
import tools.CheckCode;
import vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //接收数据
           String userName=request.getParameter("username");
           String password=request.getParameter("password");
           String vCode=request.getParameter("vCode");//vCode是用户输入的验证码
           //获取存入session中正确的验证码数据，用来和用户输入的验证码校验
           HttpSession session=request.getSession();
           String tCode=(String)session.getAttribute("verifyCode");//tCode表示自动生成的四位验证码
           System.out.println(tCode);

           //处理数据,一般封装在一个java类中处理
           String str="";
           if(!vCode.equals(tCode)){
               str="0,";
           }
           else{
               str="1,";
           }
        QueryDao dao=new QueryDao();
        User user=new User();
        user=dao.query(userName);
        if(user.getUserName() == null){
            str=str+"0,";
        }else {
            str=str+"1,";
        }
        if(user.getPassword()==null){
            str=str+"0";
        }else {
            str=str+"1";
        }


           //响应数据,只能响应给jsp页面
//           request.setAttribute("errorCode",ret);
//           String targetUrl="/error.jsp";
//           RequestDispatcher rd=request.getRequestDispatcher(targetUrl);
//           rd.forward(request,response);

        //直接利用ajax输出给前端页面
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.print(str);
        out.flush();
        out.close();
    }
}
