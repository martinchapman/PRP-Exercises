package misc;
public class Ticket {

	private String ticketHolder;
	
	private static int ticketsSold = 0;
	
	public static final double ticketPriceInPounds = 40;
	
	public Ticket(String ticketHolder) {
		
		this.ticketHolder = ticketHolder;
		
		ticketsSold++;
		
	}
	
	public static int ticketsSold() {
		
		return ticketsSold;
		
	}
	
	public int getTicketsSold() {
		
		return ticketsSold;
		
	}
	
	public double ticketPriceInDollars(double priceInPounds) {
		
		return priceInPounds * 0.8;
		
	}
	
	public static void main(String[] args) {
		
		Ticket ticket1 = new Ticket("Martin");
		
		Ticket ticket2 = new Ticket("Dave");
		
		System.out.println(Ticket.ticketsSold());
		
		System.out.println(ticket2.getTicketsSold());
		
	}
	
}