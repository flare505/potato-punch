package parkingLotLld.pricingStrategy;

import parkingLotLld.model.Slot;

import java.time.Instant;


public class FixedPricingStrategy implements IPricingStrategy {

    @Override
    public double generateTicket(Slot slot) {
        return Instant.now().getEpochSecond() - slot.getOccupiedSince();
    }
}
