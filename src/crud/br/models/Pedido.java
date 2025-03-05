package crud.br.models;

public class Pedido {
	
	Long id;
	String nome;
	Double quantidade;
	String origem;
	
	public Pedido(Long id, String nome, Double quantidade, String origem) {
		
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.origem = origem;
	}
	
	public Pedido() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	

}
