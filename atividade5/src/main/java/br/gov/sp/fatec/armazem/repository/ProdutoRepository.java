package br.gov.sp.fatec.armazem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.armazem.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
    public Produto findByNome(String nome);

    public List<Produto> findByNomeContainsOrEmbalagemContains(String nome,String embalagem);

    public List<Produto> findByCategoriasNome(String nome);

    public List<Produto> findByMovimentacaoSentido(String sentido);
}
