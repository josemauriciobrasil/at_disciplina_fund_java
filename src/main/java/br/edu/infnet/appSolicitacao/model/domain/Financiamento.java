package br.edu.infnet.appSolicitacao.model.domain;

import br.edu.infnet.appSolicitacao.model.exceptions.PrazoTotalIncorretoException;
import br.edu.infnet.appSolicitacao.model.exceptions.TipoFinanciamentoVedadoException;

public class Financiamento extends Servico {
	

	private String tipoFinanciamento; // [G] Capital de Giro ou [I] Investimento, etc
	private int prazoCarencia;
	private int prazoTotal;
	
	

	public Financiamento(String descricao, float valor, boolean clienteEspecial) {
		super(descricao, valor, clienteEspecial);
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.tipoFinanciamento);
		sb.append(";");
		sb.append(this.prazoCarencia);
		sb.append(";");
		sb.append(this.prazoTotal);
		
		return sb.toString();
		
	}
	
	@Override
	public float calculaPrecoItem() throws PrazoTotalIncorretoException, TipoFinanciamentoVedadoException {
		
		if(this.prazoTotal < 0 || this.prazoTotal < this.prazoCarencia) {
			
			throw new PrazoTotalIncorretoException("[Prazo do Financiamento inválido] O prazo total não pode ser inferior a zero e não deve ser menor do que o prazo de carência.");
		}
		
		if(!"G".equalsIgnoreCase(this.tipoFinanciamento) && !"I".equalsIgnoreCase(this.tipoFinanciamento)) {
			
			 throw new TipoFinanciamentoVedadoException("[Tipo de Financiamento inválido] Os tipos de financiamento aceitos são 'G' ou 'I'. ");
		}
		
		float valorPrazoCarencia = 0;
		float valorPrazoTotal =0;
		float valorTipoFinanciamento = 0;
		
		if(prazoCarencia < 3) {
			valorPrazoCarencia = this.getValor() * 0.10f;
			
		}
		else {
			valorPrazoCarencia = this.getValor() * 0.05f;
			
		}
		
		if(prazoTotal<10) {
			valorPrazoTotal = this.getValor() *0.10f;
			
		}
		
		else {
			valorPrazoTotal = this.getValor() *0.05f;
			
		}
		
		
		if("G".equalsIgnoreCase(this.tipoFinanciamento)) {
			
			valorTipoFinanciamento = this.getValor()*0.10f;
			
		}
		
		else {
			valorTipoFinanciamento = this.getValor()*0.05f;
			
		}
		
		
		return this.getValor() + valorPrazoCarencia + valorPrazoTotal + valorTipoFinanciamento;
		
	}

	public int getPrazoCarencia() {
		return prazoCarencia;
	}

	public void setPrazoCarencia(int prazoCarencia) {
		this.prazoCarencia = prazoCarencia;
	}

	public int getPrazoTotal() {
		return prazoTotal;
	}

	public void setPrazoTotal(int prazoTotal) {
		this.prazoTotal = prazoTotal;
	}
	
	public String getTipoFinanciamento() {
		return tipoFinanciamento;
	}

	public void setTipoFinanciamento(String tipoFinanciamento) {
		this.tipoFinanciamento = tipoFinanciamento;
	}



}
