package com.Login.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import jakarta.persistence.*;


/**
 * Clase que representa la relación entre roles y usuarios en la aplicación.
 */
@Entity
@Table(name = "RolUsuarios")
@IdClass(RolUsuarios.RolUsuarioId.class)
public class RolUsuarios {

    @Id
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    /**
     * Clase que representa la clave compuesta (ID) de la entidad `RolUsuarios`.
     */
    @Embeddable
    public static class RolUsuarioId implements Serializable {

        private int usuario; // idUsuario
        private int rol;     // idRol
    }

    /**
     * Obtiene el usuario asociado a esta relación.
     *
     * @return El usuario asociado.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a esta relación.
     *
     * @param usuario El nuevo usuario asociado.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el rol asociado a esta relación.
     *
     * @return El rol asociado.
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol asociado a esta relación.
     *
     * @param rol El nuevo rol asociado.
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
