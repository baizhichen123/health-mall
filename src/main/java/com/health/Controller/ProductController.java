package com.health.Controller;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("分页获取所有商品")
    public CommResult<CommonPage> listAllProduct(
            @RequestParam(required = false, value = "page_num", defaultValue = "1") Integer pageNum, // 当前页数
            @RequestParam(required = false, value = "num_each_page", defaultValue = "5") Integer numEachPage,//每页条数
            @RequestParam(required = false, value = "search_value", defaultValue = "") String searchValue,//模糊查询
            @RequestParam(required = false, value = "column_sort", defaultValue = "") String columnSort,//排序字段
            @RequestParam(required = false, value = "sort_type", defaultValue = "") String sortType//排序字段
    ){

        logger.info("分页获取所有商品");
       // Object productList = redisService.get("productList");
       // if(Objects.isNull(productList)){
           List<Product> list=productService.listAllProduct(pageNum,numEachPage,searchValue,columnSort,sortType);
         //   redisService.set("productList",list);
            return CommResult.success(CommonPage.restPage((List)list));
       //}else {
       //     return CommResult.success(CommonPage.restPage((List)productList));
       // }

    }

    /**
     * 图片上传方法
     * @param file 文件
     */
    @RequestMapping(value = "/addproduct",method = RequestMethod.POST)
    public void upload_suppImg(
            @RequestParam(value = "file", required = true) MultipartFile[] file,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        JSONObject result = new JSONObject();
        List<Map<String, Object>> resultlist = new ArrayList<Map<String, Object>>();
        try {

            if (file != null) {
                for (MultipartFile multipartFile : file) {

                    // 文件名称
                    String filename = multipartFile.getOriginalFilename()
                            .substring(multipartFile.getOriginalFilename().lastIndexOf("."));

                    logger.info(" biggift new file name :" + filename);

                }
                result.put("data", resultlist);
                result.put("msg", "上传图片成功");
            } else {
                result.put("data", "file is null");
                result.put("msg", "上传图片失败");
            }
            response.getWriter().write(result.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

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
