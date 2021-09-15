package implimentation;

import input.Input;

import java.util.ArrayList;
import java.util.Objects;

public class TheGame {
    private static TheGame singleInstance = null;

    public static TheGame getInstance() {
        // To ensure only one instance is created
        if (singleInstance == null) {
            singleInstance = new TheGame();
        }
        return singleInstance;
    }

    /**
     *Implimentarea propriu-zisa a jocului
     * @param  consumers lista de consumatori din main
     * @param  distributors lista distributori din main
     * @param input pentru nr. de luni
     */

        public void theGame(final Input input,
                               final ArrayList<Distributor> distributors,
                               final ArrayList<Consumer> consumers) {
        for (int i = 0; i < input.getNumberOfTurns() + 1; i++) {

            //Actualizez schimbarile lunare
            if (i != 0) {
                GameChanges.getChanges(consumers, distributors, input, i - 1);
            }

            //Sterg clienti care au dat faliment
            //Calculez contractul & cheltuielile conform nr de clienti
            for (Distributor distributor : distributors) {
                if (!distributor.isBankrupt()) {
                    distributor.getClients().removeIf(Consumer::isBankrupt);
                    distributor.setSumContract(distributor.contractPrice(distributor,
                            distributor.getClients().size()));
                    distributor.setLunarCost(distributor.getCosts(distributor.getClients().size()));
                }
            }

            //Adaug venitul lunar & verific daca contractul continua
            for (Consumer consumer : consumers) {
                if (!consumer.isBankrupt()) {
                    consumer.setInitialBudget(consumer.getInitialBudget()
                            + consumer.getMonthlyIncome());
                    if (consumer.getMonthsLeft() <= 0) {
                        consumer.setHasContract(false);
                    }
                }
            }

            //Extrag din nr. de clienti pe cei ce nu au contract
            for (Distributor distributor : distributors) {
                distributor.getClients().removeIf(consumer -> (!consumer.isHasContract()));
            }

            //Determin distributorul cu cell mai avantajos contract
            Distributor smallestDistributor = Distributor.betterPrice(distributors);

            //Consumatorii isi aleg contractul
            for (Consumer consumer : consumers) {
                if (!consumer.isBankrupt()) {
                    if (!consumer.isHasContract()) {
                        if (!Objects.requireNonNull(smallestDistributor).isBankrupt()) {
                            Distributor.chooseContract(consumer, smallestDistributor);
                        }
                    }
                }
            }

            //Actulizez cheltuilile si scad cheltuiele lunare
            for (Distributor distributor : distributors) {
                if (!distributor.isBankrupt()) {
                    distributor.setLunarCost(distributor.getCosts(
                            distributor.getClients().size()));
                    distributor.setInitialBudget(distributor.getInitialBudget()
                            - distributor.getLunarCost());
                }
            }

            //Parcurg distributorii si clientii lor
            for (Distributor distributor : distributors) {
                if (!distributor.isBankrupt()) {
                    for (Consumer consumer : distributor.getClients()) {
                        if (!consumer.isBankrupt()) {
                            //Cate facturi are de platit
                            consumer.setElectricBills(consumer.getElectricBills()
                                    + 1);
                            if (consumer.getElectricBills() < 2) {
                                //Adaug si scad contractul/cheltuielile la distributori
                                // si consumatori
                                if (consumer.getInitialBudget() >= consumer.getSumContract()) {
                                    consumer.setInitialBudget(consumer.getInitialBudget()
                                            - consumer.getSumContract());
                                    distributor.setInitialBudget(distributor.getInitialBudget()
                                            + consumer.getSumContract());
                                    consumer.setElectricBills(consumer.getElectricBills() - 1);
                                    //Cazul cand clientul nu poate plati
                                } else {
                                    consumer.setElectricBills(1);
                                    consumer.setHaveToPay(consumer.getSumContract());
                                }
                                consumer.setMonthsLeft(consumer.getMonthsLeft() - 1);
                                //Cazul cand clinetnul nu poate plati pentru 2 luni
                            } else if (consumer.getInitialBudget()
                                    < (consumer.getSumForBankrupt(consumer))) {
                                consumer.setBankrupt(true);
                            }
                        }
                    }
                }
            }

            //Identific distributorii care au dat faliment
            //Scot consumatorii care au dat faliment
            for (Distributor distributor : distributors) {
                distributor.getClients().removeIf(Consumer::isBankrupt);
                if (distributor.getInitialBudget() < 0) {
                    distributor.setBankrupt(true);
                }
            }
        }
    }
}
