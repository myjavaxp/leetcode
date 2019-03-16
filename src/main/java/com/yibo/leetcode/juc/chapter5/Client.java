package com.yibo.leetcode.juc.chapter5;

public class Client {
    public static void main(String[] args) {
        Gate gate=new Gate();
        User bj=new User(gate,"beijing","baobao");
        User sh=new User(gate,"shanghai","shang");
        User gz=new User(gate,"guangzhou","guang");
        bj.start();
        sh.start();
        gz.start();
    }
}