package br.edu.infnet.appSolicitacao.model.domain;

import br.edu.infnet.appSolicitacao.model.exceptions.PrazoConsultoriaIncorretoException;
import br.edu.infnet.appSolicitacao.model.exceptions.PrazoTotalIncorretoException;
import br.edu.infnet.appSolicitacao.model.exceptions.TipoFinanciamentoVedadoException;
import br.edu.infnet.appSolicitacao.model.exceptions.TipoGarantiaInexistenteException;


public abstract class Servico {

	private String descricao;
	private float valor;
	private boolean clienteEspecial;
	
	
	public Servico(String descricao, float valor, boolean clienteEspecial) {
		this.descricao = descricao;
		this.valor = valor;
		this.clienteEspecial = clienteEspecial;
	}
	

	public String obterServico() throws TipoGarantiaInexistenteException, PrazoTotalIncorretoException, PrazoConsultoriaIncorretoException, TipoFinanciamentoVedadoException {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.calculaPrecoItem());
		sb.append("\r\n");
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.valor);
		sb.append(";");
		sb.append(this.clienteEspecial ? "S": "N");
		
		return sb.toString();
		
	}
	
	public abstract float calculaPrecoItem() throws TipoGarantiaInexistenteException, PrazoTotalIncorretoException, PrazoConsultoriaIncorretoException, TipoFinanciamentoVedadoException; 
		
		public String getDescricao() {
			return descricao;
		}
		
		public float getValor() {
			return valor;
		}
		
		public boolean IsClienteEspecial() {
			return clienteEspecial;
		}
	}

