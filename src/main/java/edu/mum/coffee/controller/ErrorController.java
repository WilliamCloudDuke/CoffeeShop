package edu.mum.coffee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorController {

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exception(final Throwable throwable, final Model model) {
		String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
		model.addAttribute("errorMessage", errorMessage);
		return "error";
	}

}
