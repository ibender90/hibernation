package com.geek.dao;

import com.geek.model.Customer;
import com.geek.model.Product;
import com.geek.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerDaoImpl implements CustomerDAO{

    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public void setSessionFactoryUtils(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Customer getCustomerById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public Customer getCustomerByName(String name) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session.createQuery("select c from Customer c where c.name = :name", Customer.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public void saveCustomer(Customer customer) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateCustomerNameById(Long id, String newName) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(Customer.class, id).setName(newName);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Product> getPurchasedProductsByCustomerId(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            List<Product> productList = customer.getProducts();
            session.getTransaction().commit();
            return productList;
        }
    }


}
