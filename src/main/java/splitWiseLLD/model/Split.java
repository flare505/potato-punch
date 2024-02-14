package splitWiseLLD.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Split {
    private String from;
    private String to;
    private String value;
    private SplitStatus splitStatus;
}
