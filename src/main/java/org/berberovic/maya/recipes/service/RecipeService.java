package org.berberovic.maya.recipes.service;

import org.berberovic.maya.recipes.entity.Recipe;
import org.berberovic.maya.recipes.entity.RecipeCategory;

import java.util.List;

public interface RecipeService {
    Recipe createRecipe(String name, String catagory);

    Recipe createRecipe(Recipe recipe);

    List<Recipe> listAllRecipes();

    List<Recipe> listAllRecipes(RecipeCategory recipeCategory);

    Recipe findRecipeById(Integer recipeId);

    Recipe updateRecipe(Integer recipeId, Recipe recipe);

    void deleteRecipe(Integer recipeId);
}
