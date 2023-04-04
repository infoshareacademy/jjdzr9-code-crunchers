package com.isa.jjdzr.configuration;

import com.isa.jjdzr.service.SearchEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SearchEngineConfiguration {

    @Bean
    SearchEngine searchEngine() {
        return new SearchEngine();
    }
}
