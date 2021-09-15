package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "bankrupt", "budget" })
public final class ConsumerOut {
    private final int id;
    private final boolean isBankrupt;
    private final long budget;

    public ConsumerOut(final int id, final boolean isBankrupt, final long budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    @JsonProperty("isBankrupt")
    public boolean isBankrupt() {
        return isBankrupt;
    }

    public long getBudget() {
        return budget;
    }
}
