package LineasUnidas.demo.services;

import LineasUnidas.demo.model.Usuario;
import LineasUnidas.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;


    public UsuarioService(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Optional<Usuario> usuario = usuarioRepo.findById(id);
        return usuario.orElse(null);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario actualizarUsuario(int id, Usuario detalles) {
        Optional<Usuario> optUsuario = usuarioRepo.findById(id);
        if (optUsuario.isPresent()) {
            Usuario usuario = optUsuario.get();
            usuario.setNombre(detalles.getNombre());
            usuario.setApellidoP(detalles.getApellidoP());
            usuario.setApellidoM(detalles.getApellidoM());
            usuario.setTelefono(detalles.getTelefono());
            usuario.setCorreo(detalles.getCorreo());
            usuario.setRol(detalles.getRol());
            return usuarioRepo.save(usuario);
        }
        return null;
    }

    public boolean eliminarUsuario(int id) {
        if (usuarioRepo.existsById(id)) {
            usuarioRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Usuario buscarPorCorreo(String correo) {
        return usuarioRepo.findByCorreo(correo);
    }

    public List<Usuario> buscarPorRol(String rol) {
        return usuarioRepo.findByRol(rol);
    }
}

