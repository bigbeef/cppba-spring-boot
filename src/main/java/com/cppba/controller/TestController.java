package com.cppba.controller;

import com.cppba.service.TestService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Transactional
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    @ResponseBody
    public Map test(HttpServletResponse response){
        System.out.println(123);
        testService.query();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("msg","调用成功");
        return map;
    }

    @RequestMapping("/test1")
    public ModelAndView test1(HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        System.out.println(12345678);
        mv.setViewName("index");
        mv.addObject("msg","返回成功");
       return mv;
    }
}
