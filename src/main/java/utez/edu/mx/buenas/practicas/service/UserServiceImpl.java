package utez.edu.mx.buenas.practicas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.buenas.practicas.model.User;
import utez.edu.mx.buenas.practicas.repository.UserRepo;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo usuarioRepository;


    @Override
    public Iterable<User> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public User save(User usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
