package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author artrayme
 * 12/5/21
 */
public class Dish {
    private final List<String> ingredients = new ArrayList<>();
    private final List<String> instructions = new ArrayList<>();
    private String commonInformation;
    private String cuisine;
    private String type;
    private LocalTime cookingTime;
    private String additional;
    private String name;

    public Dish(String name) {
        this.name = name;
    }

    public String getCommonInformation() {
        return commonInformation;
    }

    public void setCommonInformation(String commonInformation) {
        this.commonInformation = commonInformation;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalTime getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(LocalTime cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void addIngredients(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, instructions, commonInformation, cuisine, type, cookingTime, additional, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dish dish = (Dish) o;
        return Objects.equals(ingredients, dish.ingredients) && Objects.equals(instructions, dish.instructions) && Objects.equals(commonInformation, dish.commonInformation) && Objects.equals(cuisine, dish.cuisine) && Objects.equals(type, dish.type) && Objects.equals(cookingTime, dish.cookingTime) && Objects.equals(additional, dish.additional) && Objects.equals(name, dish.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
