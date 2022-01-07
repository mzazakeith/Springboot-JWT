package com.example.userservice;

import com.example.userservice.model.Role;
import com.example.userservice.model.User;
import com.example.userservice.service.RoleService;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService, RoleService roleService){
		return args -> {
			roleService.saveRole(new Role("ROLE_USER"));
			roleService.saveRole(new Role("ROLE_ADMIN"));
			roleService.saveRole(new Role("ROLE_MANAGER"));
			roleService.saveRole(new Role("ROLE_SUPER_ADMIN"));

			userService.saveUser(new User("Keith Mzaza", "Keith", "1234", new ArrayList<>()));
			userService.saveUser(new User("Maxine Wabosha", "Max", "1234", new ArrayList<>()));
			userService.saveUser(new User("Emmanuel Mwazighe", "Manu", "1234", new ArrayList<>()));
			userService.saveUser(new User("Elizabeth Nzisa", "Liz", "1234", new ArrayList<>()));

			roleService.addRoleToUser("Keith","ROLE_USER" );
			roleService.addRoleToUser("Keith","ROLE_MANAGER" );
			roleService.addRoleToUser("Max","ROLE_SUPER_ADMIN" );
			roleService.addRoleToUser("Max","ROLE_ADMIN" );
			roleService.addRoleToUser("Max","ROLE_USER" );
			roleService.addRoleToUser("Manu","ROLE_USER" );
			roleService.addRoleToUser("Liz","ROLE_MANAGER" );

		};
	}

}
