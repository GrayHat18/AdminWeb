package service;

import java.util.List;
import model.Usuario;

public interface UsuarioDao {

    int createUser(Usuario user);

    List<Usuario> readAllUsers();

    int readUserById(int id);

    int updateUser(Usuario user);

    int deleteUser(int id);
}
