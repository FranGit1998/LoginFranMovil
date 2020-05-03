package com.gutierrez.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner  spinner;
    Boolean estado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinnerUser);

        String[] op = {"Empresario", "Estudiante", "Otro"};

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, op);
        spinner.setAdapter(adap);
        SpinnerToast();
    }

    public void SpinnerToast() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(estado == true){
                    String seleccion = spinner.getSelectedItem().toString();
                    Toast.makeText(getApplicationContext(),seleccion,Toast.LENGTH_SHORT).show();
                }else{
                    estado=true;
                }

            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            } });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.RHombre:
                if (checked)
                    displayToast(getString(R.string.MensajeHombre));
                break;
            case R.id.RMujer:
                if (checked)
                    displayToast(getString(R.string.MensajeMujer));
                break;
            default:
                break;
        }
    }

    public void onClick(View view) {
        displayToast(getString(R.string.EnterCreate));
            Intent intent = new Intent(MainActivity.this, Contenido.class);
            startActivity(intent);

    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}
