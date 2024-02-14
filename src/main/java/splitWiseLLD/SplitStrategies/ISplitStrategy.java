package splitWiseLLD.SplitStrategies;

import splitWiseLLD.model.Split;

import java.util.List;

public interface ISplitStrategy {
    List<Split> createSplits(String createdBy, Integer amount, List<String> userIds, List<Integer> amounts);
}
