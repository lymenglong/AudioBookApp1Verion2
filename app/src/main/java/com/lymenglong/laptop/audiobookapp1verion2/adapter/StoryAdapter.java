package com.lymenglong.laptop.audiobookapp1verion2.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lymenglong.laptop.audiobookapp1verion2.ListChapter;
import com.lymenglong.laptop.audiobookapp1verion2.R;
import com.lymenglong.laptop.audiobookapp1verion2.model.Story;

import java.util.ArrayList;


public class StoryAdapter extends RecyclerView.Adapter {
    private ArrayList<Story> stories;
    private Activity activity;
    private View view;

    public StoryAdapter(Activity activity, ArrayList<Story> stories) {
        this.stories = stories;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new StoryHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StoryHolder) {
            StoryHolder storyHolder = (StoryHolder) holder;

            storyHolder.name.setText(stories.get(position).getTitle());
        }

    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    class StoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name;
        private ImageView imgNext;

        public StoryHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameStory);
            imgNext = (ImageView) itemView.findViewById(R.id.imgNext);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(view == itemView){
                Intent intent = new Intent(activity, ListChapter.class);
                intent.putExtra("idStory", stories.get(getAdapterPosition()).getId());
                intent.putExtra("titleStory", stories.get(getAdapterPosition()).getTitle());
                activity.startActivity(intent);
            }
        }
    }
}
