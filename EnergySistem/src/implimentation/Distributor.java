package implimentation;

import output.Contract;

import java.util.ArrayList;
import java.util.Collections;

public final class Distributor extends Players {
    private int id;
    private int contractLength;
    private long initialBudget;
    private long initialInfrastructureCost;
    private long initialProductionCost;
    private boolean isBankrupt;
    private long budget;
    private long sumContract;
    private long lunarCost;
    private ArrayList<Consumer> clients;
    private ArrayList<Contract> contracts;

    public Distributor() {
    }

    /**
     *Creeza un distributor
     * @param  id id-ul
     * @param  initialBudget buget initial
     * @param initialInfrastructureCost cost nfrastructura
     * @param initialProductionCost cost prodctie
     */

    public void setPlayer(final int id, final int contractLength, final long initialBudget,
                          final long initialInfrastructureCost, final long initialProductionCost,
                          final long sumContract, final long lunarCost,
                          final ArrayList<Consumer> clients) {
        this.id = id;
        this.contractLength = contractLength;
        this.initialBudget = initialBudget;
        this.initialInfrastructureCost = initialInfrastructureCost;
        this.initialProductionCost = initialProductionCost;
        this.sumContract = sumContract;
        this.lunarCost = lunarCost;
        this.clients = clients;
    }

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

    public long getSumContract() {
        return sumContract;
    }

    public void setSumContract(final long sumContract) {
        this.sumContract = sumContract;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(final long budget) {
        this.budget = budget;
    }

    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public long getLunarCost() {
        return lunarCost;
    }

    public void setLunarCost(final long lunarCost) {
        this.lunarCost = lunarCost;
    }

    public ArrayList<Consumer> getClients() {
        return clients;
    }


    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(final ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    public long getCosts(final int nrCons) {
        return  getInitialInfrastructureCost() + getInitialProductionCost() * nrCons;
    }

    /**
     * Cauta oferta cu cel mai mic contract
     * @param  distributors toti distributorii
     * @return distributor
     */

    public static Distributor betterPrice(final ArrayList<Distributor> distributors) {
        ArrayList<Long> prices = new ArrayList<>();
        long i;
        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt) {
                prices.add(distributor.getSumContract());
            }
        }
        Collections.sort(prices);
        i = prices.get(0);

        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt) {
                if (distributor.getSumContract() == i) {
                    return distributor;
                }
            }
        }
        return null;
    }

    /**
     * Setarea contractului
     * @param  consumer consumatorul
     * @param  smallestDistributor cel mai mic dis. primit anterior
     */

    public static void chooseContract(final Consumer consumer,
                                      final Distributor smallestDistributor) {
        smallestDistributor.getClients().add(consumer);
        consumer.setHasContract(true);
        consumer.setMonthsLeft(smallestDistributor.getContractLength());
        consumer.setSumContract(smallestDistributor.getSumContract());

    }

    /**
     * Calculeaza contractul
     * @param  distributor distributorul
     * @param  nrClients nr de clienti
     * @return contractul
     */

    public long contractPrice(final Distributor distributor, final int nrClients) {
        double i = 0.2;
        long profit = Math.round(Math.floor(i * distributor.getInitialProductionCost()));
        if (nrClients > 0) {
            return Math.round(Math.floor((distributor.getInitialInfrastructureCost()
                    / (double) nrClients)
                    + distributor.getInitialProductionCost()
                    + profit));
        } else {
            return Math.round(Math.floor(distributor.getInitialInfrastructureCost()
                    + distributor.getInitialProductionCost()
                    + profit));
        }
    }
}
