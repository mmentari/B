package org.aplas.basicappx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Distance dist = new Distance();
    private Weight weight = new  Weight();
    private Temperature temp = new Temperature();
    private Button convertBtn;
    private EditText inputTxt;
    private EditText outputTxt;
    private Spinner unitOri;
    private Spinner unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox;
    private CheckBox formBox;
    private ImageView imgView;

    //private ArrayAdapter adapter = null;

    private ImageView imgView2;

    private AlertDialog startDialog;

    protected double convertUnit(String a, String b, String c, double d) {
        if (("Temperature".equals(a)) && (("°F").equals(b)) && ("K").equals(c)) {
            return temp.convert("°F", "K", d);
        } else if (("Temperature".equals(a)) && (("K").equals(b)) && ("°C").equals(c)) {
            return temp.convert("K", "°C", d);
        } else if (("Distance".equals(a)) && (("Mtr").equals(b)) && ("Mil").equals(c)) {
            return dist.convert("Mtr", "Mil", d);
        } else if (("Distance".equals(a)) && (("Mil").equals(b)) && ("Ft").equals(c)) {
            return dist.convert("Mil", "Ft", d);
        }else if (("Distance".equals(a)) && (("Inc").equals(b)) && ("Mtr").equals(c)) {
            return dist.convert("Inc", "Mtr", d);
        }else if (("Weight".equals(a)) && (("Grm").equals(b)) && ("Pnd").equals(c)) {
            return weight.convert("Grm", "Pnd", d);
        }else if (("Weight".equals(a)) && (("Pnd").equals(b)) && ("Onc").equals(c)) {
            return weight.convert("Pnd", "Onc", d);
        }else{
            return 0;
        }
    }

    protected String strResult(double value, boolean b){

        DecimalFormat digit = new DecimalFormat("#.#####");
        DecimalFormat digit1 = new DecimalFormat("#.##");

        if (b != true){
            return digit.format(value);
        }
        return digit1.format(value);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertBtn = (Button)findViewById(R.id.convertButton);
        inputTxt = (EditText)findViewById(R.id.inputText);
        outputTxt = (EditText)findViewById(R.id.outputText);
        unitOri = (Spinner)findViewById(R.id.oriList);
        unitConv = (Spinner)findViewById(R.id.convList);
        unitType = (RadioGroup)findViewById(R.id.radioGroup);
        roundBox = (CheckBox)findViewById(R.id.chkRounded);
        formBox = (CheckBox)findViewById(R.id.chkFormula);
        imgView = (ImageView)findViewById(R.id.img);
        imgView2 = (ImageView)findViewById(R.id.imgFormula);

        unitType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton t = (RadioButton) findViewById(R.id.rbTemp);
                RadioButton d = (RadioButton)findViewById(R.id.rbDist);
                RadioButton w = (RadioButton)findViewById(R.id.rbWeight);

                inputTxt.setText("0");
                outputTxt.setText("0");


                ArrayAdapter<CharSequence> distAdapter ;
                ArrayAdapter<CharSequence> tempAdapter ;
                ArrayAdapter<CharSequence> weightAdapter;

                if (t.isChecked()){
                    tempAdapter = ArrayAdapter.createFromResource(unitType.getContext(),R.array.tempList, android.R.layout.simple_spinner_item);
                    imgView.setImageResource(R.drawable.temperature);
                    tempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    unitOri.setAdapter(tempAdapter);
                    unitConv.setAdapter(tempAdapter);
                }
                if (d.isChecked()){
                    distAdapter = ArrayAdapter.createFromResource(unitType.getContext(),R.array.distList, android.R.layout.simple_spinner_item);
                    imgView.setImageResource(R.drawable.distance);
                    distAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    unitOri.setAdapter(distAdapter);
                    unitConv.setAdapter(distAdapter);
                }
                if (w.isChecked()){
                    weightAdapter = ArrayAdapter.createFromResource(unitType.getContext(),R.array.weightList, android.R.layout.simple_spinner_item);
                    imgView.setImageResource(R.drawable.weight);
                    weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    unitOri.setAdapter(weightAdapter);
                    unitConv.setAdapter(weightAdapter);
                }


            }
        });

        convertBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                doConvert();
            }
        });

        unitOri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                doConvert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        unitConv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                doConvert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        roundBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doConvert();
            }
        });

        formBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (formBox.isChecked()) {
                    imgView2.setVisibility(View.VISIBLE);
                } else {
                    imgView2.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        startDialog = new AlertDialog.Builder(MainActivity.this).create();
        startDialog.setTitle("Appliaction Stated");
        startDialog.setMessage("This app can use to convert any units");
        startDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        startDialog.show();
    }

    protected void doConvert(){

        RadioButton t = (RadioButton)findViewById(unitType.getCheckedRadioButtonId());
        RadioButton d = (RadioButton)findViewById(unitType.getCheckedRadioButtonId());
        RadioButton w = (RadioButton)findViewById(unitType.getCheckedRadioButtonId());

        //((RadioButton)unitType.getChildAt(1)).setChecked(true);

        String x = inputTxt.getText().toString();

        double y = Double.parseDouble(x);

        String a ;
        double value;

        if (t.isChecked()){
            value = convertUnit("Temperature", unitOri.getSelectedItem().toString(),unitConv.getSelectedItem().toString(),y);
            if (roundBox.isChecked()){
                a = strResult(value, true);
                outputTxt.setText(a);
            }else{
                a = strResult(value,false);
                outputTxt.setText(a);
            }
        }else if (d.isChecked()){
            value = convertUnit("Distance", unitOri.getSelectedItem().toString(),unitConv.getSelectedItem().toString(),y);
            if (roundBox.isChecked()){
                a = strResult(value, true);
                outputTxt.setText(a);
            }else{
                a = strResult(value,false);
                outputTxt.setText(a);
            }
        }else if (w.isChecked()){
            value = convertUnit("Weight", unitOri.getSelectedItem().toString(),unitConv.getSelectedItem().toString(),y);
            if (roundBox.isChecked()){
                a = strResult(value, true);
                outputTxt.setText(a);
            }else{
                a = strResult(value,false);
                outputTxt.setText(a);
            }
        }else{

        }
    }
}