package org.berberovic.maya.recipes.repository;

import org.berberovic.maya.recipes.entity.Recipe;
import org.berberovic.maya.recipes.entity.RecipeCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    @Query("select r from Recipe r where r.category = :category")
    List<Recipe> findByCategory(@Param("category") RecipeCategory category);
}
