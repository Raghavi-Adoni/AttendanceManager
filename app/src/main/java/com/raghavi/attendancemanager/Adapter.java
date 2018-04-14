package com.raghavi.attendancemanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Raghavi on 4/5/2018.
 */

/*
 * Created by Raghavi on 4/1/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {

    private subjectData[] data;

    public Adapter(subjectData[] data){this.data=data;}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItem=layoutInflater.inflate(R.layout.row_single,parent,false);
        ViewHolder viewHolder=new ViewHolder(listItem);
    return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.subjectNameTextView.setText(String.valueOf(data[position].getSubName()));
holder.subjectTotalLecEditText.setText(String.valueOf(data[position].getTotalLec()));
holder.subjectBunkedLecEditText.setText(String.valueOf(data[position].getBunkedLec()));
holder.subjectMinPercentEditText.setText(( String.valueOf(data[position].getMinPercent())));

    }



    @Override
    public int getItemCount() {
//       notifyItemInserted(getItemCount()+1);
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView subjectNameTextView;
        public EditText subjectTotalLecEditText;
        public EditText subjectBunkedLecEditText;
        public EditText subjectMinPercentEditText;

        public ViewHolder(View itemView) {
            super(itemView);
            this.subjectNameTextView=(TextView) itemView.findViewById(R.id.subject_name_text_view);
            this.subjectTotalLecEditText=(EditText) itemView.findViewById(R.id.subject_totalLec_editText);
            this.subjectBunkedLecEditText=(EditText) itemView.findViewById(R.id.subject_bunkedLec_editText);
            this.subjectMinPercentEditText=(EditText) itemView.findViewById(R.id.subject_minPercent_editText);

        }
    }
}

