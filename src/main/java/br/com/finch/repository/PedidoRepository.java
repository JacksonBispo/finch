package br.com.finch.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.finch.domain.Produto;
@Repository
public interface PedidoRepository extends JpaRepository<Produto, Integer> {

}
