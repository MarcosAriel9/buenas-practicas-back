
package utez.edu.mx.buenas.practicas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.buenas.practicas.model.Rol;
import utez.edu.mx.buenas.practicas.service.RolService;

import java.util.Optional;

    @RestController
    @CrossOrigin(origins = {"*"})
    @RequestMapping("/rol")
    public class RolController {
        @Autowired
        RolService rolService;

        @GetMapping("/")
        public ResponseEntity<?> findAll(){
            return ResponseEntity.ok().body(rolService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable(value = "id")long id){
            if (rolService.findById(id).isPresent()) return ResponseEntity.status(HttpStatus.OK).body(rolService.findById(id));
            return ResponseEntity.badRequest().body("not found");
        }

        @PostMapping("/")
        public ResponseEntity<?> create (@RequestBody Rol rol){
            return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rol));
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> update (@RequestBody Rol rol, @PathVariable (value = "id") long id){
            if (!rolService.findById(id).isPresent()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found");
            }else{
                Optional<Rol> rolOptional = rolService.findById(id);

                rolOptional.get().setDescripcion(rol.getDescripcion());
                rolOptional.get().setUserList(rol.getUserList());


                return ResponseEntity.ok().body(rolService.save(rolOptional.get()));
            }

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete (@PathVariable(value = "id")long id){
            if (rolService.findById(id).isEmpty()) return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");

            rolService.deleteById(id);
            return ResponseEntity.ok().body("Deleted");
        }
    }

