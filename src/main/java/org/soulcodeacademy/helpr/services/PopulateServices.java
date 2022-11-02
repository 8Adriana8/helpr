package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//Torna o objeto de PopulateService disponivel para toda a aplicacao (global).
@Service // indica para o Spring que esta classe será gerenciada por ele.
public class PopulateServices {
   @Autowired // Injetar o objeto direto na classe
    private CargoRepository cargoRepository;
    public void populate() {
        //Integer idCargo, String descricao, Double salario
        Cargo c1 = new Cargo( null, "Director Geral", "Gerencia a empresa", 30000.00);
        Cargo c2 = new Cargo( null, "Director de setor", "Gerencia setor da empresa", 18000.00);
        Cargo c3 = new Cargo( null, "Técnico Geral", "Resolve chamados", 12000.00);
        //Vamos persistir as entidades = salvar no banco
        this.cargoRepository.save(c1); //insert into
        this.cargoRepository.save(c2); //isso garante salvar no banco
        this.cargoRepository.save(c3);

    }
}
// O objetivo desta classe é inserir no banco, dados ficticios (de teste).
//IOC= Inversion of control = Inversão de controle.
//Container = é o local de onde o Spring guarda os objetos anotados.
//@Indica que a classe é um serviço da aplicacao.
//Injeção de dependencias = quando o Spring injeta os objetos na classe