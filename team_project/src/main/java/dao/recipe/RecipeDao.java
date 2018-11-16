package dao.recipe;

import java.util.List;

import dto.recipe.RecipeDto;

public interface RecipeDao {
	// 사용할 메서드 선언
	
	public abstract List<RecipeDto> rList();
	
	public abstract int delete(RecipeDto recipeDto);
	
	public abstract int deleteAll();
	
	public abstract int update(RecipeDto recipeDto);
	
	public abstract void insert(RecipeDto recipeDto);
	
	public abstract RecipeDto select(int rNumber);
	
	public abstract int updateReadCount(int rNumber);
}
