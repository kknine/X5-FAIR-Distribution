package com.sostainuto.app2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sostainuto.app2.model.Project;

import java.util.ArrayList;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    ArrayList<Project> mProjects;
    MainActivity.OnItemClickListener mListener;
    public ProjectsAdapter(ArrayList<Project> projects, MainActivity.OnItemClickListener listener) {
        mProjects = projects;
        mListener = listener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        if(position >= getItemCount())
            return;
        holder.bind(mProjects.get(position));

    }

    @Override
    public int getItemCount() {
        if(mProjects == null)
            return 0;
        return mProjects.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV;
        TextView levelTV;
        TextView scoreTV;
        ProgressBar progressBar;
        View itemView;


        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            nameTV = itemView.findViewById(R.id.lip_name);
            levelTV = itemView.findViewById(R.id.lip_level);
            scoreTV = itemView.findViewById(R.id.lip_score);
            progressBar = itemView.findViewById(R.id.lip_prog);

        }

        public void bind(final Project project) {
            nameTV.setText(project.getName());
            levelTV.setText(String.format("Level: %d",project.getLevel()));
            scoreTV.setText(String.format("Score %d",project.getScore()));
            progressBar.setMax(project.getMaxScore());;
            progressBar.setProgress(project.getScore());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(project);
                }
            });
        }
    }
}
