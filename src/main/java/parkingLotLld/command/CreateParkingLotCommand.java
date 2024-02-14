package parkingLotLld.command;

import parkingLotLld.ParkingLotService;

public class CreateParkingLotCommand implements Command {
    int parkingLotSize;

    CreateParkingLotCommand(String[] params) {
        parkingLotSize = Integer.parseInt(params[1]);
    }

    @Override
    public void validateParams() {
        if (this.parkingLotSize > 100) {
            throw new ParamsValidationException("parking lot greater than 100");
        }
    }

    @Override
    public void execute(ParkingLotService parkingLotService) {
        parkingLotService.createParkingLot(parkingLotSize);
    }
}
