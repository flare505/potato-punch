package parkingLotLld.command;

import lombok.NonNull;
import parkingLotLld.model.Car;
import parkingLotLld.ParkingLotService;
import parkingLotLld.model.Slot;

public class ParkCommand implements Command {
    Car car;
    ParkCommand(String[] params) {
        car = new Car(params[1], params[2], 0);
    }

    @Override
    public void validateParams() {

    }

    @Override
    public void execute(@NonNull ParkingLotService parkingLotService) {
        Slot slot = parkingLotService.park(car);
        if (slot != null) {
            System.out.printf("Car %s parked at slot %d.\n", car.getRegistrationNo(), slot.getSlotNo());
        }
    }
}
