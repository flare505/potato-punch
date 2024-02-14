package parkingLotLld.parkingStrategy;

import parkingLotLld.model.Slot;

public interface IParkingStrategy {
     void addSlot(Slot slot);
     void removeSlot(Slot slot);
     Slot getNextSlot();
}
