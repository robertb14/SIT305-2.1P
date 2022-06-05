//Robert Bajan 03/04/22
package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Declaring Widgets
    EditText editTextNumber;
    TextView textView2, output1, output2, output3;
    Button button, button2, button3;
    Spinner spinnerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiating Widgets
        textView2 = findViewById(R.id.textView2);
        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);

        editTextNumber = findViewById(R.id.editTextNumber);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        spinnerMenu = findViewById(R.id.spinnerMenu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMenu.setAdapter(adapter);
        spinnerMenu.setOnItemSelectedListener(this);

        // On click event
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ConvertFromKiloToPound();
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ConvertFromKiloToGram();
//            }
//        });
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ConvertFromKiloToOunce();
//            }
//        });
    }
    // Unit calculation functions
    private void ConvertDistance() {
        String valueEnteredKilo = editTextNumber.getText().toString();

        double metre = Double.parseDouble(valueEnteredKilo);
        String centi = String.format("%.2f", metre * 100);
        String feet = String.format("%.2f", metre * 3.281);
        String inch = String.format("%.2f", metre * 39.37);

        output1.setText("" + centi + " cm");
        output2.setText("" + feet + " ft");
        output3.setText("" + inch + " in");
    }
    private void ConvertTemp() {
        String valueEnteredKilo = editTextNumber.getText().toString();

        double celsius = Double.parseDouble(valueEnteredKilo);
        String fahrenheit = String.format("%.2f", (celsius * (9 / 5)) + 32);
        String kelvin = String.format("%.2f", celsius + 273.15);

        output1.setText("" + fahrenheit + " °F");
        output2.setText("" + kelvin + " K");
        output3.setText("");
    }
    private void ConvertWeight() {
        String valueEnteredKilo = editTextNumber.getText().toString();

        double kilo = Double.parseDouble(valueEnteredKilo);
        String pound = String.format("%.2f", kilo * 2.205);
        String gram = String.format("%.2f", kilo * 1000);
        String ounce = String.format("%.2f", kilo * 35.274);

        output1.setText("" + pound + " lbs");
        output2.setText("" + gram + " g");
        output3.setText("" + ounce + " oz");
    }

    //Spinner on select event, inc button on click events
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( adapterView.getItemAtPosition(i) == adapterView.getItemAtPosition(0)){
                    ConvertDistance();
                }
                else{
                    Toast.makeText(adapterView.getContext(), "Please Select The Correct Button!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( adapterView.getItemAtPosition(i) == adapterView.getItemAtPosition(1)){
                    ConvertTemp();
                }
                else{
                    Toast.makeText(adapterView.getContext(), "Please Select The Correct Button!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( adapterView.getItemAtPosition(i) == adapterView.getItemAtPosition(2)){
                    ConvertWeight();
                }
                else{
                    Toast.makeText(adapterView.getContext(), "Please Select The Correct Button!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}