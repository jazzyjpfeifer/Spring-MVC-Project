package app.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "role")
    private String role;

    @Column(name= "roleDescription")
    private String roleDescription;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private List<User> usersRoles;
    */

    @CreationTimestamp
    @Column(name = "date_created", updatable = false, insertable = true)
    private Timestamp dateCreated;

    @UpdateTimestamp
    @Column(name = "date_last_modified", updatable = true, insertable = true)
    private Timestamp dateLastModified;

    public Role() {

    }

    public Role(String role, String roleDescription, List<User> usersRoles, Timestamp dateCreated, Timestamp dateLastModified) {
        this.role = role;
        this.roleDescription = roleDescription;
        this.dateCreated = dateCreated;
        this.dateLastModified = dateLastModified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(Timestamp dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateLastModified=" + dateLastModified +
                '}';
    }
}
