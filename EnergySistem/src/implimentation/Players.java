package implimentation;

abstract class Players {
    private static final String CONSUMER = "consumer";
    private static final String DISTRIBUTOR = "distributor";

    public static String getCONSUMER() {
        return CONSUMER;
    }

    public static String getDISTRIBUTOR() {
        return DISTRIBUTOR;
    }
}
