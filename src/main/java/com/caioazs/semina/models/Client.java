package com.caioazs.semina.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String CPF;
    private String email;
    private String phone;
    private LocalDate dateCreated;
    private BigDecimal service_value;

    @OneToMany(mappedBy =  "client")
    private List<Service> services = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.dateCreated = LocalDate.now();
    }
}
