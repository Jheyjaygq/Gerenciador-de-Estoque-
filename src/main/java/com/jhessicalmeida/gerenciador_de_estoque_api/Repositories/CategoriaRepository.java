package com.jhessicalmeida.gerenciador_de_estoque_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhessicalmeida.gerenciador_de_estoque_api.Entitys.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{

}
