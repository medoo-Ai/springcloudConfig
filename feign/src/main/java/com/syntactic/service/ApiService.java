package com.syntactic.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


//调用的服务地址：  创建一个接口并注解，就能很轻松的调用各服务提供的 HTTP 接口
@FeignClient(value = "eurekaclient",fallback = ApiServiceError.class)//fallback = ApiServiceError.class 指定熔断
public interface ApiService {

    @GetMapping("/index")
    String index();

}
