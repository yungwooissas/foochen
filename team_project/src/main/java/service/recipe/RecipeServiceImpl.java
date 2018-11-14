package service.recipe;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.recipe.RecipeDao;
import dto.recipe.RecipeDto;

@Service
public class RecipeServiceImpl implements RecipeService{
	private RecipeDao recipeDao;
	
	public RecipeServiceImpl() {}
	
	public RecipeServiceImpl(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}
	
	public RecipeDao getRecipeDao() {
		return recipeDao;
	}
	
	public void setRecipeDao(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}

	@Override
	public List<RecipeDto> rList() {
		return recipeDao.rList();
	}

	@Override
	public int rDelete(RecipeDto recipeDto) {
		return recipeDao.delete(recipeDto);
	}

	@Override
	public int rEdit(RecipeDto recipeDto) {
		return recipeDao.update(recipeDto);
	}

	@Override
	public void rWrite(RecipeDto recipeDto) {
		recipeDao.insert(recipeDto);
		
	}

	@Override
	public RecipeDto rRead(int rNumber) {
		recipeDao.updateReadCount(rNumber);
		return recipeDao.select(rNumber);
	}

}
