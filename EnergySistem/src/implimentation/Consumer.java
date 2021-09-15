package implimentation;

public final class Consumer extends Players {
    private int id;
    private long initialBudget;
    private long monthlyIncome;
    private boolean isBankrupt;
    private long budget;
    private boolean hasContract;
    private long sumContract;
    private int monthsLeft;
    private int electricBills;
    private long haveToPay;

    public Consumer() {
    }

    /**
     *Creeza un consumator
     * @param  id id-ul
     * @param  initialBudget buegtul initial
     * @param monthlyIncome venit lunar
     */

    public void setPlayer(final int id, final long initialBudget, final long monthlyIncome) {
        this.id = id;
        this.initialBudget = initialBudget;
        this.monthlyIncome = monthlyIncome;
    }

    public long getSumContract() {
        return sumContract;
    }

    public void setSumContract(final long sumContract) {
        this.sumContract = sumContract;
    }

    public int getMonthsLeft() {
        return monthsLeft;
    }

    public void setMonthsLeft(final int monthsLeft) {
        this.monthsLeft = monthsLeft;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public long getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(final long initialBudget) {
        this.initialBudget = initialBudget;
    }

    public long getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(final long monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(final long budget) {
        this.budget = budget;
    }

    public boolean isHasContract() {
        return hasContract;
    }

    public void setHasContract(final boolean hasContract) {
        this.hasContract = hasContract;
    }

    public int getElectricBills() {
        return electricBills;
    }

    public void setElectricBills(final int electricBills) {
        this.electricBills = electricBills;
    }

    public long getHaveToPay() {
        return haveToPay;
    }

    public void setHaveToPay(final long haveToPay) {
        this.haveToPay = haveToPay;
    }

    /**
     * Suma care trebuie platita daca un cunsumator amana o luna
     * @param  consumer consumatorul
     * @return distributor
     */

    public long getSumForBankrupt(final Consumer consumer) {
        double i = 1.2;
        long a = Math.round(Math.floor(i * consumer.getHaveToPay()));
        return  a + consumer.getSumContract();
    }
}
