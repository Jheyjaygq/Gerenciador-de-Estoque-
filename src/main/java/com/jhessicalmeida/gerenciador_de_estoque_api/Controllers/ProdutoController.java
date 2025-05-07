package com.jhessicalmeida.gerenciador_de_estoque_api.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhessicalmeida.gerenciador_de_estoque_api.Entitys.Produto;
import com.jhessicalmeida.gerenciador_de_estoque_api.Services.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {
      private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    List<Produto> getProdutos(){
        return produtoService.getAllProdutos();
    }
    
    @PostMapping
    List<Produto> postProdutos(@RequestBody Produto produto){
      return produtoService.postProdutos(produto);
    }   
    @DeleteMapping("{id}")
    List<Produto> deleteProdutos(@PathVariable Long id){
        produtoService.deleteProdutos(id);
        return getProdutos();

    }
    @PutMapping("{id}")
    public List<Produto> putProduto(@PathVariable Long id, @RequestBody Produto produto) {
    Produto produtoExistente = produtoService.buscarPorId(id);

    produtoExistente.setNome(produto.getNome());
    produtoExistente.setPreco(produto.getPreco());
    produtoExistente.setQuantidade(produto.getQuantidade());
    produtoExistente.setImagem(produto.getImagem());
    produtoExistente.setCategoria(produto.getCategoria());

    produtoService.putProduto(produtoExistente);

    return produtoService.getAllProdutos();
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getPorId(@PathVariable Long id) {
    Produto produto = produtoService.buscarPorId(id);
    return ResponseEntity.ok(produto);
    }
    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> buscarPorNome(@RequestParam String nome) {
    return ResponseEntity.ok(produtoService.buscarPorNome(nome));
    }


    }   
