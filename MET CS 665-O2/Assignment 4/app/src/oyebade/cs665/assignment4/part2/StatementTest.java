package oyebade.cs665.part2;

public class StatementTest {

    public static void main(String[] args) {

        Statement firstMonth = new MonthlyStatement("January", "2022");
        Statement secondMonth = new MonthlyStatement("February", "2022");
        Statement thirdMonth = new MonthlyStatement("March", "2022");

        Statement quarterlyStatement = new ComboStatement("Quarterly Statement for ",
                "Q1 2022");

        quarterlyStatement.add(firstMonth);
        quarterlyStatement.add(secondMonth);
        quarterlyStatement.add(thirdMonth);
        //quarterlyStatement.remove(thirdMonth);


        System.out.println("-- Testing Monthly Statement by itself --");
        firstMonth.printStatement();
        System.out.println("\n");

        System.out.println("-- Testing Quarterly Statement --");
        quarterlyStatement.printStatement();
        System.out.println("\n");

        Statement fourthMonth = new MonthlyStatement("April", "2022");
        Statement fifthMonth = new MonthlyStatement("May", "2022");
        Statement sixthMonth = new MonthlyStatement("June", "2022");

        Statement quarterlyStatement1 = new ComboStatement("Quarterly Statement for ",
                "Q2 2022");

        quarterlyStatement1.add(fourthMonth);
        quarterlyStatement1.add(fifthMonth);
        quarterlyStatement1.add(sixthMonth);

        System.out.println("-- Testing Quarterly Statement --");
        quarterlyStatement1.printStatement();
        System.out.println("\n");

        Statement halfYearlyStatement = new ComboStatement("First Half yearly ",
                "Statement for 2022");
        halfYearlyStatement.add(quarterlyStatement);
        //halfYearlyStatement.remove(quarterlyStatement1);
        halfYearlyStatement.add(quarterlyStatement1);

        System.out.println("-- Testing Half yearly statement --");
        halfYearlyStatement.printStatement();

    }
}
