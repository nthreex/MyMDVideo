package com.studyjams.mdvideo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studyjams.mdvideo.Adapter.LocalVideoListAdapter;
import com.studyjams.mdvideo.R;

/**
 * Created by zwx on 2016/7/9.
 */

public class LocalVideoListFragment extends Fragment {
    private static final String TAG = "LocalVideoListFragment";
    private static final String ARG_PARAM = "param";

    private String mParam;

    private RecyclerView mRecyclerView;
    private LocalVideoListAdapter mLocalVideoListAdapter;

    public LocalVideoListFragment() {
        // Required empty public constructor
    }

    public static LocalVideoListFragment newInstance(String param) {
        LocalVideoListFragment fragment = new LocalVideoListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_local_video_list, container, false);
        mRecyclerView = (RecyclerView) parent.findViewById(R.id.local_video_list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //@width @height下面是获取缩略图的大小，因不确定最佳，所以展示先给出参数
        int width = 240;
        int height = 240;
        mLocalVideoListAdapter = new LocalVideoListAdapter(getActivity(), width, height);
        mRecyclerView.setAdapter(mLocalVideoListAdapter);
        return parent;
    }
}