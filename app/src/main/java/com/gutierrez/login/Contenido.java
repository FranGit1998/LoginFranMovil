package com.gutierrez.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Contenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            Intent intent = new Intent(Contenido.this, Formulario.class);
            startActivity(intent);
        } else if (id == R.id.action_save) {
            displayToast(getString(R.string.Save));
        } else if (id == R.id.action_contact) {
            displayToast(getString(R.string.ContactDesple));
        } else if (id == R.id.action_settings) {
        displayToast(getString(R.string.AjustesMensaje));
    }
        return super.onOptionsItemSelected(item);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(Contenido.this);
        myAlertBuilder.setTitle(getString(R.string.titulo));
        myAlertBuilder.setMessage(getString(R.string.mensajeAlert));

        myAlertBuilder.setPositiveButton(getString(R.string.OK), new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), getString(R.string.PressOk),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.setNegativeButton(getString(R.string.Cancelar), new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), getString(R.string.PressCancel),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.show();
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}
