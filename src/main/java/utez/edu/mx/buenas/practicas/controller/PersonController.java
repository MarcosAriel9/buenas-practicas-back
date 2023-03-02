package utez.edu.mx.buenas.practicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.buenas.practicas.model.Person;
import utez.edu.mx.buenas.practicas.service.PersonService;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/persona")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id")long id){
        if (personService.findById(id).isPresent()) return ResponseEntity.status(HttpStatus.OK).body(personService.findById(id));
        return ResponseEntity.badRequest().body("not found");
    }

    @PostMapping("/")
    public ResponseEntity<?> create (@RequestBody Person usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody  Person usuario, @PathVariable (value = "id") long id){
        if (!personService.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found");
        }else{
            Optional< Person>  personOptional = personService.findById(id);
            personOptional.get().setNombre(usuario.getNombre());
            personOptional.get().setApellidoPat(usuario.getApellidoPat());
            personOptional.get().setApellidoMat(usuario.getApellidoMat());
            personOptional.get().setNumeroDeTelefono(usuario.getNumeroDeTelefono());
            personOptional.get().setFechaNac(usuario.getFechaNac());

            return ResponseEntity.ok().body(personService.save(personOptional.get()));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id")long id){
        if (personService.findById(id).isEmpty()) return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");

        personService.deleteById(id);
        return ResponseEntity.ok().body("Deleted");
    }
}
