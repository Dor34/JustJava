package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import static com.example.android.justjava.R.id.caramel_checkbox;


public class justjava extends AppCompatActivity {
    int quantity = 0;
    int basePrice = 5;
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
        if (quantity == 100) {
            //Show error message as a toast
            Toast.makeText (this, "You can not have more than 100 cups of coffee!", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        TextView quantityTextView = findViewById (R.id.quantity_text_view);
        displayQuantity (quantity);

    }

    public void decrement(View view) {
        if (quantity == 1) {
            //Show error message as a toast
            Toast.makeText (this, "You can not have less than 1 cup of coffee!", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        TextView quantityTextView = findViewById (R.id.quantity_text_view);
        displayQuantity (quantity);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = findViewById (R.id.name_field);
        nameField.getText ().toString ();
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked ();
        boolean hasCaramel = caramelCheckbox.isChecked ();
        String priceMessage = ("Hello:  " + nameField.getText ());
        priceMessage += " \nYour total for \n" + quantity;
        priceMessage += " cup(s) of coffee is $" + calculatePrice (hasWhippedCream, hasCaramel);
        priceMessage += " \n With Whipped Cream? " + hasWhippedCream;
        priceMessage += " \n With Caramel? " + hasCaramel;
        priceMessage += " \n Thank you!";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order ");
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * Calculates the price of the order.
     * @param hasWhippedCream if person has this topping or not
     * @param hasCaramel if this person has this topping or not
     * @return total price
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasCaramel) {
        //Price for a cup of coffee
        basePrice = 5;
        //Add $1 for whipped cream
        if (hasWhippedCream) {
            basePrice = basePrice + 1;
        }
        //Add $2 for caramel
        if (hasCaramel) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById (R.id.quantity_text_view);
        quantityTextView.setText (String.format (String.valueOf (number)));
    }

}