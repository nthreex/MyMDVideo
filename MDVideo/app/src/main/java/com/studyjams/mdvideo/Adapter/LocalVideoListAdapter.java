package com.studyjams.mdvideo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.studyjams.mdvideo.PlayerModule.PlayerActivity;
import com.studyjams.mdvideo.R;
import com.studyjams.mdvideo.Util.AbstructProvider;
import com.studyjams.mdvideo.Util.Video;
import com.studyjams.mdvideo.Util.VideoProvider;

import java.util.List;

/**
 * Created by zwx on 2016/7/8.
 */

public class LocalVideoListAdapter extends RecyclerView.Adapter<LocalVideoListAdapter.ViewHolder> {

    private static final String TAG = "LocalVideoListAdapter";
    private Context mContext;
    private List<Video> listVideos;
    private int width;
    private int height;
    private LayoutInflater inflater;

    public LocalVideoListAdapter(Context context, int width, int height) {
        this.mContext = context;
        AbstructProvider provider = new VideoProvider(context);
        this.listVideos = provider.getList();
        this.width = width;
        this.height = height;
        this.inflater=LayoutInflater. from(mContext);
    }

    @Override
    public int getItemCount() {
        return listVideos.size();
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.local_video_list_item,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.title.setText(listVideos.get(position).getTitle());
        long sec = listVideos.get(position).getDuration() /1000 % 60; // sec
        long min = listVideos.get(position).getDuration() / 1000 / 60; // min
        long hour = min / 60;
        holder.info.setText(hour + " : " + min + " : " + sec);

        Glide
                .with(mContext)
                .load(listVideos.get(position).getPath())
//                .placeholder(R.drawable.empty_photo)
//                .thumbnail(0.2f).override(width,height)
                .into(holder.image);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView title;
        public TextView info;
        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
            info = (TextView) view.findViewById(R.id.info);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onVideoSelected(getAdapterPosition());
                }
            });
        }
    }

    private void onVideoSelected(int position) {
        Intent intent = new Intent(mContext, PlayerActivity.class)
                        .setData(Uri.parse(listVideos.get(position).getPath()))
                        .putExtra(PlayerActivity.CONTENT_ID_EXTRA, listVideos.get(position).getId())
                        .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, listVideos.get(position).getMimeType());
//                        .putExtra(PlayerActivity.PROVIDER_EXTRA, "Local");
                mContext.startActivity(intent);
    }
}
