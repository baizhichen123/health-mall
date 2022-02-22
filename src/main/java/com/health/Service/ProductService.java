package com.health.Service;

import com.health.Model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProduct();

    int insertProduct();
}
