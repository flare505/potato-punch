package parkingLotLld.modes;

import parkingLotLld.ParkingLotService;
import parkingLotLld.command.Command;
import parkingLotLld.command.CommandFactory;
import parkingLotLld.command.ParamsValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileMode implements Mode {
    @Override
    public void process(ParkingLotService parkingLotService) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/parkingLotLld/resources/input_file.txt"));
            String input = bufferedReader.readLine();
            while(input != null) {
                System.out.println("==>" + input);
                Command command = CommandFactory.getCommand(input);
                if (command != null) {
                    try{
                        command.validateParams();
                        command.execute(parkingLotService);
                    } catch (ParamsValidationException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                input = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
