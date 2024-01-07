package model;

import java.security.Timestamp;
import java.util.Objects;
import java.util.logging.Logger;

public class Usuario {

    private int idUsuario;
    private String username;
    private String email;
    private String passwordHash;
    private String salt;
    private Rol rol;
    private Timestamp createdAt;
    private Timestamp lastLogin;
    private boolean estado;
    private static final Logger LOG = Logger.getLogger(Usuario.class.getName());

    public Usuario(Builder builder) {
        this.idUsuario = builder.idUsuario;
        this.username = builder.username;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
        this.salt = builder.salt;
        this.rol = builder.rol;
        this.createdAt = builder.createdAt;
        this.estado = builder.estado;
        this.lastLogin = builder.lastLogin;
    }

    public static class Builder {

        private int idUsuario;
        private String username;
        private String email;
        private String passwordHash;
        private String salt;
        private Rol rol;
        private Timestamp createdAt;
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

        public Builder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
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

        public Usuario build() {
            return new Usuario(this);
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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

    public static Logger getLOG() {
        return LOG;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.idUsuario;
        hash = 11 * hash + Objects.hashCode(this.username);
        hash = 11 * hash + Objects.hashCode(this.email);
        hash = 11 * hash + Objects.hashCode(this.passwordHash);
        hash = 11 * hash + Objects.hashCode(this.salt);
        hash = 11 * hash + Objects.hashCode(this.rol);
        hash = 11 * hash + Objects.hashCode(this.createdAt);
        hash = 11 * hash + Objects.hashCode(this.lastLogin);
        hash = 11 * hash + (this.estado ? 1 : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.passwordHash, other.passwordHash)) {
            return false;
        }
        if (!Objects.equals(this.salt, other.salt)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return Objects.equals(this.lastLogin, other.lastLogin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("idUsuario=").append(idUsuario);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", passwordHash=").append(passwordHash);
        sb.append(", salt=").append(salt);
        sb.append(", rol=").append(rol);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

}
