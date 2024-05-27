package app.service;

import app.domain.Animal;
import app.repository.AnimalRepositoryList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("classpath:application.properties")
public class AnimalServiceImpl implements AnimalService {
    private AnimalRepositoryList animalRepository;
    private String zooCode;

    public AnimalServiceImpl(
            AnimalRepositoryList animalRepository,
            @Value("${zoo.code}") String zooCode) {
        this.animalRepository = animalRepository;
        this.zooCode = zooCode;
    }
    public void add(Animal animal) {
        animalRepository.animalList.add(animal);
    }

    @Override
    public Animal getById(int id) {
        Animal animal = animalRepository.getById(id);
        setZooCode(animal);
        return animal;
    }

    private void setZooCode(Animal animal) {
        String article = String.format("%s",zooCode);
        animal.setZooCode(article);
    }


}
