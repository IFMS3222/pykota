package br.edu.ifms.pykota.utilitarios;

public  class AntiInjection 
{
	public static String Verificar(String str)
	{
		str = str.trim();
		
		str = str.replace("SELECT","");
		str = str.replace("INSERT","");
		str = str.replace("DELETE","");
		str = str.replace("UPDATE","");
		str = str.replace("DROP","");
		str = str.replace("CREATE","");
		str = str.replace("WHERE","");
		str = str.replace("ALTER","");
		
		str = str.replace("select","");
		str = str.replace("insert","");
		str = str.replace("delete","");
		str = str.replace("update","");
		str = str.replace("drop","");
		str = str.replace("create","");
		str = str.replace("where","");
		str = str.replace("alter","");
		
		return str;
	}
}
