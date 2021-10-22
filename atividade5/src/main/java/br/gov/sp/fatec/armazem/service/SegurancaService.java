package br.gov.sp.fatec.armazem.service;

import java.util.List;

import br.gov.sp.fatec.armazem.entity.Produto;

public interface SegurancaService {

    public Produto novoProduto(String nome, int peso, String embalagem,String categoria);

    public List<Produto> buscarTodosProdutos();
}