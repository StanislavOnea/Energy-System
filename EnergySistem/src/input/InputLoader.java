package input;

import implimentation.Consumer;
import implimentation.Distributor;
import implimentation.PlayersFactory;

import java.util.ArrayList;
import java.util.Objects;

public final class InputLoader {

    /**
     * Functia care extrage datele consumatorilor din fisierle .json
     * @param  consumers lista de consumatori
     * @param  input clasa de input
     */

    public static void consumerLoader(final Input input, final ArrayList<Consumer> consumers) {
        for (ConsumerInput consumerInput : input.getInitialData().getConsumers()) {
            Consumer consumer = (Consumer) PlayersFactory.createPlayers("consumer");
            Objects.requireNonNull(consumer).setPlayer(consumerInput.getId(),
                    consumerInput.getInitialBudget(), consumerInput.getMonthlyIncome());
            consumer.setHasContract(false);
            consumer.setSumContract(0);
            consumer.setMonthsLeft(0);
            consumers.add(consumer);
        }
    }

    /**
     * Functia care extrage datele distributori din fisierle .json
     * @param  distributors lista de distributori
     * @param  input clasa de input
     */

    public static void distributorLoader(final Input input,
                                         final ArrayList<Distributor> distributors) {
        for (DistributorInput distributorInput : input.getInitialData().getDistributors()) {
            ArrayList<Consumer> clients = new ArrayList<>();
            Distributor distributor = (Distributor) PlayersFactory.createPlayers("distributor");
            Objects.requireNonNull(distributor).setPlayer(
                    distributorInput.getId(), distributorInput.getContractLength(),
                    distributorInput.getInitialBudget(),
                            distributorInput.getInitialInfrastructureCost(),
                    distributorInput.getInitialProductionCost(),
                    0, 0, clients);
            distributors.add(distributor);
        }
    }
}

