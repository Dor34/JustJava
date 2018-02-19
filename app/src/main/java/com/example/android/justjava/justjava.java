package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

//import static com.example.android.justjava.R.id.caramel_checkbox;


public class justjava extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_justjava);

    }

    public void increment(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = findViewById (R.id.quantity_text_view);
        displayQuantity (quantity);

    }

    public void decrement(View view) {
        quantity = quantity - 1;
        TextView quantityTextView = findViewById (R.id.quantity_text_view);
        displayQuantity (quantity);

    }

    /**
     * This method is called when the order button is clicked.
     * @param price
     */
    public void submitOrder(int price) {
        CheckBox whippedCreamCheckbox = findViewById (R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked ();
        CheckBox caramelCheckbox = findViewById (R.id.caramel_checkbox);
        boolean hasCaramel = caramelCheckbox.isChecked ();
        TextView priceTextView = findViewById (R.id.order_summary_text_view);
        String priceMessage = "Hello Dorian \nYour total for \n" + quantity;
        priceMessage += " cup(s) of coffee is $" + calculatePrice ();
        priceMessage += " \nWith Whipped Cream";
        priceMessage += " \nWith Caramel";
        priceMessage += "\n Thank you!";
        priceTextView.setText (priceMessage);

    }

    /**
     * Calculates the price of the order.
     *
     * @ return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById (R.id.quantity_text_view);
        quantityTextView.setText (String.format ("%d", number));
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById (R.id.order_summary_text_view);
        orderSummaryTextView.setText (message);
    }

    public void onCheckboxClicked(View view) {
        // Check which checkbox was clicked
        CheckBox checkBox = (CheckBox)view;
        //code to check if this checkbox is checked!
        if(checkBox.isChecked()){
            String addWhippedCream = "true";
        } else {
            String addWhippedCream = "false";

        if(checkBox.isChecked()){
            String addCaramel = "true";
        }else {
            String addCaramel = "false";
        }
        }
    }
}