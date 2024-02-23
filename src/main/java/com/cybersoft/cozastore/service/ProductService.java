package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.ProductEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.response.ProductResponse;
import com.cybersoft.cozastore.repository.ProductRepository;
import com.cybersoft.cozastore.service.Imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductByCategory(int id) {
        List<ProductResponse> productResponseList = new ArrayList<>();
        try {
            List<ProductEntity> list = productRepository.findByCategoryId(id);
            for (ProductEntity data: list) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(data.getId());
                productResponse.setImage(data.getImage());
                productResponse.setPrice(data.getPrice());
                productResponse.setName(data.getName());
                productResponseList.add(productResponse);
            }
        }catch (Exception e){
            throw new CustomException("Error getProductByCategory in ProductService" + e.getMessage());
        }

        return productResponseList;
    }

    @Override
    public List<ProductResponse> getProductByUser(int id) {
        List<ProductResponse> productResponseList = new ArrayList<>();

        try {
            List<ProductEntity> list = productRepository.findByUser(id);
            for (ProductEntity data: list) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(data.getId());
                productResponse.setImage(data.getImage());
                productResponse.setPrice(data.getPrice());
                productResponse.setName(data.getName());
                productResponseList.add(productResponse);
            }
        }catch (Exception e ){
            throw new CustomException("Error getProductByUser in ProductService" + e.getMessage());
        }

        return productResponseList;
    }
}