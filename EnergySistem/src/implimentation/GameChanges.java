package implimentation;

import input.ConsumerInput;
import input.CostsChanges;
import input.Input;

import java.util.ArrayList;
import java.util.Objects;

public final class GameChanges {

    public static void getChanges(final ArrayList<Consumer> consumers,
                           final ArrayList<Distributor> distributors,
                           final Input input, final int i) {
        for (CostsChanges costsChangesInput : input.getMonthlyUpdates().get(i).getCostChanges()) {
            for (Distributor distributor: distributors) {
                if (distributor.getId() == costsChangesInput.getId()) {
                    distributor.setInitialInfrastructureCost(
                            costsChangesInput.getInfrastructureCost());
                    distributor.setInitialProductionCost(costsChangesInput.getProductionCost());
                }
            }
        }

        for (ConsumerInput consumerInput : input.getMonthlyUpdates().get(i).getNewConsumers()) {
            Consumer consumer = (Consumer) PlayersFactory.createPlayers("consumer");
            Objects.requireNonNull(consumer).setPlayer(consumerInput.getId(),
                    consumerInput.getInitialBudget(),
                    consumerInput.getMonthlyIncome());
            consumers.add(consumer);
        }


    }
}
