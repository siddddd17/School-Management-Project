package service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import entity.User;
import enumm.UserRole;
import jakarta.annotation.PostConstruct;
import repository.UserRepository;



@Service
public class AdminServiceImpl{
	
	private final UserRepository userRepository;
	
	public AdminServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void createAdminAccount() {
		User adminAccount= userRepository.findByRole(UserRole.ADMIN);
		if(adminAccount==null) {
		User admin=new User();
		admin.setEmail("admin@gmail.com");
		admin.setName("admin");
		admin.setRole(UserRole.ADMIN);
		admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
		userRepository.save(admin);
		}
	}
	
}
