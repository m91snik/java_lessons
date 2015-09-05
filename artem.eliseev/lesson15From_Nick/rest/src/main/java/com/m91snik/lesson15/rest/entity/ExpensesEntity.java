package com.m91snik.lesson15.rest.entity;

import com.m91snik.lesson15.rest.entity.converter.DateTimeConverter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by m91snik on 09.08.15.
 */
@Entity
@Table(name = "EXPENSES", uniqueConstraints = {@UniqueConstraint(columnNames = {"Id"})})
public class ExpensesEntity {

    public ExpensesEntity() {
        this.id = UUID.randomUUID().toString().replace("-", "");
    }

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "CURRENCY", nullable = false)
    @NotEmpty
    private String currency;

    @Column(name = "DESCRIPTION")
    @NotEmpty
    private String description;

    @Column(name = "CREATION_TIME", nullable = false)
    @Convert(converter = DateTimeConverter.class)
    private Date creationTime;

    @Column(name = "OWNER_ID", nullable = false)
    @NotEmpty
    private String ownerId;

    @Column(name = "COMMENT")
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
