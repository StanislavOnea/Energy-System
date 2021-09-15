package input;

import java.util.ArrayList;

public final class InitialData {
    private ArrayList<ConsumerInput> consumerInputs;
    private ArrayList<DistributorInput> distributorInputs;

    public ArrayList<ConsumerInput> getConsumers() {
        return consumerInputs;
    }

    public void setConsumers(final ArrayList<ConsumerInput> consumerInputs) {
        this.consumerInputs = consumerInputs;
    }

    public ArrayList<DistributorInput> getDistributors() {
        return distributorInputs;
    }

    public void setDistributors(final ArrayList<DistributorInput> distributorInputs) {
        this.distributorInputs = distributorInputs;
    }
}
