package model.services;

public class BrazilTaxServices implements TaxService {
	
	public Double tax(Double amount) {
		if(amount <= 100) {
			return amount * 0.2;
		}
		else {
			return amount * 0.35;
		}
	}
	
}
