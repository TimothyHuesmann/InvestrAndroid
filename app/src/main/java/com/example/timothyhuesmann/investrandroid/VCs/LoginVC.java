package com.example.timothyhuesmann.investrandroid.VCs;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.content.Context;
import android.widget.EditText;

import com.example.timothyhuesmann.investrandroid.InvestrCore;
import com.example.timothyhuesmann.investrandroid.R;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;


public class LoginVC extends ActionBarActivity
{

    Button loginButton;
    EditText usernameTF_LoginVC;
    EditText passwordTF_LoginVC;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vc);
        addListenerOnButtons();
    }

    public void addListenerOnButtons()
    {
        final Context context = this;
        loginButton = (Button) findViewById(R.id.loginButton);
        usernameTF_LoginVC = (EditText) findViewById(R.id.usernameTF_LoginVC);
        passwordTF_LoginVC = (EditText) findViewById(R.id.passwordTF_LoginVC);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                ParseUser.logInInBackground(usernameTF_LoginVC.getText().toString(), passwordTF_LoginVC.getText().toString(), new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null)
                        {
                            //Success
                            InvestrCore.currUser = usernameTF_LoginVC.getText().toString();
                            ParseQuery<ParseUser> query = ParseUser.getQuery();
                            query.whereEqualTo("username", InvestrCore.currUser);
                            query.findInBackground(new FindCallback<ParseUser>()
                            {
                                @Override
                                public void done(List<ParseUser> objects, ParseException e)
                                {
                                    if (e == null)
                                    {
                                        InvestrCore.userID = objects.get(0).getObjectId();
                                    } else
                                    {

                                    }
                                }
                            });
                            loginSuccess();

                        }
                        else
                        {
                            //Error
                        }
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_vc, menu);
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
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loginSuccess()
    {
        Intent i = new Intent(getApplicationContext(), MenuVC.class);
        startActivity(i);
    }
}
