package parkingLotLld.pricingStrategy;

import parkingLotLld.model.Slot;

public interface IPricingStrategy {
    double generateTicket(Slot slot);
}
