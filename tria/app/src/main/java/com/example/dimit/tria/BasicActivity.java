package com.example.dimit.tria;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Year;

public class BasicActivity extends AppCompatActivity {


    ContactDbHelper mydb1;
    EditText Age,Animal,Sheep,Goat,Milking,Licensing,Electrification,Tractor,Sheepmilk,Goatmilk,Prevision,Comments;
    TextView text1 ;
    Button bn,bn2,bn3;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);




        mydb1 = new ContactDbHelper(this);

        text1= (TextView)findViewById(R.id.basic_text);

        Age = (EditText)findViewById(R.id.txt_age);
        Animal= (EditText)findViewById(R.id.txt_animal);
        Sheep= (EditText)findViewById(R.id.txt_sheep);
        Goat= (EditText)findViewById(R.id.txt_goat);
        Milking= (EditText)findViewById(R.id.txt_milking);
        Licensing= (EditText)findViewById(R.id.txt_licensing);

        Electrification= (EditText)findViewById(R.id.txt_electrification);

        Tractor= (EditText)findViewById(R.id.txt_tractor);

        Sheepmilk= (EditText)findViewById(R.id.txt_sheepmilk);

        Goatmilk= (EditText)findViewById(R.id.txt_goatmilk);

       // Prevision= (EditText)findViewById(R.id.txt_prevision);

        Comments= (EditText)findViewById(R.id.txt_comment);




        bn = (Button)findViewById(R.id.bn_save1);
        update();
        idContacts();
    }



    public  void  update(){

        bn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String age = Age.getText().toString();
                        String animal = Animal.getText().toString();
                        String sheep = Sheep.getText().toString();
                        String goat = Goat.getText().toString();

                        String milking = Milking.getText().toString();
                        String licensing = Licensing.getText().toString();
                        String electrification = Electrification.getText().toString();
                        String tractor = Tractor.getText().toString();
                        String sheepmilk =Sheepmilk.getText().toString();
                        String goatmilk =Goatmilk.getText().toString();
                       // String prevision =Prevision.getText().toString();
                        String comments =Comments.getText().toString();



                        if(Comments.getText().toString().isEmpty())
                        {
                            Comments.setText(" ");


                        }


                        if(Sheep.getText().toString().isEmpty() || Age.getText().toString().isEmpty() ||
                                Animal.getText().toString().isEmpty() || Goat.getText().toString().isEmpty() ||
                                Milking.getText().toString().isEmpty() || Licensing.getText().toString().isEmpty() ||
                                Electrification.getText().toString().isEmpty() || Tractor.getText().toString().isEmpty() ||
                                Sheepmilk.getText().toString().isEmpty() || Goatmilk.getText().toString().isEmpty() )
                        {
                            Toast.makeText(getApplication(),"please add the values...",Toast.LENGTH_SHORT).show();

                        }
                        else {

                            mydb1.addbasic(Integer.parseInt(age),Integer.parseInt(animal),Integer.parseInt(sheep),Integer.parseInt(goat),
                                    milking,licensing,electrification,tractor,Integer.parseInt(sheepmilk),Integer.parseInt(goatmilk),
                                    comments,id);

                            Toast.makeText(getApplication(),"Save...",Toast.LENGTH_SHORT).show();


                        }
                    }
                }
        );

    }




    /////////////////////////
    private  void idContacts()
    {
        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.idContacts(database);



        while (cursor.moveToNext())


        {
            id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContact.ContactEntry.ID)));
           // region = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.REGION));
        }



        contactDbHelper.close();
    }







}
