package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
