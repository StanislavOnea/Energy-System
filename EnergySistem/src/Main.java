import implimentation.Consumer;
import implimentation.Distributor;
import implimentation.TheGame;
import input.Input;
import input.InputLoader;
import output.ConsumerOut;
import output.Contract;
import output.DistributorOut;
import output.Output;
import output.OutputGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        //Citesc datele .json
        ObjectMapper objectMapper = new ObjectMapper();
        Input input = objectMapper.readValue(new File(args[0]), Input.class);

        ArrayList<ConsumerOut> consumersOut = new ArrayList<>();
        ArrayList<DistributorOut> distributorsOut = new ArrayList<>();
        ArrayList<Contract> contracts = new ArrayList<>();

        //Extrag consumatorii din input
        ArrayList<Consumer> consumers = new ArrayList<>();
        InputLoader.consumerLoader(input, consumers);

        //Extrag distributorii din input
        ArrayList<Distributor> distributors = new ArrayList<>();
        InputLoader.distributorLoader(input, distributors);

        //Jocul
        new TheGame();
        TheGame game;
        game = TheGame.getInstance();
        game.theGame(input, distributors, consumers);

        //Generez output-ul
        OutputGenerator.distributorOutGenerator(distributors, contracts, distributorsOut);
        OutputGenerator.consumatorGenerator(consumers, consumersOut);

        //.json output
        Output output = new Output(consumersOut, distributorsOut);
        objectMapper.writeValue(new File(args[1]), output);
    }
}
