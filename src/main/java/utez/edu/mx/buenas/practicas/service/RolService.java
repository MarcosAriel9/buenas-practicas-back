package utez.edu.mx.buenas.practicas.service;

import utez.edu.mx.buenas.practicas.model.Rol;

import java.util.Optional;

public interface RolService {

    public Iterable<Rol> findAll();
    public Optional<Rol> findById(Long id);
    public Rol save(Rol rol);
    public void deleteById(Long id);
}

