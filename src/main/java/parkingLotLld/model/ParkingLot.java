package parkingLotLld.model;

import lombok.Data;


@Data
public class ParkingLot {
    private static ParkingLot INSTANCE;
    Slot[] slots;

    private ParkingLot(int n) {
        slots = new Slot[n+1];
        for (int i = 1; i <= n; i++) {
            slots[i] = new Slot(i);
        }
    }

    public static ParkingLot getInstance(int n) {
        if (INSTANCE == null) {
            INSTANCE = new ParkingLot(n);
        }
        return INSTANCE;
    }
}
