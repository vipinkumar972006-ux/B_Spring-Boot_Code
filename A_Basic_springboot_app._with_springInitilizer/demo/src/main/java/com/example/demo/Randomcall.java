package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Randomcall {

	public static void main(String[] args) 
	{
		SpringApplication.run(Randomcall.class, args);
		Hellocontroller a=new Hellocontroller();
		String result=a.hellocontroller();
		System.out.println(result);
	}
}
