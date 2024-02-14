package parkingLotLld;

import lombok.NonNull;
import parkingLotLld.model.Car;
import parkingLotLld.model.ParkingLot;
import parkingLotLld.model.Slot;
import parkingLotLld.parkingStrategy.ClosestToEntryParkingStrategy;
import parkingLotLld.parkingStrategy.IParkingStrategy;
import parkingLotLld.pricingStrategy.FixedPricingStrategy;
import parkingLotLld.pricingStrategy.IPricingStrategy;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {

    public @NonNull ParkingLot parkingLot;
    public @NonNull IParkingStrategy parkingStrategy;
    public @NonNull IPricingStrategy pricingStrategy;
    public Map<String, Slot> colorMap;

    public void createParkingLot(int capacity) {
        parkingLot = ParkingLot.getInstance(capacity);
        colorMap = new HashMap<>();
        parkingStrategy = new ClosestToEntryParkingStrategy(capacity);
        pricingStrategy = new FixedPricingStrategy();
    }

    public Slot park(Car car) {

        Slot slot = parkingStrategy.getNextSlot();
        if (slot != null) {
            slot.setCarParked(car);
            slot.setOccupiedSince(Instant.now().getEpochSecond());
            parkingLot.getSlots()[slot.getSlotNo()] = slot;
            colorMap.put(car.getColor(), slot);
        }
        return slot;
    }

    public void status() {
        Arrays.stream(parkingLot.getSlots()).forEach(System.out::println);
    }

    public Car leave(int slotNo) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Slot slot = parkingLot.getSlots()[slotNo];
        Car car = slot.getCarParked();
        car.setParkingFee(pricingStrategy.generateTicket(slot));
        slot.setCarParked(null);
        parkingStrategy.addSlot(slot);
        return car;
    }


    public List<Slot> getSlotsForColor(String color) {
        // TODO
        return null;
    }

    public Slot getSlotByRegId(String regId) {
        // TODO
        return null;
    }
}
