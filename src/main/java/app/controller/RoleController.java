package app.controller;

import app.entity.Role;
import app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MapsId;
import java.util.List;

@Controller
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public String roles(Model model) {

        List<Role> roles = roleService.getRoles();

        model.addAttribute("roles", roles);

        return "roles/roles.html";
    }


    @GetMapping(value = "/add")
    public String showAddRoleForm(Model model) {
        Role newRole = new Role();

        model.addAttribute("role", newRole);

        return "/roles/role_add.html";

    }

    @PostMapping(value = "/save")
    public String saveRole(@ModelAttribute("role") Role role) {

        System.out.println("Inserting new record...");

        // save the customer using our service
        roleService.saveRole(role);

        System.out.println("New User was saved successfully!");

        return "redirect:/roles.html";
    }

    @GetMapping(value = "/edit/{id}")
    public String editRoleById(Model model, @PathVariable int id) {

        model.addAttribute("role", roleService.getRoleById(id));

        return "/roles/role_add.html";
    }

    @GetMapping(value = "/update")
    public String showRoleFormForUpdate(@RequestParam("roleId") int id, Model model) {

        Role role = roleService.getRoleById(id);

        model.addAttribute("role", role);

        return "roles/role_add.html";
    }


    @GetMapping(value = "/delete")
    public String deleteRoleById(@RequestParam("roleId") int theId) {

        System.out.println("Deleting record...");

        roleService.deleteRoleById(theId);

        System.out.println("Record was removed successfully form the database");

        return "redirect:/roles.html";
    }

}
