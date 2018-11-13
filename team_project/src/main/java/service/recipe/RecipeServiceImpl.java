package service.recipe;

import dao.recipe.RecipeDao;

public class RecipeServiceImpl implements RecipeService{
	private RecipeDao recipeDao;

	public RecipeServiceImpl(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}

}
