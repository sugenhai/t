package cn.com.bosssoft.springcloud.serverprovide.service;

import cn.com.bosssoft.springcloud.serverprovide.domain.OrderList;
import cn.com.bosssoft.springcloud.serverprovide.mapper.OrderListMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class SelectOrderServiceImp implements SelectOrderService{

    @Autowired
    private OrderListMapper orderListMapper;

    public OrderList selectOrderByNo(String orderNo)throws Exception{
        OrderList orderList = new OrderList();
        orderList = orderListMapper.selectById(orderNo);
        return orderList;
    }

    @Override
    public List<OrderList> selectAllOrder() throws Exception {
       EntityWrapper wq=new EntityWrapper();
        List<OrderList> orderLists=orderListMapper.selectList(wq);
        return orderLists;
    }
}
