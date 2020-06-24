package com.matias.agnolin.portfolio.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public @Data class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(length = 60)
    private String password;
    @Column(unique = true, length = 60)
    private String username;

    @Column(name="is_enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_authorities"
            ,joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id")
            ,uniqueConstraints = {@UniqueConstraint(columnNames ={"user_id","role_id"})})
    private List<Role> roles;


}
