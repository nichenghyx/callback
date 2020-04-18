package com.example.osscallbak.callbak;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author ly
 * @version 1.0
 * @date 2020/4/17 8:44
 */
@Configuration
public class FileMax {
    /**
          * 文件上传配置
          * @return
          */

   @Bean
    public MultipartConfigElement multipartConfigElement() {

        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize(DataSize.parse("100MB")); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("100MB"));
        return factory.createMultipartConfig();

    }
}
