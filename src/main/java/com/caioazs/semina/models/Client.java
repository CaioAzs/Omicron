package com.caioazs.semina.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
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
@Table(name = "tb_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cpf;

    private String name;
    private String email;
    private String phone;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt_BR", timezone = "America/Sao_Paulo", shape = JsonFormat.Shape.STRING)
    private LocalDate dateCreated;
    private BigDecimal service_value;

    @OneToMany(mappedBy = "client")
    private List<Service> services = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.dateCreated = LocalDate.now();
    }
}
