package com.example.isdbweb;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.registry.HttpServiceClient;

@HttpServiceClient("stuffie")
public interface StuffieHttpClient {

	@GetExchange("/stuffies")
	List<Stuffie> all();

	@GetExchange("/stuffie/{id}/detail")
	Stuffie detail(@PathVariable int id);

	@GetExchange(url = "/stuffie/{id}/for")
	List<String> owners(@PathVariable int id);

	@GetExchange("/stuffie/{id}/pic")
	InputStream picture(@PathVariable int id);

}
