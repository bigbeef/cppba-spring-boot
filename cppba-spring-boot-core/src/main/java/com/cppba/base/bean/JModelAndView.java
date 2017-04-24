package com.cppba.base.bean;

import com.cppba.base.constant.Globals;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class JModelAndView extends ModelAndView {

    public JModelAndView(String viewName) {
        super.setViewName(viewName);
    }

    public JModelAndView(String viewName, HttpServletRequest request) {
        init(viewName,null,request);
    }

    public JModelAndView(String viewName, Map<String,Object> map, HttpServletRequest request) {
        //初始化
        init(viewName,map,request);
    }

    private void init(String viewName, Map<String,Object> map, HttpServletRequest request) {
        //模板文件夹
        viewName = Globals.TEMPLATE_TYPE + viewName;
        super.setViewName(viewName);
        if(map!=null){
            for (String key : map.keySet()) {
                this.addObject(key, map.get(key));
            }
        }

        //模板文件夹
        this.addObject("template_type", Globals.TEMPLATE_TYPE);
        //webPath
        String path = request.getContextPath();
        String webPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        this.addObject("webPath", webPath);
    }
}
