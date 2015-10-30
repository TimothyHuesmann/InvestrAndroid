package com.example.timothyhuesmann.investrandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterVC extends ActionBarActivity {

    Button registerButton_registerVC;
    EditText usernameTF_register_VC;
    EditText emailTF_registerVC;
    EditText phoneTF_registerVC;
    EditText passwordTF_registerVC;
    EditText confPasswordTF_registerVC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_vc);
        addListenerOnButton();
    }

    public void addListenerOnButton()
    {
        registerButton_registerVC = (Button) findViewById(R.id.registerButton);
        usernameTF_register_VC = (EditText) findViewById(R.id.usernameTF_registerVC);
        emailTF_registerVC = (EditText) findViewById(R.id.emailTF_registerVC);
        phoneTF_registerVC = (EditText) findViewById(R.id.phoneTF_registerVC);
        passwordTF_registerVC = (EditText) findViewById(R.id.passwordTF_registerVC);
        confPasswordTF_registerVC = (EditText) findViewById(R.id.confirmPasswordTF_registerVC);
        registerButton_registerVC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(usernameTF_register_VC.getText() == null||emailTF_registerVC.getText()==null||phoneTF_registerVC.getText()==null||passwordTF_registerVC.getText()==null||confPasswordTF_registerVC.getText()==null)
                {

                }
                else if(confPasswordTF_registerVC.getText().toString() != passwordTF_registerVC.getText().toString())
                {

                }
                else
                {
                    ParseUser user = new ParseUser();
                    user.setUsername(usernameTF_register_VC.getText().toString());
                    user.setEmail(emailTF_registerVC.getText().toString());
                    user.setPassword(passwordTF_registerVC.getText().toString());
                    user.put("phone", phoneTF_registerVC.getText().toString());
                    user.signUpInBackground(new SignUpCallback()
                    {
                        @Override
                        public void done(ParseException e)
                        {
                            if(e == null)
                            {
                                //registration successful
                                new AlertDialog.Builder(RegisterVC.this)
                                    .setMessage("Registration Successful")
                                    .setNeutralButton("OK",new DialogInterface.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which)
                                        {

                                        }
                                    })
                                    .show();
                            }
                            else
                            {
                                //there is an error
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_vc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
}
