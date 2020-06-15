package jp.ac.hcs.S3A142.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PoratlController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
