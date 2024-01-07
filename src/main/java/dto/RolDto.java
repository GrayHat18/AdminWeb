package dto;

import java.util.Objects;

public class RolDto {

    private int idRol;
    private String nombre;
    private boolean estado;

    public RolDto(Builder builder) {
        this.idRol = builder.idRol;
        this.nombre = builder.nombre;
        this.estado = builder.estado;
    }

    public static class Builder {

        private int idRol;
        private String nombre;
        private boolean estado;

        public Builder idRol(int idRol) {
            this.idRol = idRol;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder estado(boolean estado) {
            this.estado = estado;
            return this;
        }

        public RolDto build() {
            return new RolDto(this);
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idRol;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + (this.estado ? 1 : 0);
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
        final RolDto other = (RolDto) obj;
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RolDto{");
        sb.append("idRol=").append(idRol);
        sb.append(", nombre=").append(nombre);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

}
