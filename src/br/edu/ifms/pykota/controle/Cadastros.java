package br.edu.ifms.pykota.controle;

import java.util.Random;

import br.edu.ifms.pykota.entidades.Users;;

public class Cadastros {
	
/*essa classe insere novos usuarios a partir do pykotaadmin, setado no sql*/
public Object Insere_User() {		
				
		Users dados = new Users();
		
		Random gerador = new Random();
		dados.setUsername("Felipe" + gerador.nextInt());
		dados.setEmail("Tads");
		dados.setLifetimepaid((float) 1.0);
		dados.setDescription("teste");
		dados.setLimitby("teste");
		dados.setBalance((float) 1.0);

		return dados;
		
	}
	
}
