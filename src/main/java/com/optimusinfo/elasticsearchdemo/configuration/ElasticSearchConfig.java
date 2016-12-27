package com.optimusinfo.elasticsearchdemo.configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@PropertySource(value = "classpath:elasticsearch.properties")
@EnableElasticsearchRepositories(basePackages = "com.optimusinfo.elasticsearchdemo.repository")
public class ElasticSearchConfig {

	@Resource
    private Environment environment;
	
    @Bean
    public Client client() {
        TransportClient client = TransportClient.builder().build();
        TransportAddress address;
		try {
			address = new InetSocketTransportAddress(InetAddress.getByName(environment.getProperty("elasticsearch.host")),
					Integer.parseInt(environment.getProperty("elasticsearch.port")));
			client.addTransportAddress(address);
			
		} catch (NumberFormatException | UnknownHostException exception) {
			exception.printStackTrace();
		}
        
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}
