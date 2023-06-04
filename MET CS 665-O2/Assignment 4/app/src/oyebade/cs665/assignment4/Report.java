package oyebade.cs665;

import java.util.ArrayList;
import java.util.Date;

public abstract class Report {

    public void add(Report report) {
        throw new UnsupportedOperationException();
    }

    public void remove(Report report) {
        throw new UnsupportedOperationException();
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }

    public Report getChild(int i) {
        throw new UnsupportedOperationException();
    }
}

class DailyReservations extends Report {
    Date date;
    String customerName;
    int numberOfReservation;
    int lotLevel;

    public DailyReservations(String customerName,
                             int numberOfReservation, int lotLevel)
    {
        this.customerName = customerName;
        this.numberOfReservation = numberOfReservation;
        this.lotLevel = lotLevel;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfReservation() {
        return numberOfReservation;
    }

    public int getLotLevel() {
        return lotLevel;
    }

    @Override
    public void printStatement() {
        System.out.println("** Daily Reservation Report "
                + "is as follows: " + "\n"
                + "Customer Name: " + getCustomerName() + "\n"
                + " Reservation Number: " + getNumberOfReservation() + "\n"
                + " Lot Level: " + getLotLevel());
    }
}

class MonthlyReservation extends Report {

    String month;
    String customerName;
    int numberOfReservation;
    int lotLevel;

    public MonthlyReservation(String month,
                             String customerName,
                             int numberOfReservation, int lotLevel)
    {
        this.month = month;
        this.customerName = customerName;
        this.numberOfReservation = numberOfReservation;
        this.lotLevel = lotLevel;
    }

    public String getMonth() {
        return month;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfReservation() {
        return numberOfReservation;
    }

    public int getLotLevel() {
        return lotLevel;
    }

    @Override
    public void printStatement() {
        System.out.println("** Monthly Reservation Report for the " + getMonth()
                + " is as follows: " + "\n"
                + "Customer Name: " + getCustomerName() + "\n"
                + " Reservation Number: " + getNumberOfReservation() + "\n"
                + " Lot Level: " + getLotLevel());
    }
}


class YearlyReservation extends Report {

    ArrayList<Report> reports = new ArrayList<>();

    String year;
    String customerName;
    int numberOfReservation;
    int lotLevel;

    public YearlyReservation(String year,
            String customerName,
            int numberOfReservation, int lotLevel)
    {
        this.year = year;
        this.customerName = customerName;
        this.numberOfReservation = numberOfReservation;
        this.lotLevel = lotLevel;
    }

    public String getYear() {
        return year;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfReservation() {
        return numberOfReservation;
    }

    public int getLotLevel() {
        return lotLevel;
    }

    public void add(Report report) {
        reports.add(report);
    }

    public void remove(Report report) {
        reports.add(report);
    }

    @Override
    public Report getChild(int i) {
        return (Report) reports.get(i);
    }

    @Override
    public void printStatement() {
        System.out.println("** Yearly Reservation Report for the " + getYear()
                + " is as follows: " + "\n"
                + "Customer Name: " + getCustomerName() + "\n"
                + " Reservation Number: " + getNumberOfReservation() + "\n"
                + " Lot Level: " + getLotLevel());
    }
}