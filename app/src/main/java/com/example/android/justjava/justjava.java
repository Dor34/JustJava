package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;


public class justjava extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_justjava);

    }

    public void increment(View view){
        quantity = quantity + 1;
        display (quantity);
        displayPrice (quantity * 5);
    }
    public void decrement(View view){
        quantity = quantity - 1;
        display (quantity);
        displayPrice (quantity * 5);
    }
    public void submitOrder(View view){
        String priceMessage = "Total: $ " + (quantity *5);
        priceMessage = priceMessage + " \nThank You!";
        displayMessage (priceMessage);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById (R.id.quantity_text_view);
        quantityTextView.setText ("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
