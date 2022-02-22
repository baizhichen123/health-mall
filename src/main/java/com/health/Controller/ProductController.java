package com.health.Controller;

import com.health.Model.Product;
import com.health.Service.ProductService;
import com.health.util.CommResult;
import com.health.util.CommonPage;
import com.log.starter.annotation.PrintLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@Api(tags = "ProductController",description = "商品管理控制层")
public class ProductController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/listProduct")
    @ResponseBody
    @ApiOperation("分页获取所有商品")
    public CommResult<CommonPage> listAllProduct(){

        logger.info("分页获取所有商品");

        List<Product> list=productService.listAllProduct();

        System.out.println(list.size());

        //redisTemplate.opsForValue().set("productList",list);

    return CommResult.success(CommonPage.restPage(list));

    }

    @RequestMapping("/insertProduct")
    @ResponseBody
    public String insertProduct(){

        int insertCount=productService.insertProduct();

        return ""+insertCount;
    }

    @RequestMapping("/getProduct")
    @ResponseBody
    public String getProduct(){

        String  userName = (String) redisTemplate.opsForValue().get("productList");

        return userName;

    }


}
