package cn.cj.controller.label;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.cj.service.label.LabelService;

@Controller
public class LabelController {

	@Autowired
	private LabelService labelService;
	
	
	
}
