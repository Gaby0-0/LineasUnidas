package LineasUnidas.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LineasUnidas.demo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Usuario findByCorreo(String correo);

   
    java.util.List<Usuario> findByRol(String rol);
}
