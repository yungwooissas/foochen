package dao.recipe;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dto.recipe.RecipeDto;

@Repository
public class RecipeDaoMybatis implements RecipeDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public RecipeDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<RecipeDto> rList() {
		return sqlSessionTemplate.selectList("rList");
	}

	@Override
	public int delete(RecipeDto recipeDto) {
		return sqlSessionTemplate.delete("rDelete", recipeDto);
	}

	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("rDeleteAll");
	}

	@Override
	public int update(RecipeDto recipeDto) {
		return sqlSessionTemplate.update("rUpdate", recipeDto);
	}

	@Override
	public void insert(RecipeDto recipeDto) {
		sqlSessionTemplate.insert("rInsert", recipeDto);
		
	}

	@Override
	public int updateReadCount(int rNumber) {
		return sqlSessionTemplate.update("rUpdateCount", rNumber);
	}

	@Override
	public RecipeDto select(int rNumber) {
		RecipeDto dto = (RecipeDto) sqlSessionTemplate.selectOne("rSelect", rNumber);
		return dto;
	}
	
}
