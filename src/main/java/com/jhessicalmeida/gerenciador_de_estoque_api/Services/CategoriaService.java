package com.jhessicalmeida.gerenciador_de_estoque_api.Services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.jhessicalmeida.gerenciador_de_estoque_api.Entitys.Categoria;
import com.jhessicalmeida.gerenciador_de_estoque_api.Repositories.CategoriaRepository;


@Service
public class CategoriaService {
      private CategoriaRepository categoriarepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriarepository = categoriaRepository;
    }
    
    public List<Categoria> getAllCategorias(){
        return categoriarepository.findAll();
    }

    public List<Categoria> postCategorias(Categoria categoria){
        categoriarepository.save(categoria);
        return getAllCategorias();
    }
    
    public List<Categoria> updateCategorias(Categoria categoria){
        categoriarepository.save(categoria);
        return getAllCategorias();

    }
    public List<Categoria> deleteCategorias(Long id){
        categoriarepository.deleteById(id);
        return getAllCategorias();
    }
}
