package com.geek.main;

import com.geek.dao.ProductDAOimpl;
import com.geek.model.Product;
import com.geek.utils.SessionFactoryUtils;

public class MainClass {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactory = new SessionFactoryUtils();
        sessionFactory.init();

        try {
            ProductDAOimpl productDAOimpl = new ProductDAOimpl(sessionFactory);
            System.out.println(productDAOimpl.getAllProducts());
            System.out.println(productDAOimpl.getProductById(1L));
            System.out.println(productDAOimpl.getProductByName("hammer"));

            Product product = new Product();
            product.setName("Skrewdriver");
            productDAOimpl.save(product);

            System.out.println(productDAOimpl.getAllProducts());

            Long id = productDAOimpl.getProductByName("Skrewdriver").getId();
            productDAOimpl.updateProductNameById(id, "screwdriver");

            System.out.println(productDAOimpl.getAllProducts());
        }finally {
            sessionFactory.shutdown();
        }
    }
}
