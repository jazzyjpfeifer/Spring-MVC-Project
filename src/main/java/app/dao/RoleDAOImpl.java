package app.dao;

import app.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> getRoles() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Role> query = currentSession.createQuery("from Role", Role.class);

        List<Role> roles = query.getResultList();

        return roles;
    }

    @Override
    public void saveRole(Role newRole) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(newRole);
    }

    @Override
    public Role getRoleById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Role role = currentSession.get(Role.class, id);

        return role;
    }

    @Override
    public void deleteRoleById(int theId) {
        Session currentSesscion = sessionFactory.getCurrentSession();

        Query query = currentSesscion.createQuery("delete from Role where id=:roleId");
        query.setParameter("roleId", theId);
        query.executeUpdate();


    }

}
