package cn.com.bosssoft.springcloud.serverprovide.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderList {
    private String orderNo;
    private String orderDate;
    private Double orderAmount;
    private String orderTitle;
}
