package com.antsrl.formazione.simpledemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        PropertiesCofig.class,
        BusinessConfig.class,
        EngineConfig.class,
        CarConfig.class,
        TruckConfig.class})
@Configuration
public class AppConfig {
}
