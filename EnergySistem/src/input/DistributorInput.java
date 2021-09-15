package input;

public final class DistributorInput {
    private int id;
    private int contractLength;
    private long initialBudget;
    private long initialInfrastructureCost;
    private long initialProductionCost;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    public long getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(final long initialBudget) {
        this.initialBudget = initialBudget;
    }

    public long getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public void setInitialInfrastructureCost(final long initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    public long getInitialProductionCost() {
        return initialProductionCost;
    }

    public void setInitialProductionCost(final long initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
    }
}
