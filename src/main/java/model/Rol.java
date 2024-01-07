package model;

import java.security.Timestamp;
import java.util.Objects;
import java.util.logging.Logger;

public class Rol {

    private int idRol;
    private String nombre;
    private String descripcion;
    private Timestamp createdAt;
    private boolean estado;
    private static final Logger LOG = Logger.getLogger(Rol.class.getName());

    public Rol(Builder builder) {
        this.idRol = builder.idRol;
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.createdAt = builder.createdAt;
        this.estado = builder.estado;
    }

    public static class Builder {

        private int idRol;
        private String nombre;
        private String descripcion;
        private Timestamp createdAt;
        private boolean estado;

        public Builder idRol(int idRol) {
            this.idRol = idRol;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder description(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder estado(boolean estado) {
            this.estado = estado;
            return this;
        }

        public Rol build() {
            return new Rol(this);
        }
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public static Logger getLOG() {
        return LOG;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idRol;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.descripcion);
        hash = 79 * hash + Objects.hashCode(this.createdAt);
        hash = 79 * hash + (this.estado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rol other = (Rol) obj;
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.createdAt, other.createdAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rol{");
        sb.append("idRol=").append(idRol);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

}
