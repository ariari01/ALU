public class ALU {

    public static final int NO_RESULT = 65535;
    public static final int MISNUMBER_OPERAND1 = 1;
    public static final int MISNUMBER_OPERAND2 = 2;
    public static final int NORMAL_NUMBER = 0;
    private int operand1 = -1;
    private int operand2 = -1;
    private String OPCODE = "";

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public void setOPCODE(String OPCODE) {
        this.OPCODE = OPCODE;
    }

    public int registeredWordResult() {
        if (OPCODE.equals("ADD")) return operand1 + operand2;
        if (OPCODE.equals("MUL")) return operand1 * operand2;
        if (OPCODE.equals("SUB")) return operand1 - operand2;
        return NO_RESULT;
    }

    public void enableSignal(Result r) {
        if (isValidInput()) {
            r.setResult(registeredWordResult());
            r.setStatus(getNotValidInputCode());
            return;
        }

        r.setResult(NO_RESULT);
        r.setStatus(getNotValidInputCode());
    }

    private boolean isValidInput() {
        return operand1 != -1 && operand2 != -1;
    }

    private int getNotValidInputCode() {
        if (operand1 == -1) return MISNUMBER_OPERAND1;
        if (operand2 == -1) return MISNUMBER_OPERAND2;
        return NORMAL_NUMBER;
    }
}