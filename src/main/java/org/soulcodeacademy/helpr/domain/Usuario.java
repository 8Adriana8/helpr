package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.*;

@Entity //Sempre tem q ter isso - essa classe vai ser uma entidade do banco de dados //Uma entidade precisa ter um construtor vazio e um id.
@Table(name = "usuarios") //coloca um nome especifico na tabela
public abstract class Usuario { //Nao sera possivel criar objetos desta classe
    @Id // diz que o campo q eu estou colocando é uma primary key. torna o campo abaixo uma primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //preenche o campo id com AUTO_INCREMENT.
    protected Integer id; //estou usando para a heranca, entao vc consegue acessar nas subclasses. Na classe funcionario eu vou usar isso.

    @Column(nullable = false, length = 150) //nao obrigatorio, mas se eu nao colocar isso ela vai ser criada de maneira basica, padronizada.
    protected String nome;

    @Column(nullable = false, unique = true, length = 120)
    protected String email;

    @Column(nullable = false, unique = true, length = 11)
    protected String cpf;

    @Column(nullable = false)
    protected String senha;

    //Representa os valores do ENUM como texto
    @Enumerated(EnumType.STRING)
    protected Perfil perfil; //Indica o que este usuario é no sistema.

    //construtor vazio:
    public Usuario(Integer id, String nome, String email, String cpf, String senha, Perfil perfil){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


}
