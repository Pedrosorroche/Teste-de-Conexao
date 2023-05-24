package com.teste.controller;

import java.io.IOException;
import java.net.InetAddress;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableScheduling
public class TestaConexaoController {
	
	//private boolean isOnline = false;
	
	@GetMapping("/")
	public String getInternetStatus(Model model) {
		boolean isOnline = verificarConexaoInternet();
		String status = isOnline ? "Online" : "Offline";
		model.addAttribute("status",status);
		return "index.html";
	}

	//@Scheduled(fixedRate = 10000)
	private boolean verificarConexaoInternet() {
		 try {
	            InetAddress.getByName("www.google.com.br").isReachable(1000);
	            System.out.println("PASSOOOOOUUUUUUU AQUIIIIIIIII!");
	            return true;
	        } catch (IOException e) {
	            return false;
	        }
	}

}
