package com.mz.auth.web.controller;

import com.mz.auth.util.CodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

@Controller
public class FrontIndexController {

    @RequestMapping("/front/login")
    public String toStuLogin() {
        return "front/loginIndex";
    }

    @RequestMapping("/front/getCode")
    public void getCode(HttpSession session, HttpServletResponse resp){
        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();
        session.setAttribute("code", codeMap.get("code").toString());
        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);
        resp.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
