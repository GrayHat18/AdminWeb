package dto;

import java.security.Timestamp;
import java.util.Objects;
import model.Rol;

public class UsuarioDto {

    private int idUsuario;
    private String username;
    private String passwordHash;
    private String email;
    private String salt;
    private Rol rol;
    private Timestamp lastLogin;
    private boolean estado;

    public UsuarioDto(Builder builder) {
        this.idUsuario = builder.idUsuario;
        this.username = builder.username;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
        this.salt = builder.salt;
        this.rol = builder.rol;
        this.estado = builder.estado;
        this.lastLogin = builder.lastLogin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public static class Builder {

        private int idUsuario;
        private String username;
        private String passwordHash;
        private String email;
        private String salt;
        private Rol rol;
        private Timestamp lastLogin;
        private boolean estado;

        public Builder idUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder passwordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        public Builder salt(String salt) {
            this.salt = salt;
            return this;
        }

        public Builder Rol(Rol rol) {
            this.rol = rol;
            return this;
        }

        public Builder estado(boolean estado) {
            this.estado = estado;
            return this;
        }

        public Builder lastLogin(Timestamp lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public UsuarioDto build() {
            return new UsuarioDto(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsuarioDto{");
        sb.append("idUsuario=").append(idUsuario);
        sb.append(", username=").append(username);
        sb.append(", passwordHash=").append(passwordHash);
        sb.append(", email=").append(email);
        sb.append(", salt=").append(salt);
        sb.append(", rol=").append(rol);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idUsuario;
        hash = 23 * hash + Objects.hashCode(this.username);
        hash = 23 * hash + Objects.hashCode(this.passwordHash);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.salt);
        hash = 23 * hash + Objects.hashCode(this.rol);
        hash = 23 * hash + Objects.hashCode(this.lastLogin);
        hash = 23 * hash + (this.estado ? 1 : 0);
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
        final UsuarioDto other = (UsuarioDto) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.passwordHash, other.passwordHash)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.salt, other.salt)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return Objects.equals(this.lastLogin, other.lastLogin);
    }

}
