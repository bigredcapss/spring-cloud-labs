package com.lg.springcloudproductservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BigRedCaps
 * @date 2020/12/5 13:24
 */
@RestController
public class ProductService {

    @GetMapping("/product/{id}")
    public String findById(@PathVariable("id") int id){
        return "SUCCESS";
    }
}
