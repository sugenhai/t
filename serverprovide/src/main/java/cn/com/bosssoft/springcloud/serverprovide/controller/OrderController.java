package cn.com.bosssoft.springcloud.serverprovide.controller;


import cn.com.bosssoft.springcloud.serverprovide.domain.OrderList;
import cn.com.bosssoft.springcloud.serverprovide.service.SelectOrderServiceImp;
import cn.com.bosssoft.springcloud.serverprovide.service.SubmitOrderServiceImp;

import cn.com.bosssoft.springcloud.serverprovide.util.JedisUtil;
import com.bosssoft.platform.common.redis.client.JedisConnection;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private SubmitOrderServiceImp submitOrderServiceImp;

    @Autowired
    private SelectOrderServiceImp selectOrderServiceImp;

   @Autowired
    private JedisUtil jedisUtil;

   @Autowired
    private AmqpTemplate rabbitmqTemplate;


    @RequestMapping(value = "/submit")
    public String submitOrder(@RequestBody OrderList orderList) {

//        Order order = null;
//        order.setOrderNo(orderNo);
//        order.setOrderDate(orderDate);
//        order.setOrderAmount(orderAmount);
//        order.setOrderTitle(orderTitle);
//        System.out.println(orderList.getOrderNo());
        try {
            if (submitOrderServiceImp.submitOrder(orderList)) {

                jedisUtil.submit(orderList);
                rabbitmqTemplate.convertAndSend("order",orderList);
                return("SUCCESS");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "FAILURE";
    }

    @RequestMapping(value = "/selectOrderByNo")
    public OrderList displayOrderInfo(@RequestParam(name = "orderNo")String orderNo){
        OrderList orderList = new OrderList();
        try{
            if (jedisUtil.existOrder(orderNo)){
                orderList = jedisUtil.getOrder(orderNo);
                return orderList;
//                System.out.println(orderList);
            }
            orderList = selectOrderServiceImp.selectOrderByNo(orderNo);
//            if (orderList.getOrderNo().equals(null)){
//
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println(orderList);
        return orderList;

    }
    @RequestMapping(value = "/selectAll")
    public List<OrderList> selectAllOrder() throws Exception {
        List<OrderList> orderLists = selectOrderServiceImp.selectAllOrder();
        for(OrderList orderList:orderLists)
        {
            System.out.println(orderList.getOrderNo());
        }
        return orderLists;
    }

}