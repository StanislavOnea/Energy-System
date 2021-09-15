package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({ "id", "budget", "bankrupt", "contracts" })

public final class DistributorOut {
    private final int id;
    private final long budget;
    private final boolean isBankrupt;
    private final ArrayList<Contract> contracts;

    public DistributorOut(final int id, final long budget,
                          final boolean isBankrupt,
                          final ArrayList<Contract> contracts) {
        this.id = id;
        this.budget = budget;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public long getBudget() {
        return budget;
    }

    @JsonProperty("isBankrupt")
    public boolean isBankrupt() {
        return isBankrupt;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }
}
