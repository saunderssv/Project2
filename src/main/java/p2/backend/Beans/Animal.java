package p2.backend.Beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "animal")
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "animalId")
    private int animalId;

    @Column(name = "animalName")
    private String animalName;

    @Column(name = "scientificName")
    private String scientificName;

    @Column(name = "funFact")
    private String funFact;

    @Column(name = "summary")
    private String summary;

    @Column(name = "numOfAnimal")
    private int numOfAnimal;

    private int tracking;

    @ManyToMany(mappedBy = "animalFood")
    @JsonManagedReference
    private Set<Food> food;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnore
    private Set<Employee> employees;


    public Animal(){

    }

    public Animal(String animalName, String scientificName, String funFact, String summary, int numOfAnimal, int tracking, Set<Food> food, Set<Employee> employees) {
        this.animalName = animalName;
        this.scientificName = scientificName;
        this.funFact = funFact;
        this.summary = summary;
        this.numOfAnimal = numOfAnimal;
        this.tracking = tracking;
        this.food = food;
        this.employees = employees;
    }

    public Animal(String animalName, String scientificName, String funFact, String summary, int numOfAnimal, int tracking) {
        this.animalName = animalName;
        this.scientificName = scientificName;
        this.funFact = funFact;
        this.summary = summary;
        this.numOfAnimal = numOfAnimal;
        this.tracking = tracking;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getNumOfAnimal() {
        return numOfAnimal;
    }

    public void setNumOfAnimal(int numOfAnimal) {
        this.numOfAnimal = numOfAnimal;
    }

    public int getTracking() {
        return tracking;
    }

    public void setTracking(int tracking) {
        this.tracking = tracking;
    }

    public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId &&
                numOfAnimal == animal.numOfAnimal &&
                tracking == animal.tracking &&
                Objects.equals(animalName, animal.animalName) &&
                Objects.equals(scientificName, animal.scientificName) &&
                Objects.equals(funFact, animal.funFact) &&
                Objects.equals(summary, animal.summary) &&
                Objects.equals(food, animal.food) &&
                Objects.equals(employees, animal.employees);
    }

    @Override
    public int hashCode() {

        return Objects.hash(animalId, animalName, scientificName, funFact, summary, numOfAnimal, tracking);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("animalName",animalName)
                .put("scientificName",scientificName)
                .put("funFact",funFact)
                .put("summary",summary)
                .put("numOfAnimal",numOfAnimal)
                .put("tracking",tracking)
                .putPOJO("food",food)
                .putPOJO("employees",employees);
        return json.toString();
    }
}
