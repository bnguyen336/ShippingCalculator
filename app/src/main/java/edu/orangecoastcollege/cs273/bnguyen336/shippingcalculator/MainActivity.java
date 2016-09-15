package edu.orangecoastcollege.cs273.bnguyen336.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Nguyen, Benjamin
 * CS273
 *
 * MainAcvitivy class runs on app starts
 */
public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private TextView weightTextView;
    private TextView addedCostTextView;
    private TextView totalTextView;
    private TextView baseCostTextView;

    /**
     * Format output as currency depended on local
     */
    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**
     * Create new object ShipItem with Base Cost of 3.0
     */
    ShipItem currentItem = new ShipItem(3.0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Reference all instance variables with corresponding
         * layout components through ids
         */
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        addedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        baseCostTextView = (TextView) findViewById(R.id.baseCostTextView);

        /**
         * Format Base Cost as currency for output
         * and automatically focus on weightEditText when the app starts
         */
        baseCostTextView.setText(currency.format(currentItem.getBaseCost()));
        weightEditText.requestFocus();
        weightEditText.addTextChangedListener(weightTextChangeListener);
    }

    /**
     * Detect change in user's input
     */
    private TextWatcher weightTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //Do nothing
        }

        /**
         * Calculate and output changes to all variables as user is typing
         * Check if input CharSequence is deleted back to empty; if so, weight
         * is set to 0
         * @param charSequence
         * @param i
         * @param i1
         * @param i2
         */
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                int weightInOunces;
                if (charSequence.length() < 1) {
                    weightInOunces = 0;
                } else {
                    weightInOunces = Integer.parseInt(charSequence.toString());
                }
                currentItem.setWeight(weightInOunces);
                weightTextView.setText(Integer.toString(currentItem.getWeight()));
                addedCostTextView.setText(currency.format(currentItem.getAddedCost()));
                totalTextView.setText(currency.format(currentItem.getTotalCost()));
            } catch (NumberFormatException e) {
                weightTextView.setText("0");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            //Do nothing
        }
    };
}
