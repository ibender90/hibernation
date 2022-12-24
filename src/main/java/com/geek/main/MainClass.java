package com.geek.main;

import com.geek.dao.CustomerDaoImpl;
import com.geek.dao.ProductDAOimpl;
import com.geek.model.Customer;
import com.geek.model.Product;
import com.geek.service.CustomerService;
import com.geek.service.ProductService;
import com.geek.spring.ContextConfig;
import com.geek.utils.SessionFactoryUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    private static AnnotationConfigApplicationContext context;
    public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(ContextConfig.class);

        SessionFactoryUtils sessionFactory = context.getBean(SessionFactoryUtils.class);

        try {
            ProductDAOimpl productDAOimpl = context.getBean(ProductDAOimpl.class);
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

            CustomerDaoImpl customerDao = context.getBean(CustomerDaoImpl.class);
            System.out.println(customerDao.getAllCustomers());
            System.out.println(customerDao.getCustomerById(2L));
            System.out.println(customerDao.getCustomerByName("Alex"));

            Customer customer = new Customer();
            customer.setName("David");
            customerDao.saveCustomer(customer);
            System.out.println(customerDao.getAllCustomers());

            Long customerID = customerDao.getCustomerByName("David").getId();
            customerDao.updateCustomerNameById(customerID, "Johannes");
            System.out.println(customerDao.getCustomerById(customerID));

            //тут начинается часть дз со звёздочкой, импровизировал
            CustomerService customerService = context.getBean(CustomerService.class);
            System.out.println(customerService.getPurchasedProductsByCustomerId(1L));
            System.out.println(customerService.getPurchasedProductsByCustomerId(2L));

            ProductService productService = context.getBean(ProductService.class);
            System.out.println(productService.getCustomersWhoPurchasedThisProduct(1L));
        }finally {
            sessionFactory.shutdown();
        }
    }
}
