package com.example.osscallbak.callbak;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ly
 * @version 1.0
 * @date 2020/4/17 13:57
 */
@RestController
@RequestMapping("/ossCall")
public class OssCall {

    @RequestMapping("/getRequ")
    public void requestsc(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入接口");
        System.out.println(request.getAttributeNames());
        System.out.println( request.toString());
        System.out.println("进入接口");
    }

    @RequestMapping("/getRequs")
    public void requestss(HttpServletRequest request, HttpServletResponse response){

        System.out.println("进入接口");
    }
}
