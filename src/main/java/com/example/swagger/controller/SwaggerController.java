package com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@Api(value = "SwaggerController")
@RequestMapping("/v1/api")
@RestController
public class SwaggerController {

    @ApiOperation(value = "Swagger Test", notes = "Test Notes")
    @GetMapping(value = "/test")
    public Map<String, String> selectOneBoard(@ApiParam(name = "first param", value = "first value", required = true) String input) {
        Map<String, String> result = new HashMap<>();
        result.put("author", "unhak");
        result.put("content", "V1 API 내용");
        return result;
    }
}