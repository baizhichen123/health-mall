package com.health.Controller;

import com.health.Model.Product;
import com.health.Service.ProductService;
import com.health.Service.RedisService;
import com.health.util.CommResult;
import com.health.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/product")
@Api(tags = "ProductController",description = "商品管理控制层")
public class ProductController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/listProduct")
    @ResponseBody
    @ApiOperation("分页获取所有商品")
    public CommResult<CommonPage> listAllProduct(){

        logger.info("分页获取所有商品");
       // Object productList = redisService.get("productList");
        //if(Objects.isNull(productList)){
           List<Product> list=productService.listAllProduct();
          //  redisService.set("productList",list);
            return CommResult.success(CommonPage.restPage((List)list));
       // }else {
         //   return CommResult.success(CommonPage.restPage((List)productList));
        //}

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

        //String  userName = (String) redisTemplate.opsForValue().get("productList");

        return "";

    }


}
