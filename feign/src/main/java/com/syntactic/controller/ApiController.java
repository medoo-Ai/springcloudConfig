package com.syntactic.controller;

import com.syntactic.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther SyntacticSugar
 * @data 2018/12/5 0005下午 10:07
 */
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;
    @RequestMapping("index")
    public  String index(){
        return  apiService.index();
    }

}
