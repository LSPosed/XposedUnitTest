package io.github.lsposed.unittest;

public class Methods {
    public static final int allTests = 1;

    public static int runAll() {
        int passed = 0;
        if (staticTest(2) == 4) passed += 1;
        return passed;
    }

    public static int staticTest(int i) {
        return i + 1;
    }
}
