package utez.edu.mx.buenas.practicas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.buenas.practicas.model.Person;
import utez.edu.mx.buenas.practicas.repository.PersonRepo;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepo personRepository;


    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person save(Person usuario) {
        return personRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
