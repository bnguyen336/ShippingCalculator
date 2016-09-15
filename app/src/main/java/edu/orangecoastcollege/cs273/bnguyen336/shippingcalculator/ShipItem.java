package edu.orangecoastcollege.cs273.bnguyen336.shippingcalculator;

/**
 * Nguyen, Benjamin
 * CS273
 *
 * This class contains the logic for all cost calculations
 * in this project
 */
public class ShipItem {
    /**
     * All necessary instance variables
     * mBaseCost is all so declared to dynamically
     * change Base Cost
     */
    private int mWeight;
    private double mAddedCost;
    private double mTotalCost;
    private double mBaseCost;

    /**
     * Default constructor
     */
    public ShipItem() {
        mWeight = 0;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
        mBaseCost = 3.0;
    }

    /**
     * Constructor with Base Cost as input
     * @param baseCost
     */
    public ShipItem(double baseCost) {
        this.mBaseCost = baseCost;
        recalculateCost();
    }

    /**
     * Set weight of the object and recalculate costs
     * @param weight
     */
    public void setWeight(int weight) {
        mWeight = weight;
        recalculateCost();
    }

    /**
     * Get weight of the current object
     * @return mWeight
     */
    public int getWeight() {
        return mWeight;
    }

    /**
     * Get Base Cost of the current object
     * @return mBaseCost
     */
    public double getBaseCost() {
        return mBaseCost;
    }

    /**
     * Get Added Cost of the current object
     * @return mAddedCost
     */
    public double getAddedCost() {
        return mAddedCost;
    }

    /**
     * Get Total Cost of the current object
     * @return mTotalCost
     */
    public double getTotalCost() {
        return mTotalCost;
    }

    /**
     * If weight exceeds 16 ounces, then Added Cost is calculated
     * else Added Cost remains 0
     * then it calculates Total Cost
     */
    private void recalculateCost() {
        if (mWeight > 16) {
            mAddedCost = (((mWeight - 17) / 4) + 1) * 0.5;
        } else {
            mAddedCost = 0.0;
        }
        mTotalCost = mBaseCost + mAddedCost;
    }
}
