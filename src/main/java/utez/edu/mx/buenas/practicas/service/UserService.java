package utez.edu.mx.buenas.practicas.service;

import utez.edu.mx.buenas.practicas.model.User;

import java.util.Optional;

public interface UserService {
    public Iterable<User> findAll();
    public Optional<User> findById(Long id);
    public User save(User usuario);
    public void deleteById(Long id);
}
