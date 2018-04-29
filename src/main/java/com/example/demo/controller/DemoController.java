package com.example.demo.controller;

import com.example.demo.model.DemoModel;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DemoController {

    private final DemoService service;

    @Autowired
    public DemoController(DemoService service) {
        this.service = service;
    }

    /**
     * JSP 测试
     * @return JSP 视图
     */
    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView("demo"); // 对应 demo.jsp
        mv.addObject("value", "测试值");
        return mv;
    }

    /**
     * 接口测试
     * ResponseBody 如果返回的是对象 会自动转为json字符串，如果返回的是String 则返回该字符串
     * @return JSON 字符串
     */
    @GetMapping("/demos")
    @ResponseBody
    public List<DemoModel> allDemo() {
        return service.selectAll();
    }
    // @ResponseBody 如果返回的是对象 会自动转为json字符串，如果返回的是String 则返回该字符串

}
