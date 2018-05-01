package org.berberovic.maya.recipes.service;

import org.berberovic.maya.recipes.entity.Recipe;
import org.berberovic.maya.recipes.entity.RecipeCategory;
import org.berberovic.maya.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe createRecipe(String name, String catagory) {
        return recipeRepository.save(new Recipe(name, RecipeCategory.valueOf(catagory)));
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> listAllRecipes() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    @Override
    public List<Recipe> listAllRecipes(RecipeCategory recipeCategory) {
        return recipeRepository.findByCategory(recipeCategory);
    }

    @Override
    public Recipe findRecipeById(Integer recipeId) {
        return recipeRepository.getOne(recipeId);
    }

    @Override
    public Recipe updateRecipe(Integer recipeId, Recipe recipe) {
        Recipe saved = recipeRepository.getOne(recipeId);
        saved.setName(recipe.getName());
        saved.setCategory(recipe.getCategory());
        saved.setCookingTime(recipe.getCookingTime());
        saved.setPreparationTime(recipe.getPreparationTime());
        saved.setNrOfPersons(recipe.getNrOfPersons());
        saved.setNumberOfStars(recipe.getNumberOfStars());
        return recipeRepository.save(saved);
    }

    @Override
    public void deleteRecipe(Integer recipeId) {
        Recipe saved = recipeRepository.getOne(recipeId);
        recipeRepository.delete(saved);
    }
}
