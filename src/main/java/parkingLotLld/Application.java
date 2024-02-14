package parkingLotLld;

import parkingLotLld.modes.FileMode;
import parkingLotLld.modes.InteractiveMode;
import parkingLotLld.modes.Mode;

public class Application {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();

        args = new String[]{"file"};

        if (args.length == 1 && args[0].equals("file")) {
            Mode mode = new FileMode();
            mode.process(parkingLotService);
        } else {
            Mode mode = new InteractiveMode();
            mode.process(parkingLotService);
        }
    }
}
