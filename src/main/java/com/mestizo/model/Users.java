package com.mestizo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="USERS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "{createdAt,updatedAt}", allowGetters = true)
public class Users implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usersId;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private int age;

    @OneToMany(mappedBy = "users")
    private List<Reservations> reservations;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Column(nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(nullable = false)
    @LastModifiedBy
    private String updatedBy;

}
