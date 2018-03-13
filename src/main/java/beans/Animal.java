package beans;

import javax.persistence.*;

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
