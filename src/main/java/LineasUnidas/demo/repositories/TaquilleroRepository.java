package LineasUnidas.demo.repositories;

import LineasUnidas.demo.model.Taquillero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaquilleroRepository extends JpaRepository<Taquillero, Integer> {
    
    Taquillero findByCorreo(String correo);

    Taquillero findByIdEmpleado(int idEmpleado);
}

