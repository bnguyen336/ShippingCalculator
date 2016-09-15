package edu.orangecoastcollege.cs273.bnguyen336.shippingcalculator;

/**
 * Created by binhn on 9/14/2016.
 */
public class ShipItem {
    private int mWeight;
    private double mAddedCost;
    private double mTotalCost;
    private double mBaseCost;

    public ShipItem() {
        mWeight = 0;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
        mBaseCost = 3.0;
    }

    public ShipItem(double baseCost) {
        this.mBaseCost = baseCost;
        recalculateCost();
    }

    public void setWeight(int weight) {
        mWeight = weight;
        recalculateCost();
    }

    public double getBaseCost() {
        return mBaseCost;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    private void recalculateCost() {
        if (mWeight > 16) {
            mAddedCost = (((mWeight - 17) / 4) + 1) * 0.25;
        }
        mTotalCost = mBaseCost + mAddedCost;
    }
}
