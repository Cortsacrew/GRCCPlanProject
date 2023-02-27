import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

public class Plane {

    //Class Fields/Instance Variables

    private String airline;
    private String model;
    private int year;
    private double hours;
    private double nextInspectionHours;
    private double gasGauge;
    private double gph;
    private static final double TANK_CAPACITY = 50000;
    private static final int HOURS_BETWEEN_INSPECTION = 48;
    private static DecimalFormat df = new DecimalFormat("###,##0.00");
    //decimal format at the end
    private boolean engineON;
    private boolean isLanded;

    public Plane() {
        //constructor
        airline = "Southwest";
        model = "747";
        year = 2021;
        gph = 3600.0;
        gasGauge = TANK_CAPACITY;
        nextInspectionHours = HOURS_BETWEEN_INSPECTION;
    }

    public Plane(String airline,
                 String model,
                 int year,
                 double gph) {

        this.airline = airline;
        this.model = model;
        this.year = year;
        this.gph = gph;
        this.hours = 0;
        this.gasGauge = TANK_CAPACITY;
        this.nextInspectionHours = HOURS_BETWEEN_INSPECTION;
    }

    //Accessor Methods
    //Can be created in Code => Generate => Getter and Setter
    public String getAirline() {
        return this.airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isEngineON () { return engineON; }

    public boolean isLanded () { return isLanded; }

    public double getGph() {
        return this.gph;
    }

    public void setGph(double gph) {
        this.gph = gph;
    }

    public double getHoursNextInspection() {
        return nextInspectionHours;
    }

    public double checkFlyingHours() {
        return hours;
    }

    public double checkGasGauge() {
        return gasGauge;

    }


//phase 2

    public void addGas(double gallons) {
        if (engineON){
            System.out.println(airline + " " +
                    model + " " +
                    year +
                    " must be landed and OFF to add fuel.");
            return;
        }
        if (gallons < 0)
            System.out.println(airline + " " +
                    model + " " +
                    year +
                    " gallons cannot be a negative number - Fuel in Tank after the fill up : " +
                    df.format(gasGauge));
        else if (gasGauge + gallons > TANK_CAPACITY) {
            gasGauge = TANK_CAPACITY;
            System.out.println(airline + " " +
                    model + " " +
                    year + " tank overflowed - Fuel in Tank after the fill up: " +
                    df.format(TANK_CAPACITY));
        } else
            gasGauge = gasGauge + gallons;
        System.out.println(airline + " " +
                model + " " +
                year +
                " added fuel: " + df.format(gallons) +
                " - Fuel in Tank after the fill up: " + df.format(gasGauge));

    }

    public void fly(double hours) {
        if (!engineON){
            System.out.println(airline + " " +
                    model + " " +
                    year +" must be ON to fly.");
                    return;
            }
        if (hours < 0)
            System.out.println(airline + " " +
                    model + " " +
                    year +
                    " cannot fly negative miles.");

        else if (hours > (gasGauge / gph)) {
            this.hours += (gasGauge / gph);
            System.out.println(airline + " " +
                    model + " " +
                    year +
                    " ran out of fuel after flying " +
                    df.format(gasGauge / gph) +
                    " hours.");
            gasGauge = 0.0;

        } else {
            gasGauge = gasGauge - (hours * gph);
            System.out.println(airline + " " +
                    model + " " +
                    year + " flew " + hours + " hours.");
            this.hours += hours;
        }
    }

    public void inspect() {
        System.out.println(airline + " " +
                model + " " +
                year + " has been inspected, next inspection is: " + HOURS_BETWEEN_INSPECTION);

    }

    public void checkForInspection() {
        if (hours > HOURS_BETWEEN_INSPECTION)
            System.out.println(airline + " " +
                    model + " " +
                    year + " - It is time to inspect.");
        else
            System.out.println(airline + " " +
                    model + " " +
                    year + " - Plane is OK, no need to inspect.");
    }

    public String toString() {
        return airline + " " +
                model + " " +
                year + " " +
                "Flight Hours: " +
                df.format(hours) + " " +
                "JetFuel in Tank: " +
                df.format(gasGauge);
    }

    public boolean equals(Plane other) {
        return this.airline == other.getAirline() && this.model == other.getModel() && this.year == other.getYear();
        }

//phase 3
    public void startEngine( ){
        System.out.println(airline + " " +
                model + " " +
                year + " - engine started");
                this.engineON = true;
        }
    public void landAndStopEngine( ){
        System.out.println(airline + " " +
                model + " " +
                year + " - was landed and stopped.");
                this.isLanded = true;
        }
    public boolean isEngineOn( ){
        return this.engineON;
        }
    private double calcRange(){
        return gasGauge * gph;
        }
    private double calcGasNeededToFillTank(){
        return TANK_CAPACITY - gasGauge;
        }
    public void simulateMultiCityTrip (int numberCities ){

        }
}
