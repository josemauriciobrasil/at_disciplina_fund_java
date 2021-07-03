package br.edu.infnet.appSolicitacao.model.tests;

import br.edu.infnet.appSolicitacao.model.domain.Empresa;

public class EmpresaTeste {
	
	public static void main(String[] args) {
		
		Empresa e1 = new Empresa("ABC", "100811", "2222-2233", "Rua A, casa B", "Logo ali", "niteroi", "33333-4444");
		
		System.out.println("Empresa: " + e1);
	}

}
