package input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class MonthlyUpdates {
    private ArrayList<ConsumerInput> newConsumerInputs;
    private ArrayList<CostsChanges> costsChanges;

    public ArrayList<ConsumerInput> getNewConsumers() {
        return newConsumerInputs;
    }

    public void setNewConsumers(ArrayList<ConsumerInput> newConsumerInputs) {
        this.newConsumerInputs = newConsumerInputs;
    }

    public ArrayList<CostsChanges> getCostChanges() {
        return costsChanges;
    }

    public ArrayList<CostsChanges> getCostsChanges() {
        return costsChanges;
    }

    public void setCostsChanges(final ArrayList<CostsChanges> costsChanges) {
        this.costsChanges = costsChanges;
    }
}
