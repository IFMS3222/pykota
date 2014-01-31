package br.edu.ifms.pykota.utilitarios;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class Dialog extends JDialog
{
	public static final int USUARIOS = 1;
	public static final int COTA_USUARIOS = 2;
	public static final int GRUPOS = 3;
	public static final int COTA_GRUPOS = 4;
	
	public Dialog(int pos)
	{
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setResizable(false);
		
		switch(pos)
		{
			case 1: 
				this.setTitle("Usuários");
				this.setIconImage(new Icone("../img/usuarios.png").getImage());
			break;  
			case 2: 
				this.setTitle("Cota de Usuarios");
				this.setIconImage(new Icone("../img/cotaUsuarios.png").getImage());
			break;
			case 3: 
				this.setTitle("Grupos");
				this.setIconImage(new Icone("../img/grupos.png").getImage());
			break;
			case 4: 
				this.setTitle("Cota de Grupos");
				this.setIconImage(new Icone("../img/cotaGrupos.png").getImage());
			break;
		}		
	}
	
	public void Show()
	{
		this.setVisible(true);
	}
} 
