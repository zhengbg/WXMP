package com.wx.jzh.controller;

import com.wx.jzh.entity.TestDO;
import com.wx.jzh.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger (TestController.class);
    @Autowired
    private TestService testService;

    @RequestMapping (value = "/query")
    @ResponseBody
    public List<TestDO> query(HttpServletRequest request){
        List<TestDO> testDOS = testService.query ();
        System.out.println (">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ testDOS);
        return testDOS;
    }
}
