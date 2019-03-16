package com.yibo.leetcode.juc.chapter6;

import java.util.concurrent.TimeUnit;

public class SharedData {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size) {
        size = size > 0 ? size : 10;
        buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() {
        try {
            lock.readLock();
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    private char[] doRead() {
        char[] res = new char[buffer.length];
        System.arraycopy(buffer, 0, res, 0, buffer.length);
        waiting(1L);
        return res;
    }

    public void write(char c) {
        try {
            lock.writeLock();
            doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            waiting(10L);
        }
    }

    private void waiting(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
