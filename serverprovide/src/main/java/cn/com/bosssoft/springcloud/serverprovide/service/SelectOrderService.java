package cn.com.bosssoft.springcloud.serverprovide.service;

import cn.com.bosssoft.springcloud.serverprovide.domain.OrderList;

import java.util.List;

public interface SelectOrderService {
    public OrderList selectOrderByNo(String orderNo)throws Exception;

    public List<OrderList> selectAllOrder()throws Exception;
}
