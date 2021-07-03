package br.edu.infnet.appSolicitacao.model.domain;

import br.edu.infnet.appSolicitacao.model.exceptions.TipoGarantiaInexistenteException;


public class Garantia extends Servico {
	
	private String tipoGarantia; //[A] Aval ou [R] Real
	private int prazoVencimento;
	private boolean renovacaoAutomatica;
	
	public Garantia(String descricao, float valor, boolean clienteEspecial) {
		super(descricao, valor, clienteEspecial);
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.tipoGarantia);
		sb.append(";");
		sb.append(this.prazoVencimento);
		sb.append(";");
		sb.append(this.renovacaoAutomatica ? "S" : "N");

		return sb.toString();
	}

	@Override
	public float calculaPrecoItem() throws TipoGarantiaInexistenteException {
		
		
		if(!"A".equalsIgnoreCase(this.tipoGarantia) && !"R".equalsIgnoreCase(this.tipoGarantia)) {
			
			throw new TipoGarantiaInexistenteException("[Tipo de Garantia inválida] O tipo de garantia informada deve ser 'A' ou 'R'.");
			
		}
		
		
		float valorTipoGarantia = 0;
		float valorPrazoVencimento = 0;
		
		if(this.tipoGarantia == "A") { //aval
			
			valorTipoGarantia = this.getValor() * 0.05f;
		}
		
		if(this.tipoGarantia == "R") { // real
		
			 valorTipoGarantia = this.getValor() * 0.10f;
		}
	
		if (this.prazoVencimento <= 12) {
			
			valorPrazoVencimento = this.getValor()* 0.05f;
		}
		
		if (this.prazoVencimento > 12) {
			
			valorPrazoVencimento = this.getValor()* 0.10f;
		}
		
		
		return this.getValor() + valorTipoGarantia + valorPrazoVencimento;
	}


	public boolean isRenovacaoAutomatica() {
		return renovacaoAutomatica;
	}

	public void setRenovacaoAutomatica(boolean renovacaoAutomatica) {
		this.renovacaoAutomatica = renovacaoAutomatica;
	}

	public String getTipoGarantia() {
		return tipoGarantia;
	}

	public void setTipoGarantia(String tipoGarantia) {
		this.tipoGarantia = tipoGarantia;
	}

	public int getPrazoVencimento() {
		return prazoVencimento;
	}

	public void setPrazoVencimento(int prazoVencimento) {
		this.prazoVencimento = prazoVencimento;
	}


}
