package com.example.isdbweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@ImportHttpServices(group = "stuffie", types = StuffieHttpClient.class)
@Configuration
public class ClientConfig {

}
