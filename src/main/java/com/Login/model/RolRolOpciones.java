package com.Login.model;

import java.io.Serializable;

import jakarta.persistence.*;

/**
 * Clase que representa la relación entre roles y opciones de rol en la aplicación.
 */
@Entity
@Table(name = "RolRolOpciones")
@IdClass(RolRolOpciones.RolRolOpcionesId.class)
public class RolRolOpciones {

    @Id
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    @Id
    @ManyToOne
    @JoinColumn(name = "idOpcion")
    private RolOpciones rolOpciones;

    /**
     * Clase que representa la clave compuesta (ID) de la entidad `RolRolOpciones`.
     */
    public static class RolRolOpcionesId implements Serializable {

        private int rol; // idRol
        private int rolOpciones; // idOpcion
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

    /**
     * Obtiene la opción de rol asociada a esta relación.
     *
     * @return La opción de rol asociada.
     */
    public RolOpciones getRolOpciones() {
        return rolOpciones;
    }

    /**
     * Establece la opción de rol asociada a esta relación.
     *
     * @param rolOpciones La nueva opción de rol asociada.
     */
    public void setRolOpciones(RolOpciones rolOpciones) {
        this.rolOpciones = rolOpciones;
    }
}
