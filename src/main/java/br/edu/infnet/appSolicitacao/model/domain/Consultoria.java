package br.edu.infnet.appSolicitacao.model.domain;

import br.edu.infnet.appSolicitacao.model.exceptions.PrazoConsultoriaIncorretoException;

public class Consultoria extends Servico {
	
	
	private boolean presencial;
	private int prazoConsultoria;
	private boolean bonus;
	

	public Consultoria(String descricao, float valor, boolean clienteEspecial) {
		super(descricao, valor, clienteEspecial);
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.presencial);
		sb.append(";");
		sb.append(this.prazoConsultoria);
		sb.append(";");
		sb.append(this.bonus ? "S" : "N");

		return sb.toString();
	}

	@Override
	public float calculaPrecoItem() throws PrazoConsultoriaIncorretoException {
		float valorVisita = 0;
		float valorConsultoria = 0;
		
		if(this.presencial) {
			valorVisita = 100;
		}
		else {
			valorVisita = 0;
		}
		
		if(this.prazoConsultoria < 0) {
			
			throw new PrazoConsultoriaIncorretoException ("[Consultoria com prazo inválido] O prazo da consultoria não pode ser inferior a 0.");
		}
		
		if(this.prazoConsultoria < 12)  {
			valorConsultoria = 10;
		}
		
		else {
			valorConsultoria = 20;
		
		}
		
		if(this.bonus) {
			return this.getValor();
		}
		else {
			return this.getValor() + valorVisita + valorConsultoria;
		}
		
	}

	public boolean isPresencial() {
		return presencial;
	}

	public void setPresencial(boolean presencial) {
		this.presencial = presencial;
	}

	public int getPrazoConsultoria() {
		return prazoConsultoria;
	}

	public void setPrazoConsultoria(int prazoConsultoria) {
		this.prazoConsultoria = prazoConsultoria;
	}

	public boolean isBonus() {
		return bonus;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}


	
	

}
