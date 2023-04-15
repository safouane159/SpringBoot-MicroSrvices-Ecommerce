package com.course.cart.repositories;

import com.course.cart.domain.Cart;
import com.course.cart.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByProductId(Long productId);

}
