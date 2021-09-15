package implimentation;

public final class PlayersFactory {
    //Implimentare factory pattern

    /**
     *Creeza jucatorii
     * @param  type tipul jucatorilor
     */

    public static Players createPlayers(final String type) {
        if (type.compareTo(Players.getCONSUMER()) == 0) {
            return new Consumer();
        }
        if (type.compareTo(Players.getDISTRIBUTOR()) == 0) {
            return new Distributor();
        }
        return null;
    }
}
