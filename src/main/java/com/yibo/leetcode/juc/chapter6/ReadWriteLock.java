package com.yibo.leetcode.juc.chapter6;

public class ReadWriteLock {
    private int readingReaders = 0;
    private int waitingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private final boolean preferWriter;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public synchronized void readLock() {
        waitingReaders++;
        try {
            while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
                this.wait();
            }
            //System.out.println("reading");
            readingReaders++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            waitingReaders--;
        }
    }

    public synchronized void readUnlock() {
        readingReaders--;
        //System.out.println("read over");
        notifyAll();
    }

    public synchronized void writeLock() {
        waitingReaders++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
            //System.out.println("writing");
            writingWriters++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            waitingWriters--;
        }
    }

    public synchronized void writeUnlock() {
        writingWriters--;
        //System.out.println("write over");
        notifyAll();
    }
}
