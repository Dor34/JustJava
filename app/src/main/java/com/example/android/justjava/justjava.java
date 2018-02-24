package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

//import static com.example.android.justjava.R.id.caramel_checkbox;


public class justjava extends AppCompatActivity {
    int quantity = 0;
    CheckBox whippedCreamCheckbox;
    CheckBox caramelCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_justjava);
        whippedCreamCheckbox = findViewById (R.id.whipped_cream_checkbox);
        caramelCheckbox = findViewById (R.id.caramel_checkbox);

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
     */
    public void submitOrder(View view) {
        EditText nameField = findViewById(R.id.name_field);
        nameField.getText ().toString ();
            boolean hasWhippedCream = whippedCreamCheckbox.isChecked ();
            boolean hasCaramel = caramelCheckbox.isChecked ();
            TextView priceTextView = findViewById (R.id.order_summary_text_view);
            String priceMessage = ("Hello:  " + nameField.getText ());
            priceMessage += " \nYour total for \n" + quantity;
            priceMessage += " cup(s) of coffee is $" + calculatePrice();
            priceMessage += " \n With Whipped Cream? " +  hasWhippedCream;
            priceMessage += " \n With Caramel? " +  hasCaramel;
            priceMessage += " \n Thank you!";
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


}