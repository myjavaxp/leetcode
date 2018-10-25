package com.yibo.leetcode.jvm;

import java.util.concurrent.TimeUnit;

public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK = null;

    private void isAlive() {
        System.out.println("yes,i'm still alive");
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i'm dead");
        }
        SAVE_HOOK = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i'm dead");
        }
    }
}
