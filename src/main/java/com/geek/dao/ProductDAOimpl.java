package com.geek.dao;

import com.geek.model.Customer;
import com.geek.model.Product;
import com.geek.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductDAOimpl implements ProductDAO {
    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public void setSessionFactoryUtils(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product getProductById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }

    @Override
    public Product getProductByName(String inputName) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("select p from Product p where p.name = :inputName", Product.class)
                    .setParameter("inputName", inputName)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateProductNameById(Long id, String newName) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(Product.class, id).setName(newName);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Customer> getCustomersWhoPurchasedThisProduct(Long id) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            List<Customer> customersWhoPurchasedThisProduct = product.getCustomers();
            session.getTransaction().commit();
            return customersWhoPurchasedThisProduct;
        }
    }
}
