package utez.edu.mx.buenas.practicas.service;

import utez.edu.mx.buenas.practicas.model.Person;


import java.util.Optional;

public interface PersonService {
    public Iterable<Person> findAll();
    public Optional<Person> findById(Long id);
    public Person save(Person usuario);
    public void deleteById(Long id);
}
