package com.lenovo.leoss.model;

import com.lenovo.leoss.utils.ConfigProps;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by zhangyl27 on 2014/10/9.
 */
@Entity
@Table(name = "USER")
//@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Pattern(regexp = "\\S{6,30}")
    private String password;

    @NotBlank
    @Pattern(regexp = "\\S{2,50}")
    @Column(name = "contact_name")
    private String contactName;

    @NotBlank
    @Email
    private String email;

    private String phone;

    @Column(name = "company_type")
    private String companyType;

    @NotBlank
    @Pattern(regexp = "\\S{4,100}")
    @Column(name = "company_name")
    private String companyName;

    @URL
    @Column(name = "company_site")
    private String companySite;

    @Column(name = "space_limit")
    private String spaceLimit;

    @Column(name = "space_used")
    private String spaceUsed;

    @Column(name = "flux_limit")
    private String fluxLimit;

    @Column(name = "flux_used")
    private String fluxUsed;

    @Past
    @Column(name = "ctime")
    private Date ctime;

    @Past
    private Date atime;

    private String acode;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanySite() {
		return companySite;
	}

	public void setCompanySite(String companySite) {
		this.companySite = companySite;
	}

	public String getSpaceLimit() {
		return spaceLimit;
	}

	public void setSpaceLimit(String spaceLimit) {
		this.spaceLimit = spaceLimit;
	}

	public String getSpaceUsed() {
		return spaceUsed;
	}

	public void setSpaceUsed(String spaceUsed) {
		this.spaceUsed = spaceUsed;
	}

	public String getFluxLimit() {
		return fluxLimit;
	}

	public void setFluxLimit(String fluxLimit) {
		this.fluxLimit = fluxLimit;
	}

	public String getFluxUsed() {
		return fluxUsed;
	}

	public void setFluxUsed(String fluxUsed) {
		this.fluxUsed = fluxUsed;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

    public Date getAtime() {
        return atime;
    }

    public void setAtime(Date atime) {
        this.atime = atime;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }
}
