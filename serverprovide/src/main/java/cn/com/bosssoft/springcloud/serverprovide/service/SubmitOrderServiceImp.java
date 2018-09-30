package cn.com.bosssoft.springcloud.serverprovide.service;

import cn.com.bosssoft.springcloud.serverprovide.domain.OrderList;
import cn.com.bosssoft.springcloud.serverprovide.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmitOrderServiceImp {

    @Autowired
  private OrderListMapper orderListMapper;

    public boolean submitOrder(OrderList orderList)throws Exception{
        if(orderListMapper.insert(orderList)!=0){
            return true;
        }
        else {
            return false;
        }
    }

}
