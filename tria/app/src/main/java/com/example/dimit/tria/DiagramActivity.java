package com.example.dimit.tria;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class DiagramActivity extends AppCompatActivity {

    ContactDbHelper mydb;
    SQLiteDatabase database;

    TextView text,rev,exp,mix;
    String data;

   // LineChart mpLineChart;
    int A=0,B=0,C=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagram);

        data = getIntent().getExtras().getString("TEL");
        A = getIntent().getExtras().getInt("A");





        rev = (TextView) findViewById(R.id.textView6);
        exp = (TextView) findViewById(R.id.textView7);
        mix = (TextView) findViewById(R.id.textView8);







        if(A ==0)
        {

            esoda();
        }

        if(A==1)
        {

            eksoda();
        }if(A ==2)
        {

            mixed();
        }




        rev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                A=0;


                Intent starterIntent ;
                starterIntent = getIntent();
                starterIntent.putExtra("A",A);

                finish();
                startActivity(starterIntent);


            }
        });




        exp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                eksoda();

                A=1;

                Intent starterIntent ;
                starterIntent = getIntent();
                starterIntent.putExtra("A",A);

                finish(); startActivity(starterIntent);





            }
        });


        mix.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                A=2;

                Intent starterIntent ;
                starterIntent = getIntent();

                starterIntent.putExtra("A",A);

                finish(); startActivity(starterIntent);


            }
        });






    }






    public void esoda()
    {





        text = (TextView) findViewById(R.id.textView5);
        text.setText("Απεικόνιση Εσόδων");







        LineChartView lineChartView = findViewById(R.id.chart);

        List axisValues = new ArrayList();
        List yAxisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));


        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();
        Cursor cursor = contactDbHelper.readtel(database,data);

        int datarevenue;
        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToNext();

            String year = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));
            String revenue = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_REVENUE));



            if(revenue==null){

                datarevenue=0;
            }else {
                datarevenue= Integer.parseInt(revenue);


            }

            axisValues.add(i, new AxisValue(i).setLabel(year));
            yAxisValues.add(new PointValue(i, datarevenue));

        }   contactDbHelper.close();






        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);

        //topothethsh sto diagramma


        //morfopoish diastash x
        Axis  axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);
        axis.setTextSize(10);   // textsize
        axis.setTextColor(Color.parseColor("#03A9F4"));

        //morfopoihsh diastash y

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);
        yAxis.setTextSize(10);
        yAxis.setTextColor(Color.parseColor("#03A9F4"));

        yAxis.setMaxLabelChars(9);
        yAxis.setInside(false);

        /// orizw th megisth thmi tou pinaka
       /* Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top =1500;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setMaximumViewport(viewport);
*/
    }





    public void eksoda()
    {


        text = (TextView) findViewById(R.id.textView5);
        text.setText("Απεικόνιση Εξόδων");



        LineChartView lineChartView = findViewById(R.id.chart);

        List axisValues = new ArrayList();
        List yAxisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));


        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();
        Cursor cursor = contactDbHelper.readtel(database,data);

        int dataexpenses;
        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToNext();

            String year = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));
            String expenses = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_EXPENSES));



            if(expenses==null){

                dataexpenses=0;
            }else {
                dataexpenses= Integer.parseInt(expenses);


            }

            axisValues.add(i, new AxisValue(i).setLabel(year));
            yAxisValues.add(new PointValue(i, dataexpenses));

        }   contactDbHelper.close();






        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);

        //topothethsh sto diagramma


        //morfopoish diastash x
        Axis  axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);
        axis.setTextSize(10);   // textsize
        axis.setTextColor(Color.parseColor("#03A9F4"));

        //morfopoihsh diastash y

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);
        yAxis.setTextSize(10);
        yAxis.setTextColor(Color.parseColor("#03A9F4"));


        yAxis.setMaxLabelChars(9);
        yAxis.setInside(false);



        /// orizw th megisth thmi tou pinaka
       /* Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top =1500;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setMaximumViewport(viewport);
*/
    }











    public void mixed()
    {


        text = (TextView) findViewById(R.id.textView5);
        text.setText("Απεικόνιση Μικτών Απολαβών");

        LineChartView lineChartView = findViewById(R.id.chart);

        List axisValues = new ArrayList();
        List yAxisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));


        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();
        Cursor cursor = contactDbHelper.readtel(database,data);

        int dataexpenses,datarevenue;
        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToNext();

            String year = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));
            String expenses = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_EXPENSES));
            String revenue = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_REVENUE));



            if(expenses==null){

                dataexpenses=0;
            }else {
                dataexpenses= Integer.parseInt(expenses);
            }


            if(revenue==null){

                datarevenue=0;
            }else {
                datarevenue= Integer.parseInt(revenue);
            }

            int mixed=0;
            mixed = datarevenue-dataexpenses;

            axisValues.add(i, new AxisValue(i).setLabel(year));
            yAxisValues.add(new PointValue(i, mixed));

        }   contactDbHelper.close();






        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);

        //topothethsh sto diagramma


        //morfopoish diastash x
        Axis  axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);
        axis.setTextSize(9);   // textsize
        axis.setMaxLabelChars(1);


        axis.setTextColor(Color.parseColor("#03A9F4"));

        //morfopoihsh diastash y

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);
        yAxis.setTextSize(8);
        int k=6;
        yAxis.getMaxLabelChars();
        yAxis.setTextColor(Color.parseColor("#03A9F4"));




        yAxis.setMaxLabelChars(9);
        yAxis.setInside(false);







        /// orizw th megisth thmi tou pinaka
       /* Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top =1500;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setMaximumViewport(viewport);
*/
    }










    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("A",A);
        outState.putInt("B",B);
        outState.putInt("C",C);



    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        A = savedInstanceState.getInt("A");
        B= savedInstanceState.getInt("B");
        C= savedInstanceState.getInt("C");


        if(A == 0)
        {

            esoda();

        }


        if(A == 1)
        {

            eksoda();


        }
        if(A == 2)
        {

            mixed();

        }



    }

}
