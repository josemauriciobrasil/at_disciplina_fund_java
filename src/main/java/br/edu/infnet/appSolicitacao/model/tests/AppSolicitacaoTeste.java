package br.edu.infnet.appSolicitacao.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.core.io.ClassPathResource;

import br.edu.infnet.appSolicitacao.model.domain.Consultoria;
import br.edu.infnet.appSolicitacao.model.domain.Empresa;
import br.edu.infnet.appSolicitacao.model.domain.Financiamento;
import br.edu.infnet.appSolicitacao.model.domain.Garantia;
import br.edu.infnet.appSolicitacao.model.domain.Solicitacao;
import br.edu.infnet.appSolicitacao.model.exceptions.PrazoConsultoriaIncorretoException;
import br.edu.infnet.appSolicitacao.model.exceptions.PrazoTotalIncorretoException;
import br.edu.infnet.appSolicitacao.model.exceptions.TipoFinanciamentoVedadoException;
import br.edu.infnet.appSolicitacao.model.exceptions.TipoGarantiaInexistenteException;

public class AppSolicitacaoTeste {
	
	public static void main(String[] args) {
		
		String dir = System.getProperty("user.dir");
		String arq = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+" .txt";
	
		try {
			try {
				InputStream resource = new ClassPathResource("static/solicitacoes.txt").getInputStream();
				FileWriter fileW = new FileWriter(dir + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));

				String linha = leitura.readLine();

				while (linha != null) {

					String[] campos = linha.split(";"); 

					switch (campos[0].toUpperCase()) {
					case "E":
						Empresa empresaE1 = new Empresa(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7]);

						Solicitacao s1 = new Solicitacao();
						s1.setDescricao(campos[1]);
						s1.setEmpresa(empresaE1);

						escrita.write(s1.obterSolicitacao()+"\r\n");
						
						break;

					case "F":
						Financiamento f1 = new Financiamento(campos[1], Float.valueOf(campos[2]), "S".equalsIgnoreCase(campos[3]));
						f1.setTipoFinanciamento(campos[4]);
						f1.setPrazoCarencia(Integer.valueOf(campos[5]));
						f1.setPrazoTotal(Integer.valueOf(campos[6]));

						escrita.write(f1.obterServico());

						break;

					case "G":
						Garantia g1 = new Garantia(campos[1], Float.valueOf(campos[2]), "S".equalsIgnoreCase(campos[3]));
						g1.setTipoGarantia(campos[4]);
						g1.setPrazoVencimento(Integer.valueOf(campos[5]));
						g1.setRenovacaoAutomatica("S".equalsIgnoreCase(campos[6]));

						escrita.write(g1.obterServico());

						break;

					case "C":
						Consultoria c1 = new Consultoria(campos[1], Float.valueOf(campos[2]), "S".equalsIgnoreCase(campos[3]));
							
						c1.setPresencial("S".equalsIgnoreCase(campos[4]));
						c1.setPrazoConsultoria(Integer.valueOf(campos[5]));
						c1.setBonus("S".equalsIgnoreCase(campos[6]));

						escrita.write(c1.obterServico());

						break;

					default:
						System.out.println("Entrada inválida!");
						break;
					}

					linha = leitura.readLine();
				}

				leitura.close();
				escrita.close();
				fileW.close();
			} catch (PrazoConsultoriaIncorretoException | PrazoTotalIncorretoException | TipoFinanciamentoVedadoException
					| TipoGarantiaInexistenteException | IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Processamento finalizado! Arquivo disponível em "+(dir + arq)+"!");
		}
	}
}