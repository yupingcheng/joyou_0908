package joyou.Members.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberTest1")
public class MembersBean {
	private int id;
	private String account;
	private String password;

	public MembersBean() {

	}

	public MembersBean(String account, String password) {
		this.account = account;
		this.password = password;
	}

	public MembersBean(int id, String account, String password) {
		this.id = id;
		this.account = account;
		this.password = password;
	}

	@Id
	@Column(name = "memberID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "memberAcc")
	public String getAccount() {
		return account;
	}

	public void setAccount(String acount) {
		this.account = acount;
	}

	@Column(name = "memberPwd")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
