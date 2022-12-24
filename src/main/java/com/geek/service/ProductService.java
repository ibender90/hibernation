package com.geek.service;

import com.geek.dao.ProductDAO;
import com.geek.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Customer> getCustomersWhoPurchasedThisProduct(Long id){
        return productDAO.getCustomersWhoPurchasedThisProduct(id);
    }
}
