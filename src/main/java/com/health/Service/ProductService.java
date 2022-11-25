package com.health.Service;

import com.health.Model.Product;

import java.util.List;

public interface ProductService {

    int insertProduct();

    List<Product> listAllProduct(Integer pageNum, Integer numEachPage);
}
