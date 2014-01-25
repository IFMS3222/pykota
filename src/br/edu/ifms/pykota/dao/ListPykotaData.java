package br.edu.ifms.pykota.dao;

/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
import br.edu.ifms.pykota.entidades.*;

public class ListPykotaData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Billingcodes...");
		java.util.List lBillingcodesList = PykotaPersistentManager.instance().getSession().createQuery("From Billingcodes").setMaxResults(ROW_COUNT).list();
		Billingcodes[] billingcodess = (Billingcodes[]) lBillingcodesList.toArray(new Billingcodes[lBillingcodesList.size()]);
		int length = Math.min(billingcodess.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(billingcodess[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Coefficients...");
		java.util.List lCoefficientsList = PykotaPersistentManager.instance().getSession().createQuery("From Coefficients").setMaxResults(ROW_COUNT).list();
		Coefficients[] coefficientss = (Coefficients[]) lCoefficientsList.toArray(new Coefficients[lCoefficientsList.size()]);
		length = Math.min(coefficientss.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(coefficientss[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Grouppquota...");
		java.util.List lGrouppquotaList = PykotaPersistentManager.instance().getSession().createQuery("From Grouppquota").setMaxResults(ROW_COUNT).list();
		Grouppquota[] grouppquotas = (Grouppquota[]) lGrouppquotaList.toArray(new Grouppquota[lGrouppquotaList.size()]);
		length = Math.min(grouppquotas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(grouppquotas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Groups...");
		java.util.List lGroupsList = PykotaPersistentManager.instance().getSession().createQuery("From Groups").setMaxResults(ROW_COUNT).list();
		Groups[] groupss = (Groups[]) lGroupsList.toArray(new Groups[lGroupsList.size()]);
		length = Math.min(groupss.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(groupss[i]);
		}
		System.out.println(length + " record(s) retrieved.");
				
		System.out.println("Listing Payments...");
		java.util.List lPaymentsList = PykotaPersistentManager.instance().getSession().createQuery("From Payments").setMaxResults(ROW_COUNT).list();
		Payments[] paymentss = (Payments[]) lPaymentsList.toArray(new Payments[lPaymentsList.size()]);
		length = Math.min(paymentss.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(paymentss[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Printers...");
		java.util.List lPrintersList = PykotaPersistentManager.instance().getSession().createQuery("From Printers").setMaxResults(ROW_COUNT).list();
		Printers[] printerss = (Printers[]) lPrintersList.toArray(new Printers[lPrintersList.size()]);
		length = Math.min(printerss.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(printerss[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Userpquota...");
		java.util.List lUserpquotaList = PykotaPersistentManager.instance().getSession().createQuery("From Userpquota").setMaxResults(ROW_COUNT).list();
		Userpquota[] userpquotas = (Userpquota[]) lUserpquotaList.toArray(new Userpquota[lUserpquotaList.size()]);
		length = Math.min(userpquotas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(userpquotas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Users...");
		java.util.List lUsersList = PykotaPersistentManager.instance().getSession().createQuery("From Users").setMaxResults(ROW_COUNT).list();
		Users[] userss = (Users[]) lUsersList.toArray(new Users[lUsersList.size()]);
		length = Math.min(userss.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(userss[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public static void main(String[] args) {
		try {
			ListPykotaData listPykotaData = new ListPykotaData();
			try {
				listPykotaData.listTestData();
			}
			finally {
				PykotaPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
