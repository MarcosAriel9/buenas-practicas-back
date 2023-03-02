package utez.edu.mx.buenas.practicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.buenas.practicas.model.User;
import utez.edu.mx.buenas.practicas.service.UserService;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    UserService usuarioService;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id")long id){
        if (usuarioService.findById(id).isPresent()) return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
        return ResponseEntity.badRequest().body("not found");
    }

    @PostMapping("/")
    public ResponseEntity<?> create (@RequestBody User usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody User usuario, @PathVariable (value = "id") long id){
        if (!usuarioService.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found");
        }else{
            Optional<User> usuarioOptional = usuarioService.findById(id);
            usuarioOptional.get().setRol(usuario.getRol());
            usuarioOptional.get().setContraseña(usuario.getContraseña());
            usuarioOptional.get().setNombreDeUsuario(usuario.getNombreDeUsuario());
            usuarioOptional.get().setCorreoElectronico(usuario.getCorreoElectronico());


            return ResponseEntity.ok().body(usuarioService.save(usuarioOptional.get()));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id")long id){
        if (usuarioService.findById(id).isEmpty()) return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");

        usuarioService.deleteById(id);
        return ResponseEntity.ok().body("Deleted");
    }
}
