package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Objects;

@Entity
public class Location {
    @Id
    @Column(name = "name")
    private String name;
    private Double latitude;
    private Double longitude;

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Location(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getName(), location.getName()) &&
                Objects.equals(getLatitude(), location.getLatitude()) &&
                Objects.equals(getLongitude(), location.getLongitude());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getLatitude(), getLongitude());
    }
}
