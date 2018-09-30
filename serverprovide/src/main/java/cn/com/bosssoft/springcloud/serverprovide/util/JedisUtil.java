package cn.com.bosssoft.springcloud.serverprovide.util;

import cn.com.bosssoft.springcloud.serverprovide.domain.OrderList;
import com.bosssoft.platform.common.redis.client.JedisConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JedisUtil {

    public boolean submit(OrderList orderList){
        JedisConnection jedisConnection = JedisConnection.getInstance();
        jedisConnection.set("orderNo"+orderList.getOrderNo(),orderList.getOrderNo());
        jedisConnection.set("orderDate"+orderList.getOrderNo(),orderList.getOrderDate());
        jedisConnection.set("orderAmount"+orderList.getOrderNo(),orderList.getOrderAmount().toString());
        jedisConnection.set("orderTitle"+orderList.getOrderNo(),orderList.getOrderTitle());

        return true;
    }

    public boolean existOrder(String orderNo){
        JedisConnection jedisConnection = JedisConnection.getInstance();
        String No = jedisConnection.get("orderNo"+orderNo);
        if (orderNo.equals(No)){
            return true;
        }
        return false;
    }

    public OrderList getOrder(String orderNo){
        OrderList orderList = new OrderList();
        JedisConnection jedisConnection = JedisConnection.getInstance();
        orderList.setOrderNo(jedisConnection.get("orderNo"+orderNo));
        orderList.setOrderDate(jedisConnection.get("orderDate"+orderNo));
        orderList.setOrderAmount(Double.parseDouble(jedisConnection.get("orderAmount"+orderNo)));
        orderList.setOrderTitle(jedisConnection.get("orderTitle"+orderNo));
        return orderList;
    }
}
