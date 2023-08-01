package com.example.adanionerai;

import java.util.ArrayList;

public class TravellersDetailsList {
    ArrayList<Integer> AdultsCounts ;
    ArrayList<Integer> childrenCounts;
    ArrayList<Integer> infantsCounts;

    public TravellersDetailsList(ArrayList<Integer> adultsCounts, ArrayList<Integer> childrenCounts, ArrayList<Integer> infantsCounts) {
        AdultsCounts = adultsCounts;
        this.childrenCounts = childrenCounts;
        this.infantsCounts = infantsCounts;
    }
}
