package beans;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Genus {
   private String genus;
   public Genus(){

   }

    public Genus(String genus){
    this.setGenus(genus);
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genus genus1 = (Genus) o;
        return Objects.equals(getGenus(), genus1.getGenus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getGenus());
    }
}
