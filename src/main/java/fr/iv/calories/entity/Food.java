package fr.iv.calories.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "kcal_per_hundred_grams")
    private int kcalPerHundredGm;

    public Food() {

    }

    public Food(String type, String name, int kcalPerHundredGm) {
        this.type = type;
        this.name = name;
        this.kcalPerHundredGm = kcalPerHundredGm;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcalPerHundredGm() {

        return kcalPerHundredGm;
    }

    public void setKcalPerHundredGm(int kcalPerHundredGm) {
        this.kcalPerHundredGm = kcalPerHundredGm;
    }

}
