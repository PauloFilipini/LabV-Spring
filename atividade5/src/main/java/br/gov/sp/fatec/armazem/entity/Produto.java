package br.gov.sp.fatec.armazem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pro_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private long id;

    @Column(name = "pro_nome")
    private String nome;

    @Column(name = "pro_peso")
    private int peso;

    @Column(name = "pro_embalagem")
    private String embalagem;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pca_produto_categoria", 
        joinColumns = { @JoinColumn(name = "pro_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "cat_id") })
    private Set<Categoria> categorias;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    private Set<Movimentacao> movimentacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

}