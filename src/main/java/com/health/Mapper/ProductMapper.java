package com.health.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.health.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> listallProduct();

    int insertProduct(Product product);


    @Override
    int insert(Product entity);
}
