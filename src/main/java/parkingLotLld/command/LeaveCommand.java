package parkingLotLld.command;

import parkingLotLld.ParkingLotService;
import parkingLotLld.model.Car;

public class LeaveCommand implements Command {
    int slotNo;

    LeaveCommand(String[] params) {
        this.slotNo = Integer.parseInt(params[1]);
    }

    @Override
    public void validateParams() {

    }

    @Override
    public void execute(ParkingLotService parkingLotService) {
        Car car = parkingLotService.leave(slotNo);
        System.out.printf("Car %s left slot no %d, charge to collect %f \n", car.getRegistrationNo(), slotNo, car.getParkingFee());
    }
}
