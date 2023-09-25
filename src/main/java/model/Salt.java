package model;

import jakarta.persistence.*;

@Entity
@Table(name = "salt")
public class Salt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(nullable = false)
	private String salt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
