package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.InputDAO;

@Controller
public class SQLController {

	@Autowired
	private InputDAO inputDAO;
	
	@RequestMapping(path="GetResults.do")
	public ModelAndView getResults(@RequestParam ("query") String input){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		List<List<String>> items = inputDAO.queryByInput(input);
		mv.addObject("results" , items);
		return mv;
	
	}
	
}
