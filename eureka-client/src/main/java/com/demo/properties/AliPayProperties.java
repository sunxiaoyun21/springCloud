package com.demo.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/8/21$ 15:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "alipay")
@Component
public class AliPayProperties {

    private String uid;
    private String appId;
    private String merchantPrivateKey;
    private  String alipayPublicKey;
    private String notifyUrl;
    private String returnUrl;
    private String signType;
    private String gatewayUrl;
}
