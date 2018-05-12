package org.berberovic.maya.recipes.service;

import org.berberovic.maya.recipes.entity.Recipe;
import org.berberovic.maya.recipes.entity.RecipeCategory;
import org.berberovic.maya.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Recipe> result = recipeRepository.findById(recipeId);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public Recipe updateRecipe(Integer recipeId, Recipe recipe) {
        Optional<Recipe> result = recipeRepository.findById(recipeId);
        if (result.isPresent()) {
            Recipe savedRecipe = result.get();
            savedRecipe.setName(recipe.getName());
            savedRecipe.setCategory(recipe.getCategory());
            savedRecipe.setCookingTime(recipe.getCookingTime());
            savedRecipe.setPreparationTime(recipe.getPreparationTime());
            savedRecipe.setNrOfPersons(recipe.getNrOfPersons());
            savedRecipe.setNumberOfStars(recipe.getNumberOfStars());
            return recipeRepository.save(savedRecipe);
        } else {
            Recipe newRecipe = new Recipe(recipe.getName(), recipe.getCategory());
            newRecipe.setName(recipe.getName());
            newRecipe.setCategory(recipe.getCategory());
            newRecipe.setCookingTime(recipe.getCookingTime());
            newRecipe.setPreparationTime(recipe.getPreparationTime());
            newRecipe.setNrOfPersons(recipe.getNrOfPersons());
            newRecipe.setNumberOfStars(recipe.getNumberOfStars());
            return recipeRepository.save(newRecipe);
        }
    }

    @Override
    public void deleteRecipe(Integer recipeId) {
        Optional<Recipe> saved = recipeRepository.findById(recipeId);
        recipeRepository.delete(saved.get());
    }
}
