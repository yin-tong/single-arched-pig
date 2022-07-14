package com.homework.memo_mode;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Memo memo = new Memo();
        memo.setFirstName("123");

        MemoManager memoManager = new MemoManager();
        memoManager.save(memo);

        Memo memo1 = memoManager.read();

        System.out.println(memo1.getFirstName());

    }
}
