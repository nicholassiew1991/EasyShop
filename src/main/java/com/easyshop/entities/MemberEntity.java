package com.easyshop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "member", schema = "easyshop", catalog = "")
public class MemberEntity {
	private long id;
	private String username;
	private String email;
	private String password;

	@Id
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MemberEntity that = (MemberEntity) o;
		return id == that.id && Objects.equals(username, that.username) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, email, password);
	}
}
