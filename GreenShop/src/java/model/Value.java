/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Value {
    private String name;
    private int num;

    public Value(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Value() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    

public int findElement(String name, ArrayList<Value> val) {
 
    for (int i=0;i<val.size();i++) {
        if (val.get(i).getName().equals(name)) {
            return i;
        }
    }
    return 10000;
}
}
