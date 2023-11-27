package org.group28projectjpa_21_11.databaseMigration.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.group28projectjpa_21_11.entyty.Role;
import org.group28projectjpa_21_11.repository.RoleRepository;


@Data
@AllArgsConstructor
public class DatabaseConfig {
    private final RoleRepository roleRepository;

           public void fillRoleTable(){
            Role admin = new Role();
            admin.setName("Admin");
            roleRepository.save(admin);

            Role user = new Role();
            user.setName("User");
            roleRepository.save(user);

        }

    }

