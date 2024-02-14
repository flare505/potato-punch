package parkingLotLld.modes;

import parkingLotLld.ParkingLotService;

public interface Mode {
    void process(ParkingLotService parkingLotService);
}
