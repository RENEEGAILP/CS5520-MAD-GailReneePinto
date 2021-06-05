package edu.neu.madcourse.numad21su_gailreneepinto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LinkCollectorActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mRecyclerViewLayoutManager;
    private ArrayList<CardItem> mItemList = new ArrayList<>();
    private FloatingActionButton mInsertButton;
    private AlertDialog mInsertLinkDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        buildRecyclerView();

        mInsertButton = findViewById(R.id.insert_link_button);
        mInsertButton.setOnClickListener(this::onInsertButtonClick);

    }

    private void onInsertButtonClick(View view)
    {
        int position = 0;
        mItemList.add(position, new CardItem("Name1","desc1"));
        mRecyclerViewAdapter.notifyItemInserted(position);
    }

    private void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerViewLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewAdapter = new LinkAdapter(mItemList);
        mRecyclerView.setLayoutManager(mRecyclerViewLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
}