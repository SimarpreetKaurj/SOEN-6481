package com.tvm;

import java.util.HashMap;

public class Ticket {
    private HashMap<String, Double> tariffs = new HashMap<>();

    public Ticket() {
        tariffs.put("1 Trip", 3.50);
        tariffs.put("2 Trips", 6.50);
        tariffs.put("Unlimited Evening", 5.50);
        tariffs.put("Unlimited Weekend", 14.00);
        tariffs.put("1 Day", 10.00);
        tariffs.put("3 Days", 19.50);
        tariffs.put("Group", 17.50);
    }

    public HashMap<String, Double> getTariffs() {
        return tariffs;
    }

    public void setTariffs(HashMap<String, Double> tariffs) {
        this.tariffs = tariffs;
    }
}
