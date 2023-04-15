package com.course.client.proxies;

import com.course.client.beans.CartBean;
import com.course.client.beans.CartItemBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "ms-cart", url = "localhost:8092")
public interface MsCartProxy {

    @PostMapping(value = "/cart")
    public ResponseEntity<CartBean> createNewCart();

    @GetMapping(value = "/cart/{id}")
    public Optional<CartBean> getCart(@PathVariable Long id);
    @GetMapping(value = "/increaseQuantity/{id}")
    public boolean increaseQuantity(@PathVariable Long id);
    @GetMapping(value = "/itemExist/{id}")
    public boolean itemExist(@PathVariable Long id);
    @PostMapping(value = "/cart/{id}")
    public ResponseEntity<CartItemBean> addProductToCart(@PathVariable Long id, @RequestBody CartItemBean cartItem);
    @PostMapping(value = "/updatePrixTotal/{id}")
    public boolean updatePrixTotal(@PathVariable Long id, @RequestBody double prix);



    @PostMapping(value = "/resetCart")
    public boolean resetCart();
}
