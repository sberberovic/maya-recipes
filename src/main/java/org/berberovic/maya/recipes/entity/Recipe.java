package org.berberovic.maya.recipes.entity;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @SequenceGenerator(name = "ID_SEQ", sequenceName = "recipe_id_seq")
    @GeneratedValue(generator = "ID_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private RecipeCategory category;
    @Column(name = "number_of_persons")
    private Integer nrOfPersons;
    @Column(name = "preparation_time")
    private Integer preparationTime;
    @Column(name = "cooking_time")
    private Integer cookingTime;
    @Column(name = "number_of_stars")
    private Integer numberOfStars;

    public Recipe() {
    }

    public Recipe(String name, RecipeCategory category) {
        this.name = name;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeCategory getCategory() {
        return category;
    }

    public void setCategory(RecipeCategory category) {
        this.category = category;
    }

    public Integer getNrOfPersons() {
        return nrOfPersons;
    }

    public void setNrOfPersons(Integer nrOfPersons) {
        this.nrOfPersons = nrOfPersons;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }
}
