package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentaService {

	private Double pricePerDay;
	private Double pricePerhour;
	
	private TaxService taxService;

	public RentaService(Double pricePerDay, Double pricePerhour, TaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerhour = pricePerhour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();

		double hours = (double) (t2 - t1) /1000 / 60 / 60;
		
		double basicPayment;
		if(hours <= 12) {
			basicPayment = Math.ceil(hours) * pricePerhour;
		}
		else {
			basicPayment = Math.ceil(hours / 24)  * pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment); // calcula valor de taxa.
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
		
	}
	
}
