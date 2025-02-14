package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
