package app.domain;

import java.util.Objects;

public class Animal {
    private int id;
    private String speciesName;
    private String diet;
    private int numberOfAnimals;
    private String zooCode;

    public Animal(int id, String speciesName, String diet, int numberOfAnimals) {
        this.id = id;
        this.speciesName = speciesName;
        this.diet = diet;
        this.numberOfAnimals = numberOfAnimals;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Animal animal = (Animal) object;
        return id == animal.id && numberOfAnimals == animal.numberOfAnimals && Objects.equals(speciesName, animal.speciesName) && Objects.equals(diet, animal.diet) && Objects.equals(zooCode, animal.zooCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speciesName, diet, numberOfAnimals, zooCode);
    }

    @Override
    public String toString() {
        return String.format("ID: %d. Species: %s. Diet: %s. Number of animals in a zoo: %d, Zoo Code - %s",
                id, speciesName, diet, numberOfAnimals, zooCode);
    }

    public void setZooCode(String zooCode) {
        this.zooCode = zooCode;
    }


}
