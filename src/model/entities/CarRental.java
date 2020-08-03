package model.entities;

import java.util.Date;

public class CarRental {

	private Date start;
	private Date finish;
	
	private Vehicle vehicle;
	private Invoice invoice;
	
	public CarRental() {
		
	}

	public CarRental(Date strat, Date finish, Vehicle vehicle) {
		this.start = strat;
		this.finish = finish;
		this.vehicle = vehicle;
	}

	public Date getStart() {
		return start;
	}

	public void setStrat(Date strat) {
		this.start = strat;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Invoice getInvoice() {
		return invoice;
	} 

}
