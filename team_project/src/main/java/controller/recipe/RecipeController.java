package controller.recipe;

import org.springframework.stereotype.Controller;

import service.rcomment.RCommentService;
import service.recipe.RecipeService;

@Controller
public class RecipeController {
	private RecipeService recipeService;
	private RCommentService rcommentService;
	
	public RecipeController(RecipeService recipeService, RCommentService rcommentService) {
		this.recipeService = recipeService;
		this.rcommentService = rcommentService;
	}
	
	
	
}
