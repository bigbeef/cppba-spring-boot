package com.cppba.controller.common;

import com.cppba.base.util.CommonUtil;
import com.cppba.base.util.QRCodeUtil;
import com.cppba.base.util.VerifyCodeUtil;
import com.cppba.controller.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@Controller
public class CommonAction extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(CommonAction.class);

    //返回403错误
    /*@RequestMapping("/403")
    public void login(
            HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        CommonUtil.responseBuildJson("403","你无权访问该资源!",null,response);
    }*/

    /**
     * 获取二维码
     * text 必须用UTF8编码格式，x内容出现 & 符号时，请用 %26 代替,换行符使用 %0A
     */
    @RequestMapping("/qrcode_image")
    public void qrcode_image(
            HttpServletRequest request,HttpServletResponse response,
            @RequestParam(value="text", defaultValue="")String text){
        try{
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            BufferedImage image = QRCodeUtil.QRCodeCreate(text, 250, 250);

            ImageIO.write(image, "png",response.getOutputStream());
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

    }
    
     //下载二维码
    @RequestMapping("/download_qrcode_image")
    public void download_qrcode_image(
            HttpServletRequest request,HttpServletResponse response,
            @RequestParam(value="text", defaultValue="")String text) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=qingcheng.png");
        response.setContentType("application/octet-stream; charset=utf-8");

        BufferedImage image = QRCodeUtil.QRCodeCreate(text, 250, 250);
        ImageIO.write(image, "png",response.getOutputStream());
    }
    
    // 生成图片验证码
    @RequestMapping("/auth_image")
    public void auth_Image(
            HttpServletRequest request, HttpServletResponse response){
        try{
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            // 生成随机字串
            String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
            // 存入会话session
            HttpSession session = CommonUtil.getSession(request);
            session.setAttribute("code", verifyCode.toLowerCase());
            // 生成图片
            int w = 200, h = 80;
            VerifyCodeUtil.outputImage(w, h, response.getOutputStream(),
                    verifyCode);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }

    //图片上传
    //path   例如:"/Image/article"
    /*@RequestMapping("/upload_file")
    public void upload_file(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value="path", defaultValue="Image/article")String path,
            @RequestParam(value="fileName", defaultValue="imgFile")String fileName,
            @RequestParam(value="isImage", defaultValue="true")boolean isImage
    ) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(fileName);
        String name = UploadFileUtil.uploadFileAliyun(file, path);
        map.put("error", 0);
        map.put("success", 1);
        map.put("url", Globals.FILE_SERVER_URL +"/"+path+ "/" + name);
        // 构建返回
        CommonUtil.responseBuildJson(map,response);
    }*/
}
