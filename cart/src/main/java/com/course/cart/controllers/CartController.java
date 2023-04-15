package com.course.cart.controllers;

import com.course.cart.domain.Cart;
import com.course.cart.domain.CartItem;
import com.course.cart.repositories.CartItemRepository;
import com.course.cart.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

import static java.lang.Long.valueOf;

@RestController
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @PostMapping(value = "/cart")
    public ResponseEntity<Cart> createNewCart()
    {
        Cart cart = cartRepository.save(new Cart());

        if (cart == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new cart");

        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }

    @GetMapping(value = "/cart/{id}")
    public Optional<Cart> getCart(@PathVariable Long id)
    {
        Optional<Cart> cart = cartRepository.findById(id);

        if (cart == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't get cart");

        return cart;
    }
    @GetMapping(value = "/itemExist/{id}")
    public boolean itemExist(@PathVariable Long id)
    {
        boolean isJavaFun ;
       CartItem cartitem =  cartItemRepository.findByProductId(id);

        if (cartitem == null) {isJavaFun = false;}
        else {isJavaFun = true;}


        return isJavaFun;
    }
    @GetMapping(value = "/increaseQuantity/{id}")
    public boolean increaseQuantity(@PathVariable Long id)
    {
        CartItem cartItem =  cartItemRepository.findByProductId(id);
        cartItem.setQuantity(cartItem.getQuantity()+1);
        cartItemRepository.save(cartItem);
        return true;
    }



    @PostMapping(value = "/cart/{id}")
    @Transactional
    public ResponseEntity<CartItem> addProductToCart(@PathVariable Long id, @RequestBody CartItem cartItem)
    {
        Cart cart = cartRepository.getOne(id);

        if (cart == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't get cart");


        cart.addProduct(cartItem);

        cartRepository.save(cart);

        return new ResponseEntity<CartItem>(cartItem, HttpStatus.CREATED);
    }

    @PostMapping(value = "/updatePrixTotal/{id}")
    public boolean updatePrixTotal(@PathVariable Long id, @RequestBody double prix )
    {
        CartItem cartItem =  cartItemRepository.findByProductId(id);
        Cart cart = cartRepository.getOne(valueOf(1));
        cartItem.setPrixTotal( (cartItem.getQuantity() * prix));
        cart.setPrixCart();
        cartItemRepository.save(cartItem);
        return true;
    }


    @PostMapping(value = "/resetCart")
    public boolean resetCart( )
    {

        Cart cart = cartRepository.getOne(valueOf(1));

        cart.setProducts(null);
        cart.setPrixCart(0.0);


        cartRepository.save(cart);

        cartItemRepository.deleteAll();
        return true;
    }


}
