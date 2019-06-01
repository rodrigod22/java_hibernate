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
		
		//persiste insere a conta
		
		//em.persist(conta);
		
		
		//aqui ele busca a conta com id 1 tornando ela managed
		conta = em.find(Conta.class, 1);
		em.remove(conta);
		
		
		
		//depois de inserir a conta faz um update e muda o banco
		conta.setBanco("Itau");
		
		em.getTransaction().commit();
		
		em.close();	
		
	}
}
