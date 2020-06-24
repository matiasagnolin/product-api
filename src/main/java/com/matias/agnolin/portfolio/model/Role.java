package com.matias.agnolin.portfolio.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public @Data class Role implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

}
