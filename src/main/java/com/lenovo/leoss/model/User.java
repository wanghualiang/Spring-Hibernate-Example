package com.lenovo.leoss.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhangyl27 on 2014/10/9.
 */
@Entity
@Table(name = "admin_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;

    private String email;

    @Column(name = "created_at")
    private Date createdAt;

    public String getName() {
        return name;
    }
    
    public String getPassword() {
    	return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
