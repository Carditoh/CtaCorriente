package controllers;
 
import models.Usuario;
import models.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Usuario loginRequest) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(loginRequest.getNombreUsuario());

        if (usuario != null && usuario.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }
}