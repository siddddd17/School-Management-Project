package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.User;
import enumm.UserRole;

 @Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByRole(UserRole admin);

}
