package br.gov.sp.fatec.armazem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.armazem.entity.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
    
    public List<Movimentacao> findByAutorNome(String nome);
    
}
