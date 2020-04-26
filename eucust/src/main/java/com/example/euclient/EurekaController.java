package com.example.euclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaController {
	
@Autowired
public RestTemplate restTemplate;

@GetMapping("/process/{product}")
public String getHelloWorld (@PathVariable String product)
{
	String nm = restTemplate.getForObject("http://PAY-SERVICE/process/" + product ,String.class);	
	return "Eucustomer" +  product + " res=" + nm;	
}

}