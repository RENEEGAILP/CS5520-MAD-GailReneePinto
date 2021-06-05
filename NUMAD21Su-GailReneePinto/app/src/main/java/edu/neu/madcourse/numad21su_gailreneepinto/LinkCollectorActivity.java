package edu.neu.madcourse.numad21su_gailreneepinto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LinkCollectorActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinkAdapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mRecyclerViewLayoutManager;
    private ArrayList<CardItem> mItemList = new ArrayList<>();
    private FloatingActionButton mInsertButton;
    private AlertDialog mInsertLinkDialog;
    private EditText mLinkNameEditTextView;
    private EditText mLinkURLEditTextView;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_link_collector );

        loadInitialData( savedInstanceState );
        buildRecyclerView();
        createLinkInputDialog();

        mInsertButton = findViewById( R.id.insert_link_button );
        mInsertButton.setOnClickListener( v -> insertLink() );

        mRecyclerViewAdapter.setOnLinkClickListener( position -> mItemList.get( position ).onLinkClick( this ) );

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper( new ItemTouchHelper.SimpleCallback( 0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getLayoutPosition();
                mItemList.remove( position );
                mRecyclerViewAdapter.notifyItemRemoved( position );
            }
        } );
        itemTouchHelper.attachToRecyclerView( mRecyclerView );

    }

    public void createLinkInputDialog() {

        LayoutInflater layoutInflater = LayoutInflater.from( this );
        View insertLinkInput = layoutInflater.inflate( R.layout.insert_link_input, null );

        mLinkNameEditTextView = insertLinkInput.findViewById( R.id.link_name_input );
        mLinkURLEditTextView = insertLinkInput.findViewById( R.id.link_url_input );

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( this );
        alertDialogBuilder.setView( insertLinkInput );

        alertDialogBuilder
                .setCancelable( false )
                .setPositiveButton( getString( R.string.insert ),
                        (dialog, id) -> {
                            CardItem linkCard = new CardItem( mLinkNameEditTextView.getText().toString(),
                                    mLinkURLEditTextView.getText().toString() );
                            if (linkCard.checkValidity()) {
                                mItemList.add( 0, linkCard );
                                mRecyclerViewAdapter.notifyItemInserted( 0 );
                                Snackbar.make( mRecyclerView, "Link added", Snackbar.LENGTH_LONG ).show();
                            } else {
                                Snackbar.make( mRecyclerView, "Link not added", Snackbar.LENGTH_LONG ).show();
                            }
                        } )
                .setNegativeButton( getString( R.string.cancel ),
                        (dialog, id) -> dialog.cancel() );
        mInsertLinkDialog = alertDialogBuilder.create();
    }

    private void loadInitialData(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey( NUMBER_OF_ITEMS )) {
            if (mItemList == null || mItemList.size() == 0) {
                int size = savedInstanceState.getInt( NUMBER_OF_ITEMS );

                for (int i = 0; i < size; i++) {
                    String linkName = savedInstanceState.getString( KEY_OF_INSTANCE + i + "0" );
                    String linkURL = savedInstanceState.getString( KEY_OF_INSTANCE + i + "1" );
                    CardItem linkCard = new CardItem( linkName, linkURL );
                    mItemList.add( linkCard );
                }
            }
        }
    }

    private void onInsertButtonClick(View view) {
        int position = 0;
        mItemList.add( position, new CardItem( "Name1", "desc1" ) );
        mRecyclerViewAdapter.notifyItemInserted( position );
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById( R.id.recyclerView );
        mRecyclerView.setHasFixedSize( true );
        mRecyclerViewLayoutManager = new LinearLayoutManager( this );
        mRecyclerViewAdapter = new LinkAdapter( mItemList );
        mRecyclerView.setLayoutManager( mRecyclerViewLayoutManager );
        mRecyclerView.setAdapter( mRecyclerViewAdapter );
    }


    public void insertLink() {
        mLinkNameEditTextView.getText().clear();
        mLinkURLEditTextView.requestFocus();
        mLinkURLEditTextView.getText().clear();
        mInsertLinkDialog.show();
    }
}