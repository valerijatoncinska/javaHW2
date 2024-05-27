package app.repository;

import app.domain.Animal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AnimalRepositoryList implements AnimalRepository {
    public List<Animal> animalList = new ArrayList<>();

    public AnimalRepositoryList() {
//        animalList.add(new Animal(1, "Lion", "Carnivore", 5));
//        animalList.add(new Animal(2, "Elephant", "Herbivore", 2));
//        animalList.add(new Animal(3, "Hippopotamus", "Omnivore", 1));
//        animalList.add(new Animal(4, "Emu", "Herbivore", 3));
//        animalList.add(new Animal(5, "Bear", "Omnivore", 2));

    }

    @Override
    public Animal getById(int id) {
        return animalList.get(id - 1);
    }


}
