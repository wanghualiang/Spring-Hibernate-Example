package com.lenovo.leoss.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author zhaoxin
 */
@Entity
@Table(name = "SKEY")
public class Key {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@NotBlank
	@Column(name = "access_key")
	private String accessKey;

	@NotBlank
	@Column(name = "secret_key")
	private String secretKey;
	
	@NotBlank
	@Column(name = "user_id")
	private Long userId;
	
	@NotBlank
	@Column(name = "status")
	private Integer  status;
	
	@Past
    @Column(name = "ctime")
    private Date ctime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
