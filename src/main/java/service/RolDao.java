package service;

import java.util.List;
import model.Rol;

public interface RolDao {

    int createRole(Rol role);

    List<Rol> readAllRoles();

    int readRoleById(int id);

    int updateRole(Rol role);

    int deleteRole(int id);

}
