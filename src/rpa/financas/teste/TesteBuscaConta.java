package rpa.financas.teste;

import javax.persistence.EntityManager;

import rpa.financas.modelo.Conta;
import rpa.financas.util.JPAUtil;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
				
		//busca a conta pelo id 1		
		Conta conta = em.find(Conta.class, 1);
		
				
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		
	}

}
