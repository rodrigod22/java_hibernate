package rpa.financas.teste;

import rpa.financas.modelo.Conta;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Rodrigo");	
		conta.setBanco("Caixa Economica");
		conta.setAgencia("1642");
		conta.setNumero("14525-5");
	}
}
