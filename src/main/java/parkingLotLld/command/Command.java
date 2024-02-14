package parkingLotLld.command;

import parkingLotLld.ParkingLotService;

public interface Command {
    void validateParams() throws ParamsValidationException;
    void execute(ParkingLotService parkingLotService);
}
