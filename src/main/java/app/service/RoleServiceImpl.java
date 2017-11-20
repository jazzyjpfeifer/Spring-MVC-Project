package app.service;

import app.dao.RoleDAO;
import app.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }

    @Override
    @Transactional
    public void saveRole(Role newRole) {
        roleDAO.saveRole(newRole);
    }

    @Override
    @Transactional
    public Role getRoleById (int id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    @Transactional
    public void deleteRoleById(int theId) {
        roleDAO.deleteRoleById(theId);
    }


}
