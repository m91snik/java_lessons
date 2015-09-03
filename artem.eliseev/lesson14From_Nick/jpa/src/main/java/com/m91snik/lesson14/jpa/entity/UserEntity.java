package com.m91snik.lesson14.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by m91snik on 30.08.15.
 */
@Entity
@Table(name = "USER")
public class UserEntity  implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String password;
    @Column(name = "CREATION_TIME")
    private Timestamp creationTime;

    public UserEntity() {
        id = UUID.randomUUID().toString().replace("-", "");
    }

    public String getId() {
        return id;
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

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
