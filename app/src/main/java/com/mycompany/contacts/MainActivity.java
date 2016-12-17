package com.mycompany.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  final int PICK_CONTACT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callcontacts(View view) {

        Intent i =new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i,PICK_CONTACT);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICK_CONTACT) {

            if(resultCode==RESULT_OK){
                Uri contactData=data.getData();
                Cursor c=getContentResolver().query(contactData,null,null,null,null);

                if(c.moveToNext())
                {
                    String name= c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                    Toast.makeText(this, "You have picked:"+name,Toast.LENGTH_LONG).show();
                }
            }

        }
        }

    }

