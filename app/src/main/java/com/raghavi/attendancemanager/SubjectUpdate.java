package com.raghavi.attendancemanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectUpdate extends AppCompatActivity {


    subjectData[] dataset;

    int[] totalLecturesArray;
    String[] subName;
    int[] bunkedLecturesArray;
    Float[] minPercentArray;
    Button addNewSubButton;
    Float savedValue;
    SharedPreferences sharedPreferences;


    ArrayList<Integer> totalLecturesList;
    ArrayList<Integer> bunkedLecturesList;
    ArrayList<String> subNameList;
    ArrayList<Float> minPercentList;


    public TextView subjectNameTextView;
    public EditText subjectTotalLecEditText;
    public EditText subjectBunkedLecEditText;
    public EditText subjectMinPercentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_update);

        addNewSubButton = (Button) findViewById(R.id.add_sub_button);

        minPercentList = new ArrayList<Float>();

        subNameList = new ArrayList<String>();

        subNameList.add("DSA");
        subNameList.add("MATHS");
        subNameList.add("OS");
        subNameList.add("MA");

        totalLecturesList = new ArrayList<Integer>();

        totalLecturesList.add(10);
        totalLecturesList.add(15);
        totalLecturesList.add(20);
        totalLecturesList.add(4);

        bunkedLecturesList = new ArrayList<Integer>();

        bunkedLecturesList.add(10);
        bunkedLecturesList.add(4);
        bunkedLecturesList.add(3);
        bunkedLecturesList.add(2);


      /*  minPercentArray = new Float[]{
                55.5f,
                60.4f,
                22f,
                80f

        };

        int l = bunkedLecturesArray.length;
        minPercentArray = new Float[l];
        for (int j = 0; j < l; j++) {
            Float per;
            //getting the number of bunked lectures
            String bunkedLecturesString = String.valueOf(bunkedLecturesArray[j]);
            Float numerator = Float.parseFloat(bunkedLecturesString);
            saveFloat("Numerator", (float) numerator);


            //getting the number of lectures in total
            String totalLecturesString = String.valueOf(totalLecturesArray[j]);
            Float denominator = Float.parseFloat(totalLecturesString);
            saveFloat("Denominator", (float) denominator);


            per = ((numerator * 100) / denominator);

            //SaveInt("Percentage", per);
            per = (float) ((bunkedLecturesArray[j] * 100) / totalLecturesArray[j]);
            minPercentArray[j] = per;

            saveFloat("Percentage", (float) per);
        }*/


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final Adapter adapter = new Adapter(dataset);


        for (int j = 0; j < bunkedLecturesList.size(); j++) {
            Float per;
            //getting the number of bunked lectures
            String bunkedLecturesString = String.valueOf(bunkedLecturesList.get(j));
            Float numerator = Float.parseFloat(bunkedLecturesString);
            saveFloat("Numerator", (float) numerator);


            //getting the number of lectures in total
            String totalLecturesString = String.valueOf(totalLecturesList.get(j));
            Float denominator = Float.parseFloat(totalLecturesString);
            saveFloat("Denominator", (float) denominator);


            //  per = ((numerator * 100) / denominator);

            //SaveInt("Percentage", per);
            per = (float) ((numerator * 100) / denominator);
            minPercentList.add(per);

            saveFloat("Percentage", (float) per);

        }


        addNewSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.row_single);
                Float per;
                //getting the number of bunked lectures
                String subNameString=String.valueOf(subjectNameTextView);
                subNameList.add(subNameString);


                String bunkedLecturesString = String.valueOf(subjectBunkedLecEditText);
                bunkedLecturesList.add(Integer.parseInt(bunkedLecturesString));

                Float numerator = Float.parseFloat(bunkedLecturesString);
                saveFloat("Numerator", (float) numerator);

                //getting the number of lectures in total
                String totalLecturesString = String.valueOf(subjectTotalLecEditText);
                totalLecturesList.add(Integer.parseInt(totalLecturesString));

                Float denominator = Float.parseFloat(totalLecturesString);
                saveFloat("Denominator", (float) denominator);

                per = (float) ((numerator * 100) / denominator);
                minPercentList.add(per);

                saveFloat("Percentage", (float) per);
//adapter.notifyItemInserted(adapter.getItemCount()+1);
//dataset[bunkedLecturesList.size()+1]=new subjectData(subNameString,Integer.parseInt(bunkedLecturesString),Integer.parseInt(totalLecturesString),per);
                adapter.notifyDataSetChanged();
            }



        });
        int l = bunkedLecturesList.size();
         dataset =new subjectData[l];
        for(int i = 0; i < l; i++) {
            dataset[i] = new subjectData(subNameList.get(i), totalLecturesList.get(i), bunkedLecturesList.get(i), minPercentList.get(i));
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SubjectUpdate.this));
        recyclerView.setAdapter(adapter);

    }

    public void saveFloat(String key, float value) {
        // sharedPreferences = this.getSharedPreferences(key, 0);
        //SharedPreferences.Editor editor = sharedPreferences.edit();
        SharedPreferences.Editor editor = getSharedPreferences("com.raghavi.attendancemanager", Context.MODE_PRIVATE).edit();
        editor.putFloat(key, value);
        editor.apply();


    }

    public Float loadFloat(String key) {

        sharedPreferences = this.getSharedPreferences("com.raghavi.attendancemanager", Context.MODE_PRIVATE);
        savedValue = sharedPreferences.getFloat(key, 0);
        return savedValue;
    }


}
