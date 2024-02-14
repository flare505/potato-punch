package parkingLotLld.model;

import lombok.Data;

@Data
public class Slot {
    int slotNo;
    Car carParked;
    long occupiedSince;

    public Slot(int slotNo) {
        this.slotNo = slotNo;
    }

    public boolean isVacant() {
        return carParked == null;
    }
}
