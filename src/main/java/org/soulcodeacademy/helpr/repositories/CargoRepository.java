package org.soulcodeacademy.helpr.repositories;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.soulcodeacademy.helpr.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository; //nela tem os métodos para fazer a atualizacao, edicao...
import org.springframework.stereotype.Repository;


@Repository // Indica que a interface é um repository.
public interface CargoRepository extends JpaRepository<Cargo, Integer> { //<Entidade, PK>
}

// Repository é um recurso que permite manipular a entidade no banco de dados.
//Pode adicionar entidades, atualizar entidades, remover entidades e listar (CRUD). Nao precisamos criar um código, ele ja faz isso por nós.
//Indicar qual a entidade vai ser gerenciada pelo repository e qual o tipo da chave primária.
//Obs: O Spring gera uma classe dinâmica com base em nossa interface CargoRepository.
//CrudRepository = Contém as operações básicas de um banco de dados
// JpaRepository = possui mais funcionalidades p/ tratar a entidade