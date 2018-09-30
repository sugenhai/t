package cn.com.bosssoft.springcloud.serverprovide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@MapperScan("cn.com.bosssoft.springcloud.serverprovide.mapper")
public class ServerprovideApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerprovideApplication.class, args);
	}
}
