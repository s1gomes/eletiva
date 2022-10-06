package br.edu.uerr.loja.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.uerr.loja.modelo.Fornecedor;
import br.edu.uerr.loja.modelo.Produto;
import br.edu.uerr.loja.repositorio.EmpresaRepositorio;
import br.edu.uerr.loja.repositorio.FornecedorRepositorio;
import br.edu.uerr.loja.repositorio.ProdutoRepositorio;

@Controller
public class ProdutoControler {

	@Autowired
	ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	EmpresaRepositorio empresaRepositorio;
	
	@Autowired
	FornecedorRepositorio fornecedorRepositorio;
	
	//Listar
	
	@GetMapping("/produto")
	public String abreProduto(Model modelo) {
		modelo.addAttribute("listaProduto", produtoRepositorio.findAll());
		return "produto";
	}
	
	//From
	@GetMapping("/cadastroProduto")
	public String novoProduto(Model model) {
		Produto produto = new Produto();
		
		model.addAttribute("listaEmpresas", empresaRepositorio.findAll());		
		model.addAttribute("listaFornecedores", fornecedorRepositorio.findAll());
		
		
		model.addAttribute("produto", produto);
		return "formProduto";
	}
	
	//Salvar/Alterar
	
	@GetMapping("/alterarProduto")
	public String alterar(@ModelAttribute("produto") Produto produto, Model modelo) {
	
		Produto produto = new Produto();
		
		modelo.addAttribute("listaProdutos", produtoRepositorio.findAll());
	  return "formProduto"; 	
	}
	
	
	//Deletar
	
	@PostMapping("/deletarProduto")
	public String deletar(@ModelAttribute("deletar") Produto produto, Model modelo) {
	
		produtoRepositorio.delete(produto);
		Produto produto = 0;
		
	  return "formProduto"; 	
	}
	
	
}