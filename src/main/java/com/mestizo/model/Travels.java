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
@Table(name = "TRAVELS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "{createdAt,updatedAt}", allowGetters = true)
public class Travels implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int travelsId;

    @Column
    private String name;

    @OneToMany(mappedBy = "travels")
    private List<Reservations> reservations;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateAt;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    @LastModifiedBy
    private String updatedBy;

}
