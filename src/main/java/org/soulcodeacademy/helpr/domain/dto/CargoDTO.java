package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//DTO - Objeto de tranferencia de dados
//E util para validarmos as informacoes transferidas pelo cliente
public class CargoDTO {
    //@NotBlank impede que o valor de nome seja "", por exemplo.
    @NotBlank(message = "Campo nome obrigatório!" ) //Texto da validação
    private String nome;
    @NotBlank (message = "Campo descricao é obrigatorio.") //@NotBlank só serve para String
    private String descricao;
    @NotNull(message = "Campo salário é obrigatório") //impede que o valor seja null, mas nao impede que coloque valores errados
    @Min(value = 500, message = "Campo salário inválido. ")
    @Max(value = 100000, message = "Campo salário inválido!" )
    private Double salario;

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
