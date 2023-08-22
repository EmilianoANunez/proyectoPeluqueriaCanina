package todocode.peluqueriacanina.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import todocode.peluqueriacanina.logica.Cliente;
import todocode.peluqueriacanina.logica.Mascota;
import todocode.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    // Instancias de los controladores JPA de las clases cliente y mascota
    ClienteJpaController clienteJpa = new ClienteJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Cliente cliente, Mascota mascota) {
        
        // Crear en BD cliente y mascota
        clienteJpa.create(cliente);
        mascotaJpa.create(mascota);
        
    }

    public List<Mascota> traerMascota() {
        // Lo que encuentra se lo pasa a lógica
        return mascotaJpa.findMascotaEntities();
    }

    public void eliminarMascota(int IdMascota) {
        try {
            mascotaJpa.destroy(IdMascota);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clienteJpa.destroy(IdMascota);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int IdMascota) {
        return mascotaJpa.findMascota(IdMascota);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente buscarCliente(int idCliente) {
        return clienteJpa.findCliente(idCliente);
    }

    public void modificarCliente(Cliente cliente) {
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
