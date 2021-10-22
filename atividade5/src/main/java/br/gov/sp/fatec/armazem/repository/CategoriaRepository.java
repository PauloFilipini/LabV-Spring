package br.gov.sp.fatec.armazem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.armazem.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
    public List<Categoria> findByProdutosNome(String nome);

    public Categoria findByNome(String nome);
}
