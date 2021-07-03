package br.edu.infnet.appSolicitacao.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solicitacao {
	
	private String descricao;
	private LocalDateTime dataSolicitacao;
	private Empresa empresa;
	

	public Solicitacao() {
		dataSolicitacao = LocalDateTime.now();
	}
	
	public Solicitacao(String descricao) {
		this();
		this.descricao = descricao;
	}
	
	
	public String obterSolicitacao() {
		return String.format("Solicitação realizada em %s para a empresa %s. ",
				this.dataSolicitacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
				this.empresa.getNomeComercial());
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");

		return String.format("%s;%s;%s",
				this.descricao,
				this.dataSolicitacao.format(formato),
				this.empresa);
		
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
