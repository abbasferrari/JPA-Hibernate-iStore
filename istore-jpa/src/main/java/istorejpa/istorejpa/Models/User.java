package istorejpa.istorejpa.Models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name = "user_r")
public class User implements Serializable{
	
	private static final long serialVersionUID = 243835615661622018L;

	@Column(columnDefinition = "SERIAL",insertable = false)
	private Long sno;

	@Id
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_id")
	private String id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_address")
	private String address;
	
	@Column(name = "user_password")
	/*@ColumnTransformer(
	        read = "decrypt( 'AES', '00', user_password  )",
	        write = "encrypt('AES', '00', ?)"
	    )*/
	private String password;
	
	@Column(name = "user_tag")
	private char tag = '0';
	
	@Column
	@CreationTimestamp
	private LocalDateTime timeStamp;
	
	@Column(name = "user_phoneno")
	private String phoneno;

	public User() {
		
	}
	
	public User(String email, String id, String name, String address, String password, String phoneno) {
		super();
		this.email = email;
		this.id = id;
		this.name = name;
		this.address = address;
		this.password = password;
		this.phoneno = phoneno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public Long getSno() {
		return sno;
	}


	public void setSno(Long sno) {
		this.sno = sno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}



	@Override
	public String toString() {
		return "User [sno=" + sno + ", email=" + email + ", id=" + id + ", name=" + name + ", address=" + address
				+ ", password=" + password + ", tag=" + tag + ", timeStamp=" + timeStamp + ", phoneno=" + phoneno + "]";
	}
}
