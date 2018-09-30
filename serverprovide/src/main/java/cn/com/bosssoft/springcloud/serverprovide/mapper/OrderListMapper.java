package cn.com.bosssoft.springcloud.serverprovide.mapper;

import cn.com.bosssoft.springcloud.serverprovide.domain.OrderList;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

//@Mapper

public interface OrderListMapper extends BaseMapper<OrderList>{
//    @Insert("INSERT INTO orderlist VALUES(#{orderNo},#{orderDate},#{orderAmount},#{orderTitle})")
//    public boolean insertOrder(OrderList orderList)throws Exception;
//    @Select("select * from orderlist where orderNo=#{orderNo}")
//    public OrderList selectOrderByOrderNo(String orderNo)throws Exception;
}
