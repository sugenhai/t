package cn.com.bosssoft.springcloud.serverprovide.service;

import cn.com.bosssoft.springcloud.serverprovide.domain.OrderList;

public interface SubmitOrderService {
    public boolean submitOrder(OrderList orderList)throws Exception;
}
