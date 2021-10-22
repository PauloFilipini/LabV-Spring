package br.gov.sp.fatec.armazem.service;

import java.util.List;
import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.armazem.entity.Produto;
import br.gov.sp.fatec.armazem.entity.Categoria;
import br.gov.sp.fatec.armazem.repository.ProdutoRepository;
import br.gov.sp.fatec.armazem.repository.CategoriaRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService{

    @Autowired
    ProdutoRepository produtoRepo;

    @Autowired
    CategoriaRepository categoriaRepo;

    @Transactional
    public Produto novoProduto(String nome, int peso, String embalagem, String categoria) {

            Categoria cat =  categoriaRepo.findByNome(categoria);
            if(cat == null) {
            cat = new Categoria();
            cat.setNome(categoria);
            cat.setDescricao(categoria);
            cat.setSigla(categoria);
            categoriaRepo.save(cat);
            }
         

            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setPeso(peso);
            produto.setEmbalagem(embalagem);
            produto.setCategorias(new HashSet<Categoria>());
            produto.getCategorias().add(cat);
            produtoRepo.save(produto);

            return produto;

    }

    public List<Produto> buscarTodosProdutos() {
         return  produtoRepo.findAll();
    }

}