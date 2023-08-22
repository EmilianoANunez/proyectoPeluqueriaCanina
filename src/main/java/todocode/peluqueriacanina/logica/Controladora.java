package todocode.peluqueriacanina.logica;


import java.util.List;
import todocode.peluqueriacanina.persistencia.ControladoraPersistencia;

public class Controladora {
    
    // Instrancia de persistencia
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color,String observaciones, String alergico, String atenEsp,String nombreCliente, String celCliente) {
        
        // Creamos el cliente y asignamos sus valores
        Cliente cliente = new Cliente();
        cliente.setNombreCliente(nombreCliente);
        cliente.setNumeroCliente(celCliente);
        
        // Creamos la mascota y asignamos sus valores
        Mascota mascota = new Mascota();
        mascota.setNombreMascota(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergias(alergico);
        mascota.setAtencionEspecial(atenEsp);
        mascota.setObservaciones(observaciones);
        mascota.setCliente(cliente);
        
        controlPersistencia.guardar(cliente, mascota);
        
    }

    public List<Mascota> traerMascotas() {
        // Llamar a persistencia
        return controlPersistencia.traerMascota();
        
    }

    public void borrarMascota(int IdMascota) {
        controlPersistencia.eliminarMascota(IdMascota);
    }

    public Mascota traerMascota(int IdMascota) {
        return controlPersistencia.traerMascota(IdMascota);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza,
            String color, String observaciones, String alergico, String atenEsp,
            String nombreCliente, String celCliente) {
        
        // Asigno datos a mascota
        masco.setAlergias(alergico);
        masco.setAtencionEspecial(atenEsp);
        masco.setColor(color);
        masco.setNombreMascota(nombreMasco);
        masco.setObservaciones(observaciones);
        masco.setRaza(raza);
        
        // Modifico Mascota
        controlPersistencia.modificarMascota(masco);
        
        //Crear método para buscar clientes
        Cliente cliente = this.buscarCliente(masco.getCliente().getIdCliente());
        cliente.setNombreCliente(nombreCliente);
        cliente.setNumeroCliente(celCliente);
        
        // Llamar a modificar cliente
        this.modificarCliente(cliente);
        
    }

    private Cliente buscarCliente(int idCliente) {
        return controlPersistencia.buscarCliente(idCliente);
    }

    private void modificarCliente(Cliente cliente) {
        controlPersistencia.modificarCliente(cliente);
    }
}
