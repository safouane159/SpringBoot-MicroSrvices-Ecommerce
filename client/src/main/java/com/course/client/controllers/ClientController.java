package com.course.client.controllers;

import com.course.client.beans.*;
import com.course.client.proxies.MsCartProxy;
import com.course.client.proxies.MsOrderProxy;
import com.course.client.proxies.MsProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Long.valueOf;

@Controller
public class ClientController {

    @Autowired
    private MsProductProxy msProductProxy;

    @Autowired
    private MsOrderProxy msOrderProxy;
    @Autowired
    private MsCartProxy msCartProxy;

    @RequestMapping("/")
    public String index(Model model) {
        //  CartBean c = new CartBean(Long.valueOf(0));
        //  msCartProxy.createNewCart();
        List<ProductBean> products = msProductProxy.list();

        model.addAttribute("products", products);

        return "index";
    }

    @RequestMapping("/cart")
    public String cart(Model model) {


        Optional<CartBean> cartOptional = msCartProxy.getCart(valueOf(1));


        CartBean Cart = cartOptional.get();

        int count = Cart.getProducts().size();

        ArrayList<CardItemToDisplayBean> Products = new ArrayList<>();


        for (int i = 0; i < count; i++) {

            Optional<ProductBean> p = msProductProxy.get(Cart.getProducts().get(i).getProductId());


            CardItemToDisplayBean c = new CardItemToDisplayBean();
            c.setQuantite(valueOf(Cart.getProducts().get(i).getQuantity()) ) ;

            c.setProduct(p.get());
            c.setPrixTotal( Cart.getProducts().get(i).getPrixTotal()  );

            Products.add(c);



        }


        model.addAttribute("Cart", Cart);
        model.addAttribute("products", Products);

        return "cart";
    }



    @RequestMapping("/addItem/{id}")
    public RedirectView addItem(@PathVariable("id") Long idItem, Model model) {

       if(msCartProxy.itemExist(idItem)) {



           msCartProxy.increaseQuantity(idItem);



       }else{

           CartItemBean carteIteamBean = new CartItemBean();
           carteIteamBean.setProductId(idItem);
           carteIteamBean.setQuantity(1);
           msCartProxy.addProductToCart(valueOf(1), carteIteamBean);
       }


        ProductBean pb = msProductProxy.get(idItem).get();
        msCartProxy.updatePrixTotal(idItem,pb.getPrice());



        return new RedirectView("/cart");

    }

    @RequestMapping("/product-detail/{id}")
    public String detailsItem(@PathVariable("id") Long idItem, Model model) {


        Optional<ProductBean> productOptional = msProductProxy.get(idItem);
        if (productOptional.isPresent()) {
            ProductBean product = productOptional.get();

            model.addAttribute("product", product);
            return "detailsItem";
        } else {


            return "notFound";
        }


    }


    @RequestMapping("/addOrder")
    public RedirectView addOrder(Model model) {

        Optional<CartBean> cartOptional = msCartProxy.getCart(1L);

        CartBean Cart = cartOptional.get();


        msOrderProxy.addOrder(Cart);


       msCartProxy.resetCart();

        return new RedirectView("/orders");

    }
    @RequestMapping("/orders")
    public String Orders(Model model) {


        List<OrderBean> listOrders =  msOrderProxy.list();

        int countO = listOrders.size();

        ArrayList<OrderToDisplayBean> OrdersToDisplayList = new ArrayList<>();


        for (int i = 0; i < countO; i++) {

            ArrayList<OrderItemToDisplayBean> orderItemToDisplay = new ArrayList<>();

            int countOI =listOrders.get(i).getProducts().size();

            for (int g = 0; g < countOI; g++) {




                Optional<ProductBean> p = msProductProxy.get(listOrders.get(i).getProducts().get(g).getProductId());


                OrderItemToDisplayBean c = new OrderItemToDisplayBean();

                c.setQuantite(valueOf(listOrders.get(i).getProducts().get(g).getQuantity()) ) ;
                c.setProduct(p.get());
                c.setPrixTotal(listOrders.get(i).getProducts().get(g).getPrixTotal() );
                orderItemToDisplay.add(c);



            }

            OrderToDisplayBean orderToDisplayBean = new OrderToDisplayBean();

            orderToDisplayBean.setOrderItemToDisplayBean(orderItemToDisplay);
            orderToDisplayBean.setId(listOrders.get(i).getId() );

            orderToDisplayBean.setPrixOrder( listOrders.get(i).getPrixOrder()  );
            OrdersToDisplayList.add( orderToDisplayBean);


        }




        model.addAttribute("Orders", OrdersToDisplayList);

        return "orders";
    }
}
