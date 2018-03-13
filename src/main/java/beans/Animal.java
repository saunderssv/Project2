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


    public Animal(){

    }
}
