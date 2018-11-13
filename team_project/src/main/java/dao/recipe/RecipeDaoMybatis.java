package dao.recipe;

import org.mybatis.spring.SqlSessionTemplate;

public class RecipeDaoMybatis implements RecipeDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public RecipeDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
}
