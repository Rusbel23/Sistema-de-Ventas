package com.Tarea.demo.Repository;

import com.Tarea.demo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
