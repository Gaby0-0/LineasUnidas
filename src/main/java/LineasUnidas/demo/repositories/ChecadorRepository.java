package LineasUnidas.demo.repositories;

import LineasUnidas.demo.model.Checador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecadorRepository extends JpaRepository<Checador, Integer> {
   
    Checador findByCorreo(String correo);
}
