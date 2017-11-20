package app.service;

import app.entity.Role;

import java.util.List;

public interface RoleService {

    public List<Role> getRoles();

    public void saveRole (Role newRole);

    public Role getRoleById(int id);

    public void deleteRoleById(int theId);
}
