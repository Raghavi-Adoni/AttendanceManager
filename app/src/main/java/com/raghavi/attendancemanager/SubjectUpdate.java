package com.raghavi.attendancemanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class SubjectUpdate extends AppCompatActivity {


    subjectData[] dataset;

    int[] totalLecturesArray;
    String[] subName;
    int[] bunkedLecturesArray;
    Float[] minPercentArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_update);

        subName = new String[]{
                "DSA",
                "MATHS",
                "OS",
                "MA"
        };

        totalLecturesArray = new int[]{
                10,
                15,
                20,
                4
        };

        bunkedLecturesArray = new int[]
                {
                        10,
                        4,
                        3,
                        2
                };

        minPercentArray = new Float[]{
                55.5f,
                60.4f,
                22f,
                80f

        };
        int l = bunkedLecturesArray.length;
        dataset = new subjectData[l];
        for (int i = 0; i < l; i++) {
            dataset[i] = new subjectData(subName[i], totalLecturesArray[i], bunkedLecturesArray[i], minPercentArray[i]);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(dataset);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SubjectUpdate.this));
        recyclerView.setAdapter(adapter);

    }
}
