package p2.backend.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "Food")
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "foodId")
    private int foodId;

    @Column(name = "foodName")
    private String foodName;

    @Column(name ="amount")
    private int amount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Food_Animal", joinColumns = @JoinColumn(name = "foodId", referencedColumnName = "foodId"),
            inverseJoinColumns = @JoinColumn(name = "animalId", referencedColumnName = "animalId"))
    private Set<Animal> animalFood;

    public Set<Animal> getAnimalFood() {
        return animalFood;
    }

    public void setAnimalFood(Set<Animal> animalFood) {
        this.animalFood = animalFood;
    }

    public Food(){

    }

    public Food(String foodName, int amount) {
        this.foodName = foodName;
        this.amount = amount;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return getFoodId() == food.getFoodId() &&
                getAmount() == food.getAmount() &&
                Objects.equals(getFoodName(), food.getFoodName()) &&
                Objects.equals(getAnimalFood().hashCode(), food.getAnimalFood().hashCode());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFoodId(), getFoodName(), getAmount(), getAnimalFood().hashCode());
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("foodName",foodName)
                .put("amount",amount);
        return json.toString();
    }
}
