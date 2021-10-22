package br.gov.sp.fatec.armazem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.armazem.entity.Categoria;
import br.gov.sp.fatec.armazem.entity.Movimentacao;
import br.gov.sp.fatec.armazem.entity.Produto;
import br.gov.sp.fatec.armazem.repository.CategoriaRepository;
import br.gov.sp.fatec.armazem.repository.MovimentacaoRepository;
import br.gov.sp.fatec.armazem.repository.ProdutoRepository;
import br.gov.sp.fatec.armazem.service.SegurancaService;

@SpringBootTest
@Transactional
@Rollback
class ArmazemApplicationTests {

	@Autowired
	private ProdutoRepository produtoRepo;

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Autowired
	private MovimentacaoRepository movimentacaoRepo;

	@Autowired
	private SegurancaService segurancaService;

	@Test
	void contextLoads() {
	}

	@Test
	void findByNomeTest() {
		Produto produto = new Produto();
		produto.setNome("ProdutoNome");
		produto.setPeso(50);
		produto.setEmbalagem("ProdutoEmbalagem");
		produtoRepo.save(produto);

		assertNotNull(produtoRepo.findByNome("ProdutoNome"));
	}

	@Test
	void findByNomeContainsOrEmbalagemContainsTest() {
		Produto produto = new Produto();
		produto.setNome("ProdutoNome");
		produto.setPeso(50);
		produto.setEmbalagem("ProdutoEmbalagem");
		produtoRepo.save(produto);

		assertFalse(produtoRepo.findByNomeContainsOrEmbalagemContains("rodut", "nada").isEmpty());
	}

	@Test
	void findByCategoriasNomeTest() {
		Categoria categoria = new Categoria();
		categoria.setNome("Teste");
		categoria.setDescricao("TESTE");
		categoria.setSigla("TS");
		categoriaRepo.save(categoria);

		Produto produto = new Produto();
		produto.setNome("ProdutoNome");
		produto.setPeso(50);
		produto.setEmbalagem("ProdutoEmbalagem");
		produto.setCategorias(new HashSet<Categoria>());
		produto.getCategorias().add(categoria);
		produtoRepo.save(produto);

		assertFalse(produtoRepo.findByCategoriasNome("Teste").isEmpty());
	}


	
	@Test
	void findByProdutosNomeTest() {
		Categoria categoria = new Categoria();
		categoria.setNome("Teste");
		categoria.setDescricao("TESTE");
		categoria.setSigla("TS");
		categoriaRepo.save(categoria);

		Produto produto = new Produto();
		produto.setNome("Teste");
		produto.setPeso(50);
		produto.setEmbalagem("ProdutoEmbalagem");
		produto.setCategorias(new HashSet<Categoria>());
		produto.getCategorias().add(categoria);
		produtoRepo.save(produto);

		assertFalse(categoriaRepo.findByProdutosNome("Teste").isEmpty());
	}

	@Test
	void findByAutorNomeTest(){
		Produto autor = new Produto();
		autor.setNome("Teste");
		autor.setPeso(50);
		autor.setEmbalagem("ProdutoEmbalagem");
		produtoRepo.save(autor);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setQuantidade(5);
		movimentacao.setSentido("Teste");
		movimentacao.setData(new Date());
		movimentacao.setAutor(autor);
		movimentacaoRepo.save(movimentacao);

		assertFalse(movimentacaoRepo.findByAutorNome("Teste").isEmpty());
	}

	@Test
	void findByMovimentacaoSentidoTest(){
		Produto autor = new Produto();
		autor.setNome("Teste");
		autor.setPeso(50);
		autor.setEmbalagem("ProdutoEmbalagem");
		produtoRepo.save(autor);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setQuantidade(5);
		movimentacao.setSentido("Teste");
		movimentacao.setData(new Date());
		movimentacao.setAutor(autor);
		movimentacaoRepo.save(movimentacao);

		assertFalse(produtoRepo.findByMovimentacaoSentido("Teste").isEmpty());
	}

	@Test
	void novoProdutoTest() {
		segurancaService.novoProduto("Teste", 500, "TestEmb", "ROLE_TEST");

		assertNotNull(produtoRepo.findByNome("Teste"));
	}

}
