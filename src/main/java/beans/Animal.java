package beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @Column(name = "name")
    private String name;
    private char sex;
    private Double weight;
    private String personality;
    private String info;
    @ManyToOne
    @JoinColumn(name = "name")
    private Location area;
    private Genus genus;
    private Species species;


    public Animal(){

    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", weight=" + weight +
                ", personality='" + personality + '\'' +
                ", info='" + info + '\'' +
                ", area=" + area +
                ", genus=" + genus +
                ", species=" + species +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return getSex() == animal.getSex() &&
                Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getWeight(), animal.getWeight()) &&
                Objects.equals(getPersonality(), animal.getPersonality()) &&
                Objects.equals(getInfo(), animal.getInfo()) &&
                Objects.equals(getArea(), animal.getArea()) &&
                Objects.equals(getGenus(), animal.getGenus()) &&
                Objects.equals(getSpecies(), animal.getSpecies());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getSex(), getWeight(), getPersonality(), getInfo(), getArea(), getGenus(), getSpecies());
    }

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Location getArea() {
        return area;
    }

    public void setArea(Location area) {
        this.area = area;
    }
}
