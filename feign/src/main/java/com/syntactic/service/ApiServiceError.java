package com.syntactic.service;

import org.springframework.stereotype.Component;

/**
 * @auther SyntacticSugar
 * @data 2018/12/5 0005下午 10:03
 */

//  熔断   、在接口中指定   fullback
@Component
public class ApiServiceError implements ApiService {
    @Override
    public String index() {
        return "服务熔断";
    }
}
