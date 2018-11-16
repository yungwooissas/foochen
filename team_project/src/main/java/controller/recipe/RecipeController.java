package controller.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.recipe.RecipeDto;
import service.rcomment.RCommentService;
import service.recipe.RecipeService;

@Controller
public class RecipeController {
	private RecipeService recipeService;
	private RCommentService rcommentService;
	
	public RecipeController(RecipeService recipeService, RCommentService rcommentService) {
		super();
		this.recipeService = recipeService;
		this.rcommentService = rcommentService;
	}
	
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	// 리스트 출력
	@RequestMapping(value="/recipe/recipelist")
	public String list(Model model) {
		model.addAttribute("recipeList", recipeService.rList());
		return "/recipe/list";
	}
	
	//상세 글보기
	@RequestMapping(value="/recipe/read/{rNumber}")
	public String read(Model model, @PathVariable int rNumber) {
		model.addAttribute("recipeDto", recipeService.rRead(rNumber));
		return "/recipe/read";
	}
	
	// 새 글 작성을 위한 요청을 처리
	@RequestMapping(value="/recipe/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("recipeDto", new RecipeDto());
		return "/recipe/write";
	}
	
	// 새 글 등록을 위한 요청을 처리
	@RequestMapping(value="/recipe/write", method=RequestMethod.POST)
	public String write(RecipeDto recipeDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/recipe/write";
		}
		recipeService.rWrite(recipeDto);
		return "redirect:/recipe/list";
	}
	
	
}
