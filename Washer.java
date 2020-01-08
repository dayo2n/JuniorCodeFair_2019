package doldol;

import java.util.*;

public class Washer {

    private Integer building;
    private Integer numWasher;
    private Boolean flag = false;// 디폴트값 사용하지않는 상태

    public Washer(Integer building, Integer numWasher, Boolean flag) {
        this.building = building;
        this.numWasher = numWasher;
        this.flag = flag;
    }

    public int getNumWasher() {
        return numWasher;
    }

    public boolean getFlag() {
        return flag;
    }
}
