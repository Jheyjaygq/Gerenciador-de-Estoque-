package com.jhessicalmeida.gerenciador_de_estoque_api.Services;


import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.jhessicalmeida.gerenciador_de_estoque_api.Repositories.ProdutoRepository;
import com.jhessicalmeida.gerenciador_de_estoque_api.Entitys.Produto;
import com.jhessicalmeida.gerenciador_de_estoque_api.Repositories.CategoriaRepository;
@Service
public class ProdutoService {
    
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtorepository){
        this.produtoRepository = produtorepository;
    }

    public List<Produto> getAllProdutos(){
    return produtoRepository.findAll();
    }
    public List<Produto> postProdutos(Produto produto){
        produtoRepository.save(produto);
        return getAllProdutos();
    }
    public Produto putProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    public List<Produto> deleteProdutos(Long id){
        produtoRepository.deleteById(id);
        return getAllProdutos();
    }

     public Produto buscarPorId(Long id) {
     return produtoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Produto não encontrado com ID: " + id));
    }
    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
    


}

