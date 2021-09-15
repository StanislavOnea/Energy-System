package output;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({ "consumers", "distributors" })

public final class Output {
    private final ArrayList<ConsumerOut> consumers;
    private final ArrayList<DistributorOut> distributors;

    public Output(final ArrayList<ConsumerOut> consumers,
                  final ArrayList<DistributorOut> distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

    public ArrayList<ConsumerOut> getConsumers() {
        return consumers;
    }

    public ArrayList<DistributorOut> getDistributors() {
        return distributors;
    }
}
