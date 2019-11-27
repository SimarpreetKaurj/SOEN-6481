package com.tvm;

import java.util.ArrayList;

public class Receipt {
    ArrayList<String> types;

    public Receipt() {
        types = new ArrayList<>();

        types.add("Paper");
        types.add("Email");
    }

    public ArrayList<String> getTypes() {
        return types;
    }
}
