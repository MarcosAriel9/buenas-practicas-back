package utez.edu.mx.buenas.practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.buenas.practicas.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
