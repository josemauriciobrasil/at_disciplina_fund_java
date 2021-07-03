package br.edu.infnet.appSolicitacao.model.tests;

import br.edu.infnet.appSolicitacao.model.domain.Consultoria;
import br.edu.infnet.appSolicitacao.model.domain.Financiamento;
import br.edu.infnet.appSolicitacao.model.domain.Garantia;
import br.edu.infnet.appSolicitacao.model.exceptions.*;

public class ServicoTeste {
	
	public static void main(String[] args) {
		try {
			Financiamento f1 = new Financiamento("Financiamento baratinho", 300, true);
			f1.setTipoFinanciamento("G");
			f1.setPrazoCarencia(3);
			f1.setPrazoTotal(10);
			System.out.printf("Financiamento -> %s", f1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Financiamento f1 = new Financiamento("Financiamento baratinho", 300, true);
			f1.setTipoFinanciamento("G");
			f1.setPrazoCarencia(3);
			f1.setPrazoTotal(0); // Exceção de prazo inválido
			System.out.printf("Financiamento -> %s", f1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Garantia g1 = new Garantia("La garantia soy yo", 300, false);
			g1.setTipoGarantia("A");
			g1.setPrazoVencimento(12);
			g1.setRenovacaoAutomatica(true);
			System.out.printf("Garantia -> %s", g1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Garantia g1 = new Garantia("La garantia soy yo", 300, false);
			g1.setTipoGarantia("F"); // Exceção de tipo de garantia inexistente
			g1.setPrazoVencimento(12);
			g1.setRenovacaoAutomatica(true);
			System.out.printf("Garantia -> %s", g1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}
		

		try {
			Consultoria c1 = new Consultoria("Consultoria desastre iminente", 50, false);
			c1.setPresencial(true);
			c1.setPrazoConsultoria(12);
			c1.setBonus(true);
			System.out.printf("Consultoria -> %s", c1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Consultoria c1 = new Consultoria("Consultoria desastre iminente", 50, false);
			c1.setPresencial(true);
			c1.setPrazoConsultoria(-1); // Exceção de prazo de consultoria
			c1.setBonus(true);
			System.out.printf("Consultoria -> %s", c1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Financiamento f1 = new Financiamento("Financiamento salvador da pátria", 1, false);
			f1.setTipoFinanciamento("G");
			f1.setPrazoCarencia(0);
			f1.setPrazoTotal(3);
			System.out.printf("Financiamento -> %s", f1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Financiamento f1 = new Financiamento("Financiamento salvador da pátria", 1, false);
			f1.setTipoFinanciamento("A");// Exceção de tipo de financiamento inválido
			f1.setPrazoCarencia(0);
			f1.setPrazoTotal(3);
			System.out.printf("Financiamento -> %s", f1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Garantia g1 = new Garantia("Garantido que vai dar certo", 300, false);
			g1.setTipoGarantia("R");
			g1.setPrazoVencimento(24);
			g1.setRenovacaoAutomatica(false);
			System.out.printf("Garantia -> %s", g1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Financiamento f1 = new Financiamento("Financiamento salvador da pátria", 10, true);
			f1.setTipoFinanciamento("G");
			f1.setPrazoCarencia(0);
			f1.setPrazoTotal(3);
			System.out.printf("Financiamento -> %s", f1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Financiamento f1 = new Financiamento("Financiamento salvador da pátria", 1, false);
			f1.setTipoFinanciamento("A");
			f1.setPrazoCarencia(6); // Exceção de tipo de financiamento inválido (prazo da carência superior ao prazo de amortização.
			f1.setPrazoTotal(3);
			System.out.printf("Financiamento -> %s", f1.obterServico());
		} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException | TipoGarantiaInexistenteException e) {
			System.out.println(e.getMessage());
		}


	}
}
