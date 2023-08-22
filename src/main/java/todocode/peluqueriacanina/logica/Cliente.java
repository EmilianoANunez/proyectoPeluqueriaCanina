package todocode.peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {
    
    // Crear atributos del Cliente
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCliente;
    @Basic
    private String nombreCliente;
    private String numeroCliente;
    
    // Constructores

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String numeroCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.numeroCliente = numeroCliente;
    }
    
    // Métodos

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
    
}
