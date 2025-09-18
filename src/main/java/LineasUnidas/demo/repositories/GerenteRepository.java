package LineasUnidas.demo.repositories;

import LineasUnidas.demo.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer> {
    
    Gerente findByCorreo(String correo);
}

