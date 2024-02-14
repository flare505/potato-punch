package parkingLotLld.command;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParamsValidationException extends RuntimeException {
    String reason;

    ParamsValidationException(String reason) {
        super(reason);
        this.reason = reason;
    }
}
