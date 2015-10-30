package com.example.timothyhuesmann.investrandroid.VCs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.timothyhuesmann.investrandroid.R;
import com.parse.Parse;

public class MainVC extends ActionBarActivity
{
    Button loginButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vc);
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "FqNt8xkKnxeEdBqV5te9vJAOQQ7dRNsO69Bqno9y", "OQRXEt1TPmN8k9lDG4mWSYGQH7fWSNQf5F2mjhED");
        addListenerOnButtons();
    }

    public void addListenerOnButtons()
    {
        final Context context = this;
        loginButton = (Button) findViewById(R.id.loginPageButton);
        registerButton = (Button) findViewById(R.id.registerPageButton);

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loginButtonPressed();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                registerButtonPressed();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_vc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loginButtonPressed()
    {
        Intent i = new Intent(getApplicationContext(), LoginVC.class);
        startActivity(i);
    }

    public void registerButtonPressed()
    {
        Intent i = new Intent(getApplicationContext(), RegisterVC.class);
        startActivity(i);
    }
}
