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
		
		conta.setTitular("Rodrigo 2");
				
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();		
		em2.getTransaction().begin();
		
		//a conta esta no estado detached neste momento pq fechou a conexao	
		conta.setTitular("Paulo");
		
		// com o merge a conta vai para o estado managed usando a estancia anterior
		em2.merge(conta);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
