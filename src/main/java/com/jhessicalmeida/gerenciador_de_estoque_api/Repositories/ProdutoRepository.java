package com.jhessicalmeida.gerenciador_de_estoque_api.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jhessicalmeida.gerenciador_de_estoque_api.Entitys.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}

