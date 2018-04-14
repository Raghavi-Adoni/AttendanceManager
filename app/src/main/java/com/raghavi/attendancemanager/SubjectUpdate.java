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
    int flag;
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

    public EditText addsubjectNameEditText;
    public EditText addsubjectTotalLecEditText;
    public EditText addsubjectBunkedLecEditText;
    public Button addSubjectData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_update);

        addNewSubButton = (Button) findViewById(R.id.add_sub_button);

        addsubjectNameEditText = (EditText) findViewById(R.id.add_subject_name_editText);
        addsubjectTotalLecEditText = (EditText) findViewById(R.id.add_subject_totalLec_editText);
        addsubjectBunkedLecEditText = (EditText) findViewById(R.id.add_subject_bunkedLec_editText);
        addSubjectData = (Button) findViewById(R.id.add_subject_data_button);

        subjectNameTextView = (TextView) findViewById(R.id.subject_name_text_view);
        subjectTotalLecEditText = (EditText) findViewById(R.id.subject_totalLec_editText);
        subjectBunkedLecEditText = (EditText) findViewById(R.id.subject_bunkedLec_editText);
        subjectMinPercentEditText = (EditText) findViewById(R.id.subject_minPercent_editText);

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

        flag = 0;




        addNewSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.row_single);
                flag = 1;

            }


        });

        addNewSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 1) {
                    // Float per;

                    String subNameString = String.valueOf(addsubjectNameEditText);
                    subNameList.add(subNameString);


                    String bunkedLecturesString = String.valueOf(addsubjectBunkedLecEditText);
                    bunkedLecturesList.add(Integer.parseInt(bunkedLecturesString));

                    String totalLecturesString = String.valueOf(addsubjectTotalLecEditText);
                    totalLecturesList.add(Integer.parseInt(totalLecturesString));

          /*  Float numerator = Float.parseFloat(bunkedLecturesString);
            saveFloat("Numerator", (float) numerator);

            //getting the number of lectures in total
            String totalLecturesString = String.valueOf(subjectTotalLecEditText);
            totalLecturesList.add(Integer.parseInt(totalLecturesString));

            Float denominator = Float.parseFloat(totalLecturesString);
            saveFloat("Denominator", (float) denominator);

            per = (float) ((numerator * 100) / denominator);
            minPercentList.add(per);

            saveFloat("Percentage", (float) per);*/
                }
            }
        });


        int l = bunkedLecturesList.size();
        dataset = new subjectData[l];
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
            dataset[i] = new subjectData(subNameList.get(i), totalLecturesList.get(i), bunkedLecturesList.get(i), minPercentList.get(i));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final Adapter adapter = new Adapter(dataset);

        recyclerView.setHasFixedSize(true);
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
