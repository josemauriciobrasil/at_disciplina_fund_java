package br.edu.infnet.appSolicitacao.model.tests;

import br.edu.infnet.appSolicitacao.model.domain.Solicitacao;

public class SolicitacaoTeste {
	
	public static void main(String[] args) {
		
		Solicitacao solic1 = new Solicitacao("solicitacao especial");
		System.out.println("Os dados da solicitacao: " + solic1);
	}
	
	

}
