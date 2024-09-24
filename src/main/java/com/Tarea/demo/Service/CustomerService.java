package com.Tarea.demo.Service;

import com.Tarea.demo.Model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerService {
    List<Customer> getAllCustomer();
    }
