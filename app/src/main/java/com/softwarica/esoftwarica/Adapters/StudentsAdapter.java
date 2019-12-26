package com.softwarica.esoftwarica.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softwarica.esoftwarica.Models.Students;
import com.softwarica.esoftwarica.R;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {

    Context context;
    List<Students> studentsList;

    public StudentsAdapter(Context context, List<Students> contactsList) {
        this.context = context;
        this.studentsList = studentsList;

    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_students,parent,false);

        return new StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, final int position) {
        final Students students = studentsList.get(position);

        holder.imgProfile.setImageResource(students.getImageId());
        holder.tvName.setText(students.getFullname());
        holder.tvAge.setText(students.getAge());
        holder.tvGender.setText(students.getGender());
        holder.tvAddress.setText(students.getAddress());

        holder.imgDelete.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_delete_black_24dp));
        holder.imgEdit.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_edit_black_24dp));
        String gender = students.getGender();
        if (gender == "male") {
            holder.imgProfile.setImageResource(R.drawable.male);
        } else if (gender == "female") {
            holder.imgProfile.setImageResource(R.drawable.female);
        } else {
            holder.imgProfile.setImageResource(R.drawable.male);
        }



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile, imgDelete, imgEdit;
        TextView tvName, tvAge, tvAddress, tvGender;

        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            imgEdit = itemView.findViewById(R.id.imgEdit);


        }
    }
}
