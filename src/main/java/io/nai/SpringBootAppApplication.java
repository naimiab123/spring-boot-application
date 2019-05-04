package io.nai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.nai.dao.AppRoleRepository;
import io.nai.dao.AppUserRepository;
import io.nai.dao.ProductRepository;
import io.nai.entities.AppRole;
import io.nai.entities.AppUser;
import io.nai.entities.Product;

@SpringBootApplication
public class SpringBootAppApplication implements CommandLineRunner {
	@Autowired
   private ProductRepository productRepository;
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private AppRoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//List<Product>	products = new ArrayList<Product>();
		Product p1 = new Product("TV AS1", 2, 1045.99);
		Product p2 =  new Product("SMART-PHONE", 15, 2035.99);
		Product p3 =new Product("MONITOR-SAMSUNG", 45, 1085.99);
		Product p4 =new Product("MONITOR-NOKIA", 11, 7085.99);
		Product p5 =new Product("CLOCK-DSV", 10, 185.99);
		Stream.of(p1, p2, p3, p4,p5).forEach(p -> {
			
			productRepository.save(p);
		});
		
		AppRole roleUser = new AppRole("ROLE_USER");
		AppRole roleAdmin = new AppRole("ROLE_ADMIN");
		Stream.of(roleUser,roleAdmin).forEach(t ->{
			roleRepository.save(t);
		});
		
		AppUser user =new AppUser("user","1234", true);
		AppUser admin =new AppUser("admin","1234", true);
		
		user.setRoles(Arrays.asList(roleUser));
		admin.setRoles(Arrays.asList(roleUser, roleAdmin ));
		
		Stream.of(user,admin).forEach(t ->{
			userRepository.save(t);
		});
	}

}
