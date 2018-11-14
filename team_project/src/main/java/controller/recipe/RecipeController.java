package controller.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@RequestMapping(value="/recipe/list")
	public String list() {
		return recipeService.rList().toString();
	}
	
}
