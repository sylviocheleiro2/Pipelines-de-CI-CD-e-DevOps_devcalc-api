package br.com.infnet.dev_calc_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevCalc1Application {

	public static void main(String[] args)
	{
		System.out.println("RODANDO SERVER");
		SpringApplication.run(DevCalc1Application.class, args);
	}

}
