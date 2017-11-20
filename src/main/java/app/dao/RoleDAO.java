package app.dao;

import app.entity.Role;

import java.util.List;


public interface RoleDAO {

    public List<Role> getRoles();

    public void saveRole (Role newRole);

    public Role getRoleById(int id);

    public void deleteRoleById(int id);
}
