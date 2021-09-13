package kodlamaio.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{ //ilk parametre yani T=typeımız User, ID nin veri tipi olacak yani Integer olcak.
	User findByEmail(String email); //Kullanıcıya mailinde ulaşmaya çalışcaz
}
