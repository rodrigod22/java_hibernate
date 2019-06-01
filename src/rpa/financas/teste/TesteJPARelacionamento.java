package rpa.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import rpa.financas.modelo.Conta;
import rpa.financas.modelo.Movimentacao;
import rpa.financas.modelo.TipoMovimentacao;
import rpa.financas.util.JPAUtil;


public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("0102");
		conta.setBanco("Itau");
		conta.setNumero("1234");
		conta.setTitular("Rodrigo 3");
		
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));
		
		movimentacao.setConta(conta);		
		EntityManager em = new JPAUtil().getEntityManager();	
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
		
		
	}

}
