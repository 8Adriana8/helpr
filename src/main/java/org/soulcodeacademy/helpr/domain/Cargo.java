package org.soulcodeacademy.helpr.domain;

import javax.persistence.*; //JPA= JAVA PERSISTENCE API

//Transforma a nossa classe com o molde abaixo em uma entidade/tabela no banco
@Entity
public class Cargo { //nome da tabela = cargo. Entao avisa agora que precisa de uma chave primaria.
    @Id //usa o atributo abaixo como chave primaria PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Integer idCargo; //será a chave primaria da tabela
    @Column(nullable = false, length = 50) //NOT NULL, e max de 50 caracteres
    private String nome;
    @Column(nullable = false, length = 120) // NOT NULL, e 120 caracteres
    private String descricao;
    @Column(nullable = false) //@column serve para customizar a coluna
    private Double salario;

    public Cargo() {} // a ORM irá usar este construtor em conjunto dos getters e setters. Tem q ter um construtor vazio

    public Cargo(Integer idCargo, String nome, String descricao, Double salario) { // criamos este outro construtor so para fazer com que possamos usa-lo rapidamente, criar manualmente os cargos
        this.idCargo = idCargo;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
