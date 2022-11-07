package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Não pode repetir o endereço, se não da conflito / exemplo @GetMapping("/batata") e @GetMapping("/batata")@GetMapping("/batata2")
@RestController // retornos de dados
public class CargoController {

    // Endpoint é o endereço que será acessado no backend
    @GetMapping("/oi") //com base em localhost:8080/oi retorna a String
    public String dizOla() {
        return "Retorna informacao"; // A resposta da requisição é o return
    }
//listar
    @GetMapping("/batata") //com base em localhost:8080/oi retorna a String
    public Integer valor() {
        return 1000;
    }

    // -------------------------------------------------------//
    //para requisitar dados armazenados
    /*@GetMapping("/cargos/1") //-> não é viavel
    public  Cargo getCargo(){
        return  this.cargoService.getCargo(1);
    }*/
    @Autowired
    private CargoService cargoService; // responsavel por ir no repository, pedir a lista de cargos

    @GetMapping("/cargos")
    public List<Cargo> listar() {
        //Cadeia de comando - Requisição -> Controller -> Service -> Repository -> SELECT * FROM cargo;
        return this.cargoService.listar(); // JSON = JAVASCRIPT OBJECT NOTATION
    }
/*
    @GetMapping("/cargos/1")
    public Cargo getCargo() {
        return this.cargoService.getCargo(1);
    }

    @GetMapping("/cargos/2")
    public Cargo getCargo() {
        return this.cargoService.getCargo(2);
        //Indica que o valor apos a barra é dinamico
    } */

    @GetMapping("/cargos/{idCargo}") //Indica que o valor apos a barra é dinamico
    public Cargo getCargo(@PathVariable Integer idCargo) {
       //@PathVariable => extrai do endpoint o valor dinâmico.
        // System.out.println(idCargo);
      //  return this.cargoService.getCargo(idCargo);
        return this.cargoService.getCargo(100);
    }
    //Podemos usar o mesmo endpoint para verbos diferentes
    @PostMapping("/cargos")
  //  public String salvar(@RequestBody Cargo cargo){ //Requisicao tipo post para /cargos
    //    Cargo salvo = this.cargoService.salvar(cargo);
    public Cargo salvar(@RequestBody CargoDTO cargo){
        Cargo atualizado = this.cargoService.salvar(cargo);
    return atualizado; // A resposta será o cargo inserido
        //  return "Batata"; // Agora nao da mais o erro 405 pois ja sabe para quem direcionar

    //@RequestBody - extrair o JSON do corpo e converte para cargo(deserializacao)
   // System.out.println(cargo.getNome());
   // System.out.println(cargo.getDescricao());
   // System.out.println(cargo.getSalario());
    }
    //Mapeia requisicoes do verbo PUT.
    @PutMapping("/cargos/{idCargo}") // /cargos/5
public Cargo atualizar(@PathVariable Integer idCargo, @RequestBody CargoDTO cargo){
      //  System.out.println(idCargo);
       // System.out.println(cargo.getSalario());
       // return null;
        Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
        return atualizado; // resposta para o cliente (cargo atualizado)
    }
    @DeleteMapping("/cargos/{idCargo}") //verbo delete no /cargos/1
    public void deletar(@PathVariable Integer idCargo){ //p deletar so precisa do Id
        this.cargoService.deletar(idCargo);

    }
}