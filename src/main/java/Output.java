public class Output {
    public static final int NO_STATUS = -1;
    public static final int INVALID_STATUS_OPERAND1 = 1;
    public static final int INVALID_STATUS_OPERAND2 = 2;
    public static final int INVALID_STATUS_OPCODE = 3;
    public static final int SUCCESS_STATUS = 0;
    public static final int NO_OUTPUT = 65535;

    private int status = NO_STATUS;
    private int result = NO_OUTPUT;

    public int getStatus() {
        return status;
    }

    public int getResult() {
        return result;
    }

    public void updateSuccessResult(int result) {
        this.status = SUCCESS_STATUS;
        this.result = result;
    }

    public void updateAbnormalOperand(int operandNumber) {
        if (operandNumber == 1) this.status = INVALID_STATUS_OPERAND1;
        if (operandNumber == 2) this.status = INVALID_STATUS_OPERAND2;
        this.result = NO_OUTPUT;
    }

    public void updateAbnormalOPCODE() {
        this.status = INVALID_STATUS_OPCODE;
        this.result = NO_OUTPUT;
    }
}