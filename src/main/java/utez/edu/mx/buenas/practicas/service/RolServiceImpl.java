package utez.edu.mx.buenas.practicas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.buenas.practicas.model.Rol;
import utez.edu.mx.buenas.practicas.repository.RolRepo;

import java.util.Optional;
@Service
public class RolServiceImpl implements RolService {
    @Autowired
    RolRepo rolRepository;

    @Override
    public Iterable<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
}
