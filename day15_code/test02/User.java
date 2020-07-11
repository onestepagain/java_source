package com.atguigu.test02;

@Table(value="t_user")
public class User {
	@Column(name="no",type="int")
	private int id;
	
	@Column(name="username",type="varchar(20)")
	private String username;
	
	@Column(name="pwd",type="char(6)")
	private String password;
	
	@Column(name="email",type="varchar(50")
	private String email;

	public User(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
