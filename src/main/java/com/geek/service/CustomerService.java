package com.geek.service;

import com.geek.dao.CustomerDAO;
import com.geek.dao.ProductDAO;
import com.geek.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerService {
    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Product> getPurchasedProductsByCustomerId(Long id) {
        return customerDAO.getPurchasedProductsByCustomerId(id);
    }
}
