package splitWiseLLD.SplitStrategies;

import splitWiseLLD.model.Split;
import splitWiseLLD.model.SplitStatus;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitStrategy implements ISplitStrategy {
    @Override
    public List<Split> createSplits(String createdBy, Integer totalAmount, List<String> userIds, List<Integer> amountList) {
        List<Split> splits = new ArrayList<>();
        for (String id : userIds) {
            int splitVal = totalAmount / userIds.size();
            Split split1 = Split.builder()
                    .to(createdBy)
                    .from(id)
                    .value(String.valueOf(splitVal))
                    .splitStatus(SplitStatus.pending)
                    .build();
            Split split2 = Split.builder()
                    .to(id)
                    .from(createdBy)
                    .value(String.valueOf(-1 * splitVal))
                    .splitStatus(SplitStatus.pending)
                    .build();

            splits.add(split1);
            splits.add(split2);
        }
        return splits;
    }
}
