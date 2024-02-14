package parkingLotLld.command;

import parkingLotLld.ParkingLotService;

public class StatusCommand implements Command{
    @Override
    public void validateParams() {

    }

    @Override
    public void execute(ParkingLotService parkingLotService) {
        parkingLotService.status();
    }
}
