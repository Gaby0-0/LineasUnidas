package LineasUnidas.demo.repositories;

import LineasUnidas.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Usuario findByCorreo(String correo);

   
    java.util.List<Usuario> findByRol(String rol);
}
