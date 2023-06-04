package oyebade.cs665.part2;

import java.util.ArrayList;

public abstract class Statement {

    // adding elements
    public void add(Statement statement) {
        throw new UnsupportedOperationException();
    }

    // removing elements
    public void remove(Statement statement) {
        throw new UnsupportedOperationException();
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }

    public Statement getChild(int i) {
        throw new UnsupportedOperationException();
    }

}

class MonthlyStatement extends Statement {

    String month;
    String year;

    public MonthlyStatement(String month, String year) {

        this.month = month;
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    @Override
    public void printStatement() {
        System.out.println("** Monthly Statement for " + getMonth() + ", " + getYear());
    }
}

class ComboStatement extends Statement {

    ArrayList<Statement> statements = new ArrayList<>();

    String name;
    String description;

    public ComboStatement(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(Statement statement) {
        statements.add(statement);
    }

    public void remove(Statement statement) {
        statements.remove(statement);
    }

    public Statement getChild(int i) {
        return (Statement)statements.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void printStatement() {
        System.out.println("** Combo Statement of " + getName() + getDescription());

        for(Statement statement: statements) {
            statement.printStatement();
        }
    }
}
