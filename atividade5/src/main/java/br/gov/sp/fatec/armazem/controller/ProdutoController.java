package br.gov.sp.fatec.armazem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.armazem.entity.Produto;
import br.gov.sp.fatec.armazem.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Produto> buscarTodosProdutos() {
        return segurancaService.buscarTodosProdutos();
    }

    @PostMapping
    public Produto novoProduto(@RequestBody Produto produto) {
            return segurancaService.novoProduto(produto.getNome(), produto.getPeso(), produto.getEmbalagem(), "ROL" );
    }

}
