package com.health.Service;

import com.health.Model.Product;

import java.util.List;

public interface ProductService {

    int insertProduct();

    /**
     * 分页模糊查询排序查询商品列表
     * @param pageNum 页数
     * @param numEachPage 每页条数
     * @param searchValue 商品名称模糊搜索
     * @param columnSort  字段排序
     * @param sortType    生序还是倒序
     * @return 满足条件的集合
     */
    List<Product> listAllProduct(Integer pageNum, Integer numEachPage, String searchValue, String columnSort, String sortType);
}
