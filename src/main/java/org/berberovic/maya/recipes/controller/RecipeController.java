package org.berberovic.maya.recipes.controller;

import org.berberovic.maya.recipes.entity.Recipe;
import org.berberovic.maya.recipes.entity.RecipeCategory;
import org.berberovic.maya.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<Recipe> getAllRecipes() {
        List<Recipe> result = recipeService.listAllRecipes();
        return result;
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.createRecipe(recipe);
        return newRecipe;
    }

    @RequestMapping(value = "/recipes", params = "id", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public Recipe getRecipeById(@RequestParam("id") Integer recipeId) {
        Recipe result = recipeService.findRecipeById(recipeId);
        if (result == null) {
            throw new EntityNotFoundException("Recipe with id '" + recipeId +"' does not exist!");
        }
        return result;
    }

    @RequestMapping(value = "/recipes", params = "category", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<Recipe> getRecipeByCategory(@RequestParam("category") RecipeCategory recipeCategory) {
        List<Recipe> result = recipeService.listAllRecipes(recipeCategory);
        return result;
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    @ResponseBody
    public Recipe updateRecipe(@PathVariable(value = "id") Integer recipeId, @Valid @RequestBody Recipe recipe) {
        Recipe updated = recipeService.updateRecipe(recipeId, recipe);
        return updated;
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRecipe(@PathVariable(value = "id") Integer recipeId) {
        recipeService.deleteRecipe(recipeId);
        return ResponseEntity.ok().build();
    }



//    @RequestMapping(value = "/recipes", params = "category",
//            method = RequestMethod.GET, produces = {"application/json"})
//    @ResponseBody
//    public List<Recipe> getAllRecipesByCategory(@RequestParam("category") RecipeCategory category) {
//        List<Recipe> result = recipeService.listAllRecipes(category);
//        return result;
//    }
}
