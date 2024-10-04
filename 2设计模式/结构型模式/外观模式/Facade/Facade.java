package com.EthanYankang.结构型模式.外观模式.Facade;

import com.EthanYankang.结构型模式.外观模式.SubSystem.CipherMachine;
import com.EthanYankang.结构型模式.外观模式.SubSystem.FileReader;
import com.EthanYankang.结构型模式.外观模式.SubSystem.FileWriter;

import java.io.IOException;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-18 11:23
 **/

//外观模式的外观类(多个子系统的统一接口)

public class Facade {
    private CipherMachine cipherMachine;
    private FileReader fileReader;
    private FileWriter fileWriter;

    public Facade(FileWriter fileWriter, CipherMachine cipherMachine, FileReader fileReader) {
        this.fileWriter = fileWriter;
        this.cipherMachine = cipherMachine;
        this.fileReader = fileReader;
    }

    public Facade() {
        this.fileReader = new FileReader() ;
        this.fileWriter = new FileWriter();
        this.cipherMachine = new CipherMachine();
    }

    public String fileEncode(String path)throws IOException{
        String stringBefore = fileReader.readFile(path);
        String encode = cipherMachine.encode(stringBefore);
        String stringAfter = fileWriter.writeFile(encode);
        return stringAfter;
    }
}
