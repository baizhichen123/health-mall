package com.health.Service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.Mapper.ProductMapper;
import com.health.Model.Product;
import com.health.Service.ProductService;
import com.health.util.CommResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private  final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> listAllProduct() {

        PageHelper.startPage(1,5);

        List<Product> productList= productMapper.selectList(null);

        return productList;
    }

    @Override
    public int insertProduct() {

        logger.info("888888");


           Product product = Product.builder().
                   name("红米手机").
                   price(new BigDecimal(60)).level("1").text("手机").build();

        for (int i=0;i<50;i++) {
            product.setName(product.getName()+i);
            int insertCount=productMapper.insert(product);

        }
        return product.getPid();

    }
}
