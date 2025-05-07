package com.jhessicalmeida.gerenciador_de_estoque_api.Controllers;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhessicalmeida.gerenciador_de_estoque_api.Entitys.Categoria;
import com.jhessicalmeida.gerenciador_de_estoque_api.Services.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
  private CategoriaService categoriaService;


    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public List<Categoria> getCategorias(){
        return categoriaService.getAllCategorias();
    }
    @PostMapping 
     List<Categoria> postCategorias(@RequestBody Categoria categoria){
      return categoriaService.postCategorias(categoria);
    }   

    @DeleteMapping("{id}")
    public List<Categoria> deleteCategorias(@PathVariable Long id){
        return categoriaService.deleteCategorias(id);
        
    }
    @PutMapping
    public List<Categoria> putCategorias(@RequestBody Categoria categoria){
        return categoriaService.updateCategorias(categoria);

    }
}
