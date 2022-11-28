package com.health.Controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Api(tags = "LoginController",description = "登录控制层")
public class LoginController {

   private static final Logger logger= LoggerFactory.getLogger(LoginController.class);






}
