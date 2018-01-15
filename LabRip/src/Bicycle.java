import java.util.Date;

public class Bicycle {
	
	private String manufacturer;	// производитель велосипеда
    private String model;			// модель велосипеда
    private int yearOfProduction;	// год выпуска
    private boolean isUsed;			// был ли использован(б\у)
    private Date date;				// дата поступления

    public Bicycle(String manufacturer, String model, int yearOfProduction, Date date, boolean isUsed) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.isUsed = isUsed;
        this.date = date;
    }
	
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String isUsed;
        if (this.isUsed){
            isUsed = "YES";
        } else {
            isUsed = "NO";
        }
        return "<tr><td>"
			+ manufacturer + "</td><td>"
			+ model + "</td><td>"
			+ yearOfProduction + "</td><td>"
			+ date + "</td><td>"
			+ isUsed + "</td></tr>";
    }
}
