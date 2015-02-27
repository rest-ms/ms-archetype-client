package ${groupId}.${projectPackage}.client.impl;

import ${groupId}.${projectPackage}.client.${className}Service;
import ${groupId}.${projectPackage}.dto.SimpleDTO;

import java.util.List;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ${className}ServiceJerseyClientImpl implements ${className}Service {

	private String baseUrl = "http://localhost:8080/";
	Client client;
	
	public ${className}ServiceJerseyClientImpl() {
		ClientConfig cc = new DefaultClientConfig();
		cc.getClasses().add(JacksonJsonProvider.class);
		client = Client.create(cc);
	}
	
	@Override
	public SimpleDTO sayHello(String name) {
		WebResource res = client.resource(baseUrl+"hello/"+name);
		ClientResponse response = res.accept("application/json").get(ClientResponse.class);
		if(response.getStatus() == 200)
			return response.getEntity(SimpleDTO.class);
		else
			throw new RuntimeException("error invoking service: "+response.getStatus());
	}
	
}
