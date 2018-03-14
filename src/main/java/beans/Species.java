package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Species {
    @Id
    String species;
    public Species(){

    }

    public Species(String species){
        this.setSpecies(species);

    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Species species1 = (Species) o;
        return Objects.equals(getSpecies(), species1.getSpecies());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSpecies());
    }

    @Override
    public String toString() {
        return "Species{" +
                "species='" + species + '\'' +
                '}';
    }
}
