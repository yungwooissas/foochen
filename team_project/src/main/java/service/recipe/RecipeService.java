package service.recipe;

import java.util.List;

import dto.recipe.RecipeDto;

public interface RecipeService {
	// 사용할 메서드 선언
	public List<RecipeDto> rList();
	
	public abstract int rDelete(RecipeDto recipeDto);
	
	public abstract int rEdit(RecipeDto recipeDto);
	
	public abstract void rWrite(RecipeDto recipeDto);
	
	public abstract RecipeDto rRead(int rNumber);
}
