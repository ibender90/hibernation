package com.geek.dao;

import com.geek.model.Customer;
import com.geek.model.Product;

import java.util.List;

public interface CustomerDAO {
    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer getCustomerByName(String name);

    void saveCustomer(Customer customer);

    void updateCustomerNameById(Long id, String newName);

    List<Product> getPurchasedProductsByCustomerId(Long id);
}
