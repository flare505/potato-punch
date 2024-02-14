package parkingLotLld.parkingStrategy;

import parkingLotLld.model.Slot;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestToEntryParkingStrategy implements IParkingStrategy {
    PriorityQueue<Slot> vacantSlots;

    public ClosestToEntryParkingStrategy(int capacity) {
        vacantSlots = new PriorityQueue<>(new Comparator<Slot>() {
            @Override
            public int compare(Slot o1, Slot o2) {
                if (o1.getSlotNo() < o2.getSlotNo()) return -1;
                else if (o1.getSlotNo() == o2.getSlotNo()) return 0;
                return 1;
            }
        });

        for (int i = 1; i <= capacity; i++) {
            vacantSlots.add(new Slot(i));
        }
    }

    @Override
    public void addSlot(Slot slot) {
        vacantSlots.add(slot);
    }

    @Override
    public void removeSlot(Slot slot) {
        vacantSlots.poll();
    }

    @Override
    public Slot getNextSlot() {
        return vacantSlots.poll();
    }
}
