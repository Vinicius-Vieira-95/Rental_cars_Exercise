package aplication;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentaService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter rental date: ");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Price per hours: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Price per day: ");
		double pricePerDay = sc.nextDouble();
		
		RentaService rs = new RentaService(pricePerDay, pricePerHour, new BrazilTaxServices() );
		
		rs.processInvoice(cr);
		
		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax:  " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Bacic payment: " + String.format("%.2f", cr.getInvoice().totalPaument()));
		
		
		sc.close();
	}

}
