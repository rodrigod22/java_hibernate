package rpa.financas.teste;

import javax.persistence.EntityManager;
import rpa.financas.modelo.Conta;
import rpa.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Rodrigo");	
		conta.setBanco("Caixa Economica");
		conta.setAgencia("1642");
		conta.setNumero("14525-5");		
		
		EntityManager em = new JPAUtil().getEntityManager();		
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();	
		
	}
}
