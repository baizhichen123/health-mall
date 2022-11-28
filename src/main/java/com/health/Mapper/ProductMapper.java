package com.health.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.health.Model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> listallProduct();

    int insertProduct(Product product);


    @Override
    int insert(Product entity);

    /**
     * 模糊查询商品名称且满足字段的排序功能
     * @param searchValue 商品模糊查询
     * @param columnSort  字段排序
     * @param sortType   正序或者倒序
     * @return 满足条件的集合
     */
    List<Product> findAllProductList(@Param("searchValue") String searchValue, @Param("columnSort") String columnSort, @Param("sortType") String sortType);
}
