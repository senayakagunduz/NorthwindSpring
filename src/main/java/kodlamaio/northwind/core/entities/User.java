package kodlamaio.northwind.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Email
	@NotBlank // " " iki tırnak arası boşluğu istemiyoruz
	@NotNull // hiç bişey yazmadan boş bırakılmasını istemiyoruz. 
	@Column(name="email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name="password")
	private String password;
}