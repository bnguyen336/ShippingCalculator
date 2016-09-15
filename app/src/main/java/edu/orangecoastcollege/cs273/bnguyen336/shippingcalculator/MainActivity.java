package edu.orangecoastcollege.cs273.bnguyen336.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private TextView weightTextView;
    private TextView addedCostTextView;
    private TextView totalTextView;
    private TextView baseCostTextView;

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    ShipItem currentItem = new ShipItem(3.0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        addedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        baseCostTextView = (TextView) findViewById(R.id.baseCostTextView);

        baseCostTextView.setText(currency.format(currentItem.getBaseCost()));
        weightEditText.requestFocus();

        weightEditText.addTextChangedListener(weightTextChangeListener);
    }

    private TextWatcher weightTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //Do nothing
        }

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
                weightTextView.setText(charSequence.toString() + " + " + charSequence.length());
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
