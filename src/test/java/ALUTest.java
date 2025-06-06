import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ALUTest {

    @Test
    void enableSignal() {
        ALU alu = new ALU();
        alu.setOperand1(10);
        alu.setOperand2(20);
        alu.setOPCODE("ADD");

        Result ret = new Result();
        alu.enableSignal(ret);

        assertEquals(30, ret.getResult());
        assertEquals(0, ret.getStatus());
    }

    @Test
    void enableSignal2() {
        ALU alu = new ALU();
        alu.setOperand1(10);
        alu.setOperand2(-1);
        alu.setOPCODE("ADD");

        Result ret = new Result();
        alu.enableSignal(ret);

        assertEquals(65535, ret.getResult());
        assertEquals(2, ret.getStatus());
    }
}