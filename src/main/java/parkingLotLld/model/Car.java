package parkingLotLld.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    String registrationNo;
    String color;
    double parkingFee;
}
