package sii.maroc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Restaurant {
	
	
	private String order;
    private String  Mozarella_Quantity_Stock;
    private String  Tomatoes_quantity_stock;
    private String Flour_Quantity_stock_KG;
    
    private int Mozarella_Balls_left;
    private int Tomatoes_Number_left;
    private int KG_Flour_left;
    
    
    

	public Restaurant(String Mozarella_Quantity_Stock, String Tomatoes_quantity_stock, String olive0il, String pepper) {
		this.Mozarella_Quantity_Stock=Mozarella_Quantity_Stock;
		this.Tomatoes_quantity_stock=Tomatoes_quantity_stock;
		
	}

	public Restaurant(String Flour_Quantity_stock_KG, String Tomatoes_quantity_stock, String Sea_Salt, String Mozarella_Quantity_Stock, String olive0il, String Water) {
		this.Flour_Quantity_stock_KG=Flour_Quantity_stock_KG;
		this.Mozarella_Quantity_Stock=Mozarella_Quantity_Stock;
		this.Tomatoes_quantity_stock=Tomatoes_quantity_stock;
	}

	public int extract_Mozarella_Stock_Quantity() {
		String StringExracted="";
		Pattern pattern =Pattern.compile("\\d+"); 
		Matcher m = pattern.matcher(Mozarella_Quantity_Stock);
		if (m.find()) {
			StringExracted= m.group(0);}
		   Mozarella_Balls_left=Integer.parseInt(StringExracted);
           return Integer.parseInt(StringExracted);
		
	}
	
	public int extract_Tomatoes_Stock_quantity() {
		String StringExracted="";
		Pattern pattern =Pattern.compile("\\d+"); 
		Matcher m = pattern.matcher(Tomatoes_quantity_stock);
		if (m.find()) {
			StringExracted= m.group(0);}
		Tomatoes_Number_left=Integer.parseInt(StringExracted);
           return Integer.parseInt(StringExracted);
	}
	
	public int extract_Flour_Stock_quantity() {
		
		String StringExracted="";
		Pattern pattern =Pattern.compile("\\d+"); 
		Matcher m = pattern.matcher(Flour_Quantity_stock_KG);
		if (m.find()) {
			StringExracted= m.group(0);}
		KG_Flour_left=Integer.parseInt(StringExracted);
           return Integer.parseInt(StringExracted);
	}
	
	public Ticket order(String order) {
		int number_Salad_ToMake=0;
		int number_Pizza_ToMake=0;
		String StringExracted=""; 
		
		Ticket ticket=new Ticket();
		
		if(order.contains("Salad")) {
		
			Pattern pattern =Pattern.compile("\\d+"); 
			Matcher m = pattern.matcher(order);
			if (m.find()) {
			   StringExracted= m.group(0);}
			number_Salad_ToMake=Integer.parseInt(StringExracted);
			
		    if ((Mozarella_Balls_left>=number_Salad_ToMake) && (Tomatoes_Number_left>=(2*number_Salad_ToMake))) {
		    	ticket.setOrder_Accepted(true);
		    }
		    return ticket;
		    
		    
		}else if(order.contains("Pizza")) {
			
			Pattern pattern =Pattern.compile("\\d+"); 
			Matcher m = pattern.matcher(order);
			if (m.find()) {
			   StringExracted= m.group(0);}
			number_Pizza_ToMake=Integer.parseInt(StringExracted);
			
			if((Mozarella_Balls_left>=number_Pizza_ToMake)&& (Tomatoes_Number_left>=(4*number_Pizza_ToMake))&& (KG_Flour_left>=300*number_Pizza_ToMake)) {
				ticket.setOrder_Accepted(true);
			}
		return ticket;
		}
		return ticket;
	}

	public Meal retrieve(Ticket ticket) {
		Meal meal =new Meal();
		
		if(ticket.isOrder_Accepted()==true) { 
			meal.setMealInPreparationLine(true);
		}
		else 
		{meal.setMealInPreparationLine(true);}
		
		return meal;
		
	}
}
