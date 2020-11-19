package com.demo.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.demo.properties.AliPayProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/8/21$ 15:19
 **/
@Configuration
public class AliPayConfig {

    @Bean
    public AlipayClient alipayClient(AliPayProperties aliPayProperties){
        return new DefaultAlipayClient
                (aliPayProperties.getGatewayUrl() , aliPayProperties.getAppId(),aliPayProperties.getMerchantPrivateKey(), "json", "utf-8", aliPayProperties.getAlipayPublicKey(), aliPayProperties.getSignType());
    }

}
