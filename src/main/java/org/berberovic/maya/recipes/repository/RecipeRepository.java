package org.berberovic.maya.recipes.repository;

import org.berberovic.maya.recipes.entity.Recipe;
import org.berberovic.maya.recipes.entity.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query("select r from Recipe r where r.category = :category")
    List<Recipe> findByCategory(RecipeCategory category);
}
