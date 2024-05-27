package app.controller;

import app.domain.Animal;
import app.service.AnimalServiceImpl;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
public class AnimalController {
    private AnimalServiceImpl service;

    public AnimalController(AnimalServiceImpl animalService) {
        this.service = animalService;
    }

    public Animal getById(int id) {
        return service.getById(id);
    }


    public List<Animal> loadFromFile() {
        List<Animal> animals = new ArrayList<>();

        // For some unknown reason IDEA only detects file path when I'm using the ultimate path to the file.
        // No other option works so...it just works that way I guess
        try (Scanner scanner = new Scanner(new FileInputStream("D:\\___WORK\\projects\\javaHW2\\resources\\CSVZooDB.csv"))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }

                Animal ticket = getFromCSV(line);
                animals.add(ticket);
            }
            return animals;
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return null;
        }
    }

    public List<Animal> loadAnimalsFromFile() {
        List<Animal> animalList = loadFromFile();
        for (Animal animals : animalList) {
            service.add(animals);
        }
        return animalList;
    }

    public static Animal getFromCSV(String line) throws IOException {
        String[] parts = line.split(";");

        int id = Integer.parseInt(parts[0]);

        String speciesName = parts[1];

        String diet = parts[2];

        int numberOfAnimals = Integer.parseInt(parts[3]);

        return new Animal(id, speciesName, diet, numberOfAnimals);
    }

}
