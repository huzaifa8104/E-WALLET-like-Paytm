package com.example.UserServiceApplication;

import com.example.UserServiceApplication.model.UserType;
import com.example.UserServiceApplication.model.Users;
import com.example.UserServiceApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Value("${service.Authority}")
	private String serviceAuthority;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Users existingServiceUser = userRepository.findByContact("txn-service");

		if (existingServiceUser == null) {
			Users users = Users.builder().contact("txn-service").
					password(passwordEncoder.encode("txn-service")).
					enabled(true).accountNonLocked(true).credentialsNonExpired(true).accountNonExpired(true).
					email("txnService@gmail.com").authorities(serviceAuthority).
					userType(UserType.SERVICE).
					build();
			userRepository.save(users);
			System.out.println("Service user 'txn-service' created successfully.");
		} else {
			System.out.println("Service user 'txn-service' already exists. Skipping creation.");
		}
	}
}
