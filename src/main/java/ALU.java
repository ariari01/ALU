public class ALU {
    public static final String OPCODE_ADD = "ADD";
    public static final String OPCODE_SUB = "SUB";
    public static final String OPCODE_MUL = "MUL";
    public static final int NO_INPUT_SIGNAL = -1;

    private int operand1 = NO_INPUT_SIGNAL;
    private int operand2 = NO_INPUT_SIGNAL;
    private String OPCODE = "";

    public void enableSignal(Output output) {
        if (diagnosticPrecondition(output)) return;

        output.updateSuccessResult(getCalculatedResult());
    }

    private boolean diagnosticPrecondition(Output output) {
        if (!isValidOPCODE()) {
            output.updateAbnormalOPCODE();
            return true;
        }

        if (!isValidOperand1()) {
            output.updateAbnormalOperand(1);
            return true;
        }

        if (!isValidOperand2()) {
            output.updateAbnormalOperand(2);
            return true;
        }
        return false;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public void setOPCODE(String OPCODE) {
        this.OPCODE = OPCODE;
    }

    private boolean isValidOperand1() {
        return operand1 != NO_INPUT_SIGNAL;
    }

    private boolean isValidOperand2() {
        return operand2 != NO_INPUT_SIGNAL;
    }

    private boolean isValidOPCODE() {
        return OPCODE.equals(OPCODE_ADD)
                || OPCODE.equals(OPCODE_SUB)
                || OPCODE.equals(OPCODE_MUL);
    }

    private int getCalculatedResult() {
        if (OPCODE.equals(OPCODE_ADD)) return operand1 + operand2;
        if (OPCODE.equals(OPCODE_MUL)) return operand1 * operand2;
        if (OPCODE.equals(OPCODE_SUB)) return operand1 - operand2;
        return 0;
    }
}