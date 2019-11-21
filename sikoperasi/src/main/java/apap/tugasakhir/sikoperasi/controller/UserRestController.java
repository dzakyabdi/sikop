package apap.tugasakhir.sikoperasi.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Mono;

@Controller
public class UserRestController {
	@Autowired
	private UserRestService userRestService;
	
	@GetMapping(value="/user/profile")
	private Map<String, String> profile(@RequestParam("id") String id) {
		try {
			return recipeRestService.getRecipe(excludeIngredients);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Recipe " +  excludeIngredients +" Not Found");
		}
	}
}
