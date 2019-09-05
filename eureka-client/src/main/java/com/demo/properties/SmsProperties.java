package com.demo.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/3 16:47
 **/
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix= "sms")
public class SmsProperties {

        private String accessKeyId;
        private String accessSecret;


}
