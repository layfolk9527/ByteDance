package controller;

import tools.CreateVerificationCode;
import tools.CreateVerificationCodeImage;
import tools.GenerateImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GenerateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String vericode= CreateVerificationCode.getSecurityCode();
//        HttpSession session=request.getSession();
//        session.setAttribute("verityCode",vericode);
//        //设置返回的内容
//        response.setContentType("img/jpeg");
//        //浏览器不缓存响应内容--验证码图片，点一次就要刷新一次，所以不能有缓存出现
//        response.setHeader("Pragma","No-cache");
//        response.setHeader("Cache-Control","no-cache");
//        //设置验证码失效时间
//        response.setDateHeader("Expires",0);
//        //以字节流发过去，交给img的src属性去解析即可
//        ImageIO.write(new CreateVerificationCodeImage(vericode).createImage(),"JPEG",response.getOutputStream());


        //将生成验证码图片的过程封装在了GenerateImage类中，然后在servlet中进行调用
        GenerateImage generateImage = new GenerateImage();
        //得到vCode随机数
        String vCode = generateImage.createCode();

        //通过request请求得到啊Httpsession对象，
        HttpSession session=request.getSession();
        //将产生的四位随机数字符串存入到session会话中，存放在session中的数据在一个会话范围内，可以给多个程序共享访问
        session.setAttribute("verifyCode",vCode);
        //设置返回的内容种类
        response.setContentType("img/jpeg");
        //浏览器不缓存内容，点击验证码图片一次就要刷新一次，这里其实可以不再设置，因为在js操作中追加了随机数访问
//        response.setHeader("Pragma","No-cache");
//        response.setHeader("Cache-Control","no-cache");
        //设置验证码失效时间 那么(Expires,0)是多少时间？？？
          response.setDateHeader("Expires",0);
        BufferedImage image = generateImage.createImg(vCode);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"JPEG",out);
        out.flush();
        out.close();
        //121313456231
        //121313456231
        //121313456231
        //121313456231
        //121313456231
    }
}
