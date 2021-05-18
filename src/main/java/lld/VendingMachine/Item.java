package lld.VendingMachine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    String id;
    String name;
    double price;
}
