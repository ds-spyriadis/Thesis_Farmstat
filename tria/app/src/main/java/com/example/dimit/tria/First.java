package com.example.dimit.tria;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class First extends AppCompatActivity {




    ImageView update, add, read, Edit, Book;

    TextView Txt_Display;
    EditText editText;
    String newtel="0",newname="0";

    int flagpop =0;

    int flag=0;  // gia na mhn emfanizei ta idia onomata

    int A = 0, B = 0, C = 0, D = 0, E = 0;
    int F = 0, G = 0, H = 0, I = 0, J = 0, K = 0, L = 0, M = 0;
    int N = 0, O = 0, P = 0, Q = 0, RR = 0, S = 0, T = 0, U = 0, V = 0, W = 0, X = 0, Y = 0, Z = 0;

    int A1 = 0, B1 = 0, C1 = 0, D1 = 0, E1 = 0;
    int F1 = 0, G1= 0, H1 = 0, I1 = 0, J1 = 0, K1 = 0, L1 = 0, M1 = 0;
    int N1 = 0, O1 = 0, P1 = 0, Q1 = 0, RR1 = 0, S1 = 0, T1 = 0, U1 = 0, V1 = 0, W1 = 0, X1 = 0, Y1 = 0, Z1 = 0;

    int al = 0, vh = 0, ga = 0, de = 0, eps = 0, zh = 0, ht = 0, thh = 0;
    int gi = 0, ka = 0, la = 0, mh = 0, nh = 0, ksh = 0, om = 0, pi = 0;
    int ro = 0, si = 0, ta = 0, ups = 0, fi = 0, xi = 0, psi = 0, wm = 0;

    int sizc = 0, sizn = 0;
    int siz1=0;

    int all = 0, vhh = 0, gaa = 0, dee = 0, epss = 0, zhh = 0, htt = 0, thhh = 0;
    int gii = 0, kaa = 0, laa = 0, mhh = 0, nhh = 0, kshh = 0, omm = 0, pii = 0;
    int roo = 0, sii = 0, taa = 0, upss = 0, fii = 0, xii = 0, psii = 0, wmm = 0;


    String tel,name,name1,name2,text,column;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        add = (ImageView) findViewById(R.id.imageView1);
        update = (ImageView) findViewById(R.id.imageView2);
        Edit = (ImageView) findViewById(R.id.imageView3);
        Book = (ImageView) findViewById(R.id.imageView4);




        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(First.this, AddActivity.class);
                startActivity(i);
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(First.this, ViewActivity.class);
                startActivity(i);
                overridePendingTransition(0, 0);


            }
        });

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(First.this, EditActivity.class);
                startActivity(i);


            }
        });



        if(flagpop == 1)
        {

            startBook();
        }


        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startBook();
                flagpop =1;

            }
        });


    }


    private void startBook()

    {

        final Dialog dialog1 = new Dialog(First.this);
        dialog1.setContentView(R.layout.phonebook);
        dialog1.setTitle("");

        //Her add your textView and ImageView if you want

        Txt_Display = (TextView) dialog1.findViewById(R.id.textbook);
        editText = (EditText) dialog1.findViewById(R.id.editbook);

        Txt_Display.setTextIsSelectable(true);

        TextView dialogButton1 = (TextView) dialog1.findViewById(R.id.imagebook);

        // if button is clicked, close the custom dialog
        dialogButton1.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 dialog1.dismiss();

                                                 flagpop=0;

                                             }
                                         }
        );


        /////////////////////////////////////////////////


        column = " ";
        search();


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                column = editText.getText().toString().trim();

                if(!column.isEmpty()) {
                    search();
                }else {
                    column = " ";
                    search();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        //////////


        dialog1.show();


    }



    public void search()

    {


        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.readContacts1(database);

        text = " ";
        if(column.isEmpty()){
            column = " ";
        }

        siz1=0;


        while (cursor.moveToNext())


        {
            tel = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TEL));
            name = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.NAME));
            // column = column.trim();


            if(!(tel.equals(newtel)) || !(name.equals(newname))) {
                newtel = tel;
                newname = name;
                flag=0;
            }
            else{

                flag=1;
            }

            sizc = column.length();
            sizn = name.length();

            //  String column1 = column.substring(0,9);

                if (!(siz1 == sizc)) {
                    siz1 = sizc;


                    A = 0;
                    B = 0;
                    C = 0;
                    D = 0;
                    E = 0;
                    F = 0;
                    G = 0;
                    H = 0;
                    I = 0;
                    J = 0;
                    K = 0;
                    L = 0;
                    M = 0;
                    N = 0;
                    O = 0;
                    P = 0;
                    Q = 0;
                    RR = 0;
                    S = 0;
                    T = 0;
                    U = 0;
                    V = 0;
                    W = 0;
                    X = 0;
                    Y = 0;
                    Z = 0;



                    A1 = 0;
                    B1 = 0;
                    C1 = 0;
                    D1 = 0;
                    E1 = 0;
                    F1 = 0;
                    G1 = 0;
                    H1 = 0;
                    I1 = 0;
                    J1 = 0;
                    K1 = 0;
                    L1 = 0;
                    M1 = 0;
                    N1 = 0;
                    O1 = 0;
                    P1 = 0;
                    Q1 = 0;
                    RR1 = 0;
                    S1 = 0;
                    T1 = 0;
                    U1 = 0;
                    V1 = 0;
                    W1 = 0;
                    X1 = 0;
                    Y1 = 0;
                    Z1 = 0;


                    al = 0;
                    vh = 0;
                    ga = 0;
                    de = 0;
                    eps = 0;
                    zh = 0;
                    ht = 0;
                    thh = 0;
                    gi = 0;
                    ka = 0;
                    la = 0;
                    mh = 0;
                    nh = 0;
                    ksh = 0;
                    om = 0;
                    pi = 0;
                    ro = 0;
                    si = 0;
                    ta = 0;
                    ups = 0;
                    fi = 0;
                    xi = 0;
                    psi = 0;
                    wm = 0;

                    all = 0;
                    vhh = 0;
                    gaa = 0;
                    dee = 0;
                    epss = 0;
                    zhh = 0;
                    htt = 0;
                    thhh = 0;
                    gii = 0;
                    kaa = 0;
                    laa = 0;
                    mhh = 0;
                    nhh = 0;
                    kshh = 0;
                    omm = 0;
                    pii = 0;
                    roo = 0;
                    sii = 0;
                    taa = 0;
                    upss = 0;
                    fii = 0;
                    xii = 0;
                    psii = 0;
                    wmm = 0;

                }




            while (sizc < sizn){

                sizn--;

            }



            name1 = name.substring(0,sizn);
            name2= name.substring(0,1);

            if (column.equals(name1)) {

                funcswitch();

            }

            if(column.equals(" ")) {

                funcswitch();




            }




        }

        flag=0;
        newname="0";
        newtel=".";

        contactDbHelper.close();


        text = text.replace("\n", "<br>");
        Txt_Display.setText(Html.fromHtml(text));
      //  text = " ";



    }



    public void funcswitch()
    {




if (flag==0) {


    switch (name2) {


        case "A": {
            if (A == 0) {
                text = text + "\n\n Α\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                A = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "a": {
            if (A1 == 0) {
                text = text + "\n\n  a\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                A1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "B": {
            if (B == 0) {
                text = text + "\n \nB\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                B = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "b": {
            if (B1 == 0) {
                text = text + "\n\n b\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                B1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "C": {
            if (C == 0) {
                text = text + "\n\n C\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                C = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "c": {
            if (C1 == 0) {
                text = text + "\n \n c \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                C1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "D": {
            if (D == 0) {
                text = text + "\n \n D\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                D = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "d": {
            if (D1 == 0) {
                text = text + "\n \n d\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                D1 = 1;

            } else {
                text = text + "\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "E": {
            if (E == 0) {
                text = text + "\n\n E\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                E = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "e": {
            if (E1 == 0) {
                text = text + "\n\n  e\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                E1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "F": {
            if (F == 0) {
                text = text + "\n \nF\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                F = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "f": {
            if (F1 == 0) {
                text = text + "\n\n f\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                F1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "G": {
            if (G == 0) {
                text = text + "\n\n G\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                G = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "g": {
            if (G1 == 0) {
                text = text + "\n \n g \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                G1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "H": {
            if (H == 0) {
                text = text + "\n \n H\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                H = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "h": {
            if (H1 == 0) {
                text = text + "\n \n h\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                H1 = 1;

            } else {
                text = text + "\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "I": {
            if (I == 0) {
                text = text + "\n\n I\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                I = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "i": {
            if (I1 == 0) {
                text = text + "\n\n  i\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                I1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "J": {
            if (J == 0) {
                text = text + "\n \nJ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                J = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "j": {
            if (J1 == 0) {
                text = text + "\n\n j\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                J1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "K": {
            if (K == 0) {
                text = text + "\n\n K\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                K = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "k": {
            if (K1 == 0) {
                text = text + "\n \n k \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                K1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "L": {
            if (L == 0) {
                text = text + "\n \n L\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                L = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "l": {
            if (L1 == 0) {
                text = text + "\n \n l\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                L1 = 1;

            } else {
                text = text + "\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "M": {
            if (M == 0) {
                text = text + "\n\n M\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                M = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "m": {
            if (M1 == 0) {
                text = text + "\n\n  m\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                M1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "N": {
            if (N == 0) {
                text = text + "\n \nN\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                N = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "n": {
            if (N1 == 0) {
                text = text + "\n\n n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                N1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "O": {
            if (O == 0) {
                text = text + "\n\n O\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                O = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "o": {
            if (O1 == 0) {
                text = text + "\n \n o \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                O1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "P": {
            if (P == 0) {
                text = text + "\n \n P\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                P = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "p": {
            if (P1 == 0) {
                text = text + "\n \n p\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                P1 = 1;

            } else {
                text = text + "\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "Q": {
            if (Q == 0) {
                text = text + "\n\n Q\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                Q = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "q": {
            if (Q1 == 0) {
                text = text + "\n\n  q\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                Q1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }


        case "R": {
            if (RR == 0) {
                text = text + "\n\n R\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                RR = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "r": {
            if (RR1 == 0) {
                text = text + "\n\n  r\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                RR1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "S": {
            if (S == 0) {
                text = text + "\n \nS\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                S = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "s": {
            if (S1 == 0) {
                text = text + "\n\n s\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                S1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "T": {
            if (T == 0) {
                text = text + "\n\n T\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                T = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "t": {
            if (T1 == 0) {
                text = text + "\n \n t \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                T1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "U": {
            if (U == 0) {
                text = text + "\n \n U\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                U = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "u": {
            if (U1 == 0) {
                text = text + "\n \n u\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                U1 = 1;

            } else {
                text = text + "\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "V": {
            if (V == 0) {
                text = text + "\n\n V\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                V = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "v": {
            if (V1 == 0) {
                text = text + "\n\n  v\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                V1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "W": {
            if (W == 0) {
                text = text + "\n\n W\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                W = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "w": {
            if (W1 == 0) {
                text = text + "\n\n  w\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                W1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "X": {
            if (X == 0) {
                text = text + "\n \nX\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                X = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "x": {
            if (X1 == 0) {
                text = text + "\n\n x\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                X1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "Y": {
            if (Y == 0) {
                text = text + "\n\n Y\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                Y = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "y": {
            if (Y1 == 0) {
                text = text + "\n \n y\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                Y1 = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "Z": {
            if (Z == 0) {
                text = text + "\n \n Z\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                Z = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "z": {
            if (Z1 == 0) {
                text = text + "\n \n z\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                Z1 = 1;

            } else {
                text = text + "\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }


        /////////ellinika grammata


        case "Α": {
            if (al == 0) {
                text = text + "\n\n Α\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                al = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "α": {
            if (all == 0) {
                text = text + "\n\n  α\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                all = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Β": {
            if (vh == 0) {
                text = text + "\n \nB\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                vh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "β": {
            if (vhh == 0) {
                text = text + "\n\n β\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                vhh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "Γ": {
            if (ga == 0) {
                text = text + "\n\n Γ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                ga = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "γ": {
            if (gaa == 0) {
                text = text + "\n \n γ \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                gaa = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "Δ": {
            if (de == 0) {
                text = text + "\n \n Δ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                de = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "δ": {
            if (dee == 0) {
                text = text + "\n \n δ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                dee = 1;

            } else {
                text = text + "\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Ε": {
            if (eps == 0) {
                text = text + "\n\n Ε\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                eps = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ε": {
            if (epss == 0) {
                text = text + "\n\n ε\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                epss = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "Ζ": {
            if (zh == 0) {
                text = text + "\n\n Ζ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                zh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ζ": {
            if (zhh == 0) {
                text = text + "\n\n ζ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                zhh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Η": {
            if (htt == 0) {
                text = text + "\n\n Η\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                htt = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "η": {
            if (htt == 0) {
                text = text + "\n\n η\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                htt = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Θ": {
            if (thh == 0) {
                text = text + "\n \n Θ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                thh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "θ": {
            if (thhh == 0) {
                text = text + "\n θ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                thhh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Ι": {
            if (gi == 0) {
                text = text + "\n\n Ι\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                gi = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ι": {
            if (gii == 0) {
                text = text + "\n\n ι\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                gii = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Κ": {
            if (ka == 0) {
                text = text + "\n\n Κ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                ka = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "κ": {
            if (kaa == 0) {
                text = text + "\n\n κ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                kaa = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Λ": {
            if (la == 0) {
                text = text + "\n\n Λ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                la = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "λ": {
            if (laa == 0) {
                text = text + "\n\n λ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                laa = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Μ": {
            if (mh == 0) {
                text = text + "\n\n M\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                mh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "μ": {
            if (mhh == 0) {
                text = text + "\n\n μ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                mhh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Ν": {
            if (nh == 0) {
                text = text + "\n\n N\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                nh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ν": {
            if (nhh == 0) {
                text = text + "\n\n ν\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                nhh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Ξ": {
            if (ksh == 0) {
                text = text + "\n\n Ξ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                ksh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ξ": {
            if (kshh == 0) {
                text = text + "\n\n ξ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                kshh = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Ο": {
            if (om == 0) {
                text = text + "\n\n Ο\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                om = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ο": {
            if (omm == 0) {
                text = text + "\n\n ο\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                omm = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Π": {
            if (pi == 0) {
                text = text + "\n\n Π\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                pi = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "π": {
            if (pii == 0) {
                text = text + "\n\n π\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                pii = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Ρ": {
            if (ro == 0) {
                text = text + "\n\n Ρ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                ro = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ρ": {
            if (roo == 0) {
                text = text + "\n\n ρ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                roo = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }

        case "Σ": {
            if (si == 0) {
                text = text + "\n\n Σ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                si = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "σ": {
            if (sii == 0) {
                text = text + "\n\n σ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                sii = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Τ": {
            if (ta == 0) {
                text = text + "\n\n Τ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                ta = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "τ": {
            if (taa == 0) {
                text = text + "\n\n τ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                taa = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Υ": {
            if (ups == 0) {
                text = text + "\n\n Υ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                ups = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "υ": {
            if (upss == 0) {
                text = text + "\n\n υ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                upss = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Φ": {
            if (fi == 0) {
                text = text + "\n\n Φ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                fi = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "φ": {
            if (fii == 0) {
                text = text + "\n\n φ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                fii = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Χ": {
            if (xi == 0) {
                text = text + "\n\n Χ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                xi = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "χ": {
            if (xii == 0) {
                text = text + "\n\n χ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                xii = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Ψ": {
            if (psi == 0) {
                text = text + "\n\n Ψ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                psi = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ψ": {
            if (psii == 0) {
                text = text + "\n\n ψ\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                psii = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "Ω": {
            if (wm == 0) {
                text = text + "\n\n Ω\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                wm = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }
        case "ω": {
            if (wmm == 0) {
                text = text + "\n\n ω\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
                wmm = 1;

            } else {
                text = text + "\n \n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                        "<font color=#0000ff> \n ☎ " + tel + "</font>";
            }
            break;

        }


        default:
            text = text + "\n\n" + "<font color=#0000ff> \uD83D\uDC65 " + name + "</font>" +
                    "<font color=#0000ff> \n ☎ " + tel + "</font>";


    }


}



return;


    }











    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("FLAGPOP",flagpop);
        outState.putInt("A",A);
        outState.putInt("B",B);
        outState.putInt("C",C);
        outState.putInt("D",D);
        outState.putInt("al",al);
        outState.putInt("vh",vh);
        outState.putInt("SINC",sizc);
        outState.putInt("SINZ",sizn);
        outState.putInt("SINZ1",siz1);

        outState.putString("TEL",tel);
        outState.putString("NAME",name);
        outState.putString("NAME1",name1);
        outState.putString("COL",column);
        outState.putString("NAME2",name2);
        outState.putString("TEXT",text);



    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        flagpop = savedInstanceState.getInt("FLAGPOP");
        A = savedInstanceState.getInt("A");
        B= savedInstanceState.getInt("B");
        C= savedInstanceState.getInt("C");
        D= savedInstanceState.getInt("D");
        al= savedInstanceState.getInt("al");
        vh= savedInstanceState.getInt("vh");
        siz1= savedInstanceState.getInt("SINZ1");
        sizc= savedInstanceState.getInt("SIZC");
        sizn= savedInstanceState.getInt("SINZ");

               tel = savedInstanceState.getString("TEL");
                name= savedInstanceState.getString("NAME");
                name1= savedInstanceState.getString("NAME1");
                column= savedInstanceState.getString("COL");
               name2 = savedInstanceState.getString("NAME2");
                text= savedInstanceState.getString("TEXT");





        if(flagpop == 1)
        {

            startBook();
        }


    }

}


