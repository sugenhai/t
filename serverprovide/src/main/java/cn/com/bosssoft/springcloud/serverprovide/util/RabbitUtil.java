//package cn.com.bosssoft.springcloud.serverprovide.util;
//
//
//import cn.com.bosssoft.springcloud.serverprovide.domain.OrderList;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//@Component
//
//@Slf4j
//public class RabbitUtil {
//
//    @RabbitHandler
//    @RabbitListener(queues = "order",containerFactory = "rabbitListenerContainerFactory")
//    public void process(@Payload OrderList orderList){
//        log.info("接收:"+orderList);
//    }
//}
