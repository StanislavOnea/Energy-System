package output;

import implimentation.Consumer;
import implimentation.Distributor;

import java.util.ArrayList;

public class OutputGenerator {

    /**
     * Functia care genereza distributorii si contractele la sfarsitul jocului
     * @param  distributors distributorii finali
     * @param  contracts contactle distributorilor la final
     */

    public static void distributorOutGenerator(final ArrayList<Distributor> distributors,
                                               ArrayList<Contract> contracts,
                                               final ArrayList<DistributorOut> distributorsOut) {
        for (Distributor distributor : distributors) {
            for (Consumer consumer : distributor.getClients()) {
                Contract contract = new Contract(consumer.getId(),
                        consumer.getSumContract(), consumer.getMonthsLeft());
                contracts.add(contract);
            }
        }

        for (Distributor distributor : distributors) {
            contracts = new ArrayList<>();
            for (Consumer consumer : distributor.getClients()) {
                Contract contract = new Contract(consumer.getId(),
                        consumer.getSumContract(), consumer.getMonthsLeft());
                contracts.add(contract);
            }
            DistributorOut distributor1 = new DistributorOut(distributor.getId(),
                    distributor.getInitialBudget(),
                    distributor.isBankrupt(), contracts);
            distributorsOut.add(distributor1);
        }
    }

    /**
     *Introduce datele in lista pentru output
     * @param  consumers lista de consumatori finali
     * @param  consumersOut list in care se voe stoca consumatorii pentru output
     */

    //Functia care genereza consumatorii la sfarsitul jocului
    public static void consumatorGenerator(final ArrayList<Consumer> consumers,
                                           final ArrayList<ConsumerOut> consumersOut) {
        for (Consumer consumer : consumers) {
            ConsumerOut consumer1 = new ConsumerOut(consumer.getId(),
                    consumer.isBankrupt(), consumer.getInitialBudget());
            consumersOut.add(consumer1);
        }
    }
}
