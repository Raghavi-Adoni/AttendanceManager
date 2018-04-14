package com.raghavi.attendancemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SubjectUpdate extends AppCompatActivity {


    public static ArrayList<subjectData> dataset;

    RecyclerView recyclerView ;
    public Adapter adapter;
    LinearLayoutManager linearLayoutManager;
    SharedPreferences sharedPreferences;
    Float savedValue;
    public Button addSubjectButton;
   /* public static int flag;


   public static Adapter adapter;
    Float savedValue;
    SharedPreferences sharedPreferences;


    public static ArrayList<Integer> totalLecturesList;
    public static ArrayList<Integer> bunkedLecturesList;
    public static ArrayList<String> subNameList;
    public static ArrayList<Float> minPercentList;


    public Button addSubjectButton;
    public TextView subjectNameTextView;
    public EditText subjectTotalLecEditText;
    public EditText subjectBunkedLecEditText;
    public EditText subjectMinPercentEditText;

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_update);


        dataset=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        adapter = new Adapter(dataset);
        //linearLayoutManager = new LinearLayoutManager(this);
        addSubjectButton = (Button) findViewById(R.id.add_sub_button);


        addSubjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent screen = new Intent(SubjectUpdate.this, Add_Subject.class);
                startActivity(screen);

                adapter.notifyDataSetChanged();
            }


        });



        recyclerView.setLayoutManager(new LinearLayoutManager(SubjectUpdate.this));
        recyclerView.setAdapter(adapter);


    }




    public void saveFloat(String key, float value) {
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

/*

        subjectNameTextView = (TextView) findViewById(R.id.subject_name_text_view);
        subjectTotalLecEditText = (EditText) findViewById(R.id.subject_totalLec_editText);
        subjectBunkedLecEditText = (EditText) findViewById(R.id.subject_bunkedLec_editText);
        subjectMinPercentEditText = (EditText) findViewById(R.id.subject_minPercent_editText);
        addSubjectButton = (Button) findViewById(R.id.add_sub_button);
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

        flag =1;


        int l = bunkedLecturesList.size();

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

            per = (float) ((numerator * 100) / denominator);
            minPercentList.add(per);

            saveFloat("Percentage", (float) per);

        }


        for (int i = 0; i < l; i++) {
            subjectData s=new subjectData(subNameList.get(i), totalLecturesList.get(i), bunkedLecturesList.get(i), minPercentList.get(i));
            dataset.add(i,s) ;
            //= new subjectData(subNameList.get(i), totalLecturesList.get(i), bunkedLecturesList.get(i), minPercentList.get(i));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new Adapter(dataset);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SubjectUpdate.this));
        recyclerView.setAdapter(adapter);

        addSubjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag = 1;
                Intent screen = new Intent(SubjectUpdate.this, Add_Subject.class);
                startActivity(screen);

                finish();
            }


        });
*/

