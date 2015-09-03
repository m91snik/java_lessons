package com.m91snik.lesson15.rest.entity;

import com.m91snik.lesson15.rest.entity.converter.DateTimeConverter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "USER", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class UserEntity implements Serializable {

    public UserEntity() {
        this.id = UUID.randomUUID().toString().replace("-", "");
    }

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "NAME",nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    @NotEmpty
    private String password;

    @Column(name = "CREATION_TIME", nullable = false)
    @Convert(converter = DateTimeConverter.class)
    private Date creationTime;

    @Column(name = "USER_TYPE")
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
