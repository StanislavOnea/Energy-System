package input;

import java.util.ArrayList;

public final class Input {
    private int numberOfTurns;
    private InitialData initialData;
    private ArrayList<MonthlyUpdates> monthlyUpdates;

    public ArrayList<MonthlyUpdates> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    public void setMonthlyUpdates(final ArrayList<MonthlyUpdates> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(final int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }
}
