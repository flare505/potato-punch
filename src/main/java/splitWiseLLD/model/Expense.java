package splitWiseLLD.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@ToString
public class Expense {
    private UUID expenseId;
    private String createdBy;
    private Integer totalAmount;
    private List<Split> splits;
}
