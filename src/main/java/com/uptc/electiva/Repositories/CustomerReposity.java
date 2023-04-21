package com.uptc.electiva.Repositories;

import com.uptc.electiva.Entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerReposity extends JpaRepository<CustomerEntity,Integer> {
}
