package parkingLotLld.modes;

import parkingLotLld.ParkingLotService;
import parkingLotLld.command.Command;
import parkingLotLld.command.CommandFactory;
import parkingLotLld.modes.Mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode implements Mode {
    @Override
    public void process(ParkingLotService parkingLotService) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                String input = bufferedReader.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                Command command = CommandFactory.getCommand(input);
                if (command != null) {
                    command.execute(parkingLotService);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
