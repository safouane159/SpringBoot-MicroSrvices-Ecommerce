package com.course.client.proxies;


import com.course.client.beans.CartBean;
import com.course.client.beans.CartItemBean;
import com.course.client.beans.OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@FeignClient(name = "ms-orders", url = "localhost:8094")
public interface MsOrderProxy {


    @PostMapping(value = "/addOrder")
    public RedirectView addOrder(@RequestBody CartBean cartBean);

    @GetMapping(value = "/orders")
    public List<OrderBean> list();
}
