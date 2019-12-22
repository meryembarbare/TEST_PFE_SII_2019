package sii.maroc;

public class Meal {
	
	
    private boolean MealInPreparationLine=false;
    
    public Meal() {
    	this.MealInPreparationLine=MealInPreparationLine;
    }
    
	public boolean isMealInPreparationLine() {
		return MealInPreparationLine;
	}

	public void setMealInPreparationLine(boolean mealInPreparationLine2) {
		this.MealInPreparationLine = MealInPreparationLine;
		
	}
	public int servedDishes() {
		if (MealInPreparationLine==true) {
		return 1;}
		else return 0;
	}

	public int cookingDuration() {
		
		return 0;
	}

	



}
