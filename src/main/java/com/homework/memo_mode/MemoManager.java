package com.homework.memo_mode;

import java.io.*;

public class MemoManager {

    static String path = "resources";

    public void save(Memo memo) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path+"game.bat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(memo);
    }

    public Memo read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path+"game.bat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Memo) objectInputStream.readObject();
    }
}
