package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//Guarda as validacoes em comum para cliente e funcionario
//No controller: JSON -> DTO
public abstract class UsuarioDTO {
    @NotBlank(message = "Nome é obrigatório!")
            protected String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatorio")
    protected String email;

    @NotBlank(message = "CPF é obrigatório")
    protected String cpf;

    @NotBlank(message = "Senha é obrigatória")
    protected String senha;

    public String getNome(){
        return nome;
    }


}
