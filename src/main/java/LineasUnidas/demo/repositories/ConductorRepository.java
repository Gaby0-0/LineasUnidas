package LineasUnidas.demo.repositories;

import LineasUnidas.demo.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Integer> {
  
    Conductor findByCorreo(String correo);

   
    java.util.List<Conductor> findByPermiso(String permiso);
}

