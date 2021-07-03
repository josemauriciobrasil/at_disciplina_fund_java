package br.edu.infnet.appSolicitacao.model.domain;

public class Empresa {
	
	private String nomeComercial;
	private String cnpj;
	private String telefone;
	private String endereco;
	private String complemento;
	private String cidade;
	private String cep;
	
	
	public Empresa(String nomeComercial, String cnpj, String telefone, String endereco, String complemento,
			String cidade, String cep) {
		
	
		this.nomeComercial = nomeComercial;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nomeComercial);
		sb.append(";");
		sb.append(this.cnpj);
		sb.append(";");
		sb.append(this.telefone);
		sb.append(";");
		sb.append(this.endereco);
		sb.append(";");
		sb.append(this.complemento);
		sb.append(";");
		sb.append(this.cidade);
		sb.append(";");
		sb.append(this.cep);
		
		return sb.toString();
	}
	
	
	public String getNomeComercial() {
		return nomeComercial;
	}
	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
