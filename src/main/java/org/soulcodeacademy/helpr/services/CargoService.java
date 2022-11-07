package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    // Listar todos
    public List<Cargo> listar() {
        // Retorna os dados da tabela em forma de lista
        // SELECT * FROM cargo;
        return this.cargoRepository.findAll();
    }

    // Listar um pelo ID
    public Cargo getCargo(Integer idCargo) {
        // SELECT * FROM cargo WHERE idCargo = ?
        // Optional = Pode haver cargo ou não
        Optional<Cargo> cargo = this.cargoRepository.findById(idCargo);

        if(cargo.isEmpty()) { // Não encontrou o cargo?
            // Não encontrou o cargo com id solicitado
            throw new RuntimeException("O cargo não foi encontrado!"); // Causa um erro com a mensagem
        } else {
            return cargo.get(); // Extrair o cargo de dentro do optional
        }
    }
    //Salvar
    public Cargo salvar(CargoDTO dto){
     //   novoCargo.setIdCargo(null); //Limpar o campo id para nao substituir
        //INSERT INTO cargo
        Cargo cargo = new Cargo(null, dto.getNome(), dto.getDescricao(), dto.getSalario());
        Cargo cargoSalvo = this.cargoRepository.save(cargo);
        return cargoSalvo;
    }
    //Atualizar
    // Precisa do ID do cargo e dos dados atualizados
public Cargo atualizar (Integer idCargo, CargoDTO dto){
        //Verificar se o cargo existe mesmo.
    Cargo cargoAtual = this.getCargo(idCargo);

    cargoAtual.setNome(dto.getNome());
    cargoAtual.setDescricao(dto.getDescricao());
    cargoAtual.setSalario(dto.getSalario());

    Cargo atualizado = this.cargoRepository.save(cargoAtual); //metodo save serve tanto p atualizar como para salvar.
    return atualizado; // return para o cliente/postman
    }
    //Deletar
    // Atualizar
    // Deletar
    public void deletar(Integer idCargo){
      Cargo cargo = this.getCargo(idCargo);
      // DELETE FROM cargo WHERE idCargo =?
      this.cargoRepository.delete(cargo);
    }
}