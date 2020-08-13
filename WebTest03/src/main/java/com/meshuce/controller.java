package com.meshuce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class controller {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

}


