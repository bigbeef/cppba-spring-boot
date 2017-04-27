package com.cppba.base.bean;

import com.cppba.base.constant.Globals;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class JModelAndView extends ModelAndView {

    public JModelAndView(String viewName, HttpServletRequest request) {
        init(viewName,null,request);
    }

    public JModelAndView(String viewName, Map<String,Object> map, HttpServletRequest request) {
        //初始化
        init(viewName,map,request);
    }

    private void init(String viewName, Map<String,Object> map, HttpServletRequest request) {
        //模板文件夹
        viewName = Globals.TEMPLATE_TYPE + "/" + viewName;
        super.setViewName(viewName);

        //设置参数
        if(map!=null){
            for (String key : map.keySet()) {
                this.addObject(key, map.get(key));
            }
        }

        //模板文件夹
        this.addObject("template_type", Globals.TEMPLATE_TYPE);

        //当前项目根地址
        String path = request.getContextPath();
        String webPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        this.addObject("web_path", webPath);
        //通用静态资源地址,如:jquery、bootstrap
        this.addObject("static_public_url", Globals.STATIC_PUBLIC_URL);
        //项目资源地址
        this.addObject("static_private_url", Globals.STATIC_PRIVATE_URL);
    }
}
