package parkingLotLld.command;

public class CommandFactory {

    public static Command getCommand (String input) {
        String[] inputSplit = input.split(" ");
        switch (inputSplit[0]) {
            case "create_parking_lot" : return new CreateParkingLotCommand(inputSplit);
            case "park" : return new ParkCommand(inputSplit);
            case "leave" : return new LeaveCommand(inputSplit);
            case "status" : return new StatusCommand();
            default : return null;
        }
    }
}
