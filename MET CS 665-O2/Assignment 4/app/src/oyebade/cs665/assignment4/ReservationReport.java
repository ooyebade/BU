package oyebade.cs665;

public class ReservationReport {

    /**
     * Lot Level: 1 - 4
     * Lowest level to the Highest Level
     * @param
     */
    public static void main(String[] args) {
         Report dailyReport = new DailyReservations("Lizzy Love",
                 1, 4);

         Report monthlyReport = new MonthlyReservation("December", "Jim Jones",
                 3, 2);

         Report yearlyReport = new YearlyReservation("2020", "Jasmine Jame",
                 5, 1);

         yearlyReport.add(dailyReport);
         yearlyReport.add(monthlyReport);

         dailyReport.printStatement();

         monthlyReport.printStatement();

         yearlyReport.printStatement();
    }
}
