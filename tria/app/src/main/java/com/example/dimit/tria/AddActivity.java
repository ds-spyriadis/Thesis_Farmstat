package com.example.dimit.tria;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.solver.widgets.Helper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {


    ContactDbHelper mydb;
    EditText Tel,Name,Region,Etos;
    TextView text1 ;
    Button bn,bn2,bn3,bn4;
    int FLAG,flagadd=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        mydb = new ContactDbHelper(this);

        //  text1= (TextView)findViewById(R.id.textView1);

        Tel = (EditText) findViewById(R.id.txt_tel);
        Name = (EditText) findViewById(R.id.txt_name);
        Region = (EditText) findViewById(R.id.txt_region);
        Etos = (EditText) findViewById(R.id.txt_year);

        bn = (Button) findViewById(R.id.bn_save);
        bn2 = (Button) findViewById(R.id.bn_basic);
        bn3 = (Button) findViewById(R.id.bn_economic);
        bn4 = (Button) findViewById(R.id.bn_clear);

        AddDatta();










            bn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent basic = new Intent(AddActivity.this, BasicActivity.class);
                    if (flagadd == 1) {

                        startActivity(basic);
                        }
                        else {
                        Toast.makeText(getApplication(), "first please add the values and pres save", Toast.LENGTH_SHORT).show();
                    }


                }
            });


            bn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent finance = new Intent(AddActivity.this, FinanceActivity.class);
                    if (flagadd == 1) {

                        startActivity(finance);
                    }
                    else {
                        Toast.makeText(getApplication(), "first please add the values and pres save", Toast.LENGTH_SHORT).show();
                    }







                }
            });


        }



    public  void  AddDatta(){

        bn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tel.setText("");
                Name.setText("");
                Region.setText("");
                Etos.setText("");


            }
        });



        bn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String tel = Tel.getText().toString();
                        String name = Name.getText().toString();
                        String region = Region.getText().toString();
                        String etos = Etos.getText().toString();

                        searchthenumber(tel,etos);



                        if(Tel.getText().toString().isEmpty()|| Etos.getText().toString().isEmpty() || Name.getText().toString().isEmpty() || Region.getText().toString().isEmpty())
                        {
                            Toast.makeText(getApplication(),"please add the values...",Toast.LENGTH_SHORT).show();

                        }else if((Etos.getText().toString().length()>4)||(Etos.getText().toString().length()<4)){

                                Toast.makeText(getApplication()," Please Add Correct Year ...",Toast.LENGTH_SHORT).show();
                        } else if((Tel.getText().toString().length()>10)||(Tel.getText().toString().length()<10)){

                            Toast.makeText(getApplication()," Please Add Correct Tel.Number ...",Toast.LENGTH_SHORT).show();
                        }else if (FLAG==1){

                            Toast.makeText(getApplication(),"The contact is registered...",Toast.LENGTH_SHORT).show();
                        }
                        else {


                            mydb.addContact(tel, Integer.parseInt(etos), name, region);
                            Toast.makeText(getApplication(),"Save...",Toast.LENGTH_SHORT).show();


                            flagadd=1;




                        }
                        }
                    }

        );

    }

















    public void  searchthenumber(String tel, String year)
    {

        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.idContacts(database);

        FLAG=0;


        while (cursor.moveToNext())


        {
            String datatel = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TEL));
            String datayear = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));

            // region = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.REGION));
            if (tel.equals(datatel)&& year.equals(datayear))
            { FLAG=1;}



        }











        contactDbHelper.close();


    }






























    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("FLAGADD",flagadd);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        flagadd = savedInstanceState.getInt("FLAGADD");


        }

    }















