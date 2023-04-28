package com.example.h2oflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SelectListener{
    private RecyclerView myRV;
    private MyListAdapter adapter;
    private ArrayList<MyListData> myListDataArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myRV = findViewById(R.id.idRVCourses);

        // calling method to
        // build recycler view.
        buildRecyclerView();
    }
    // calling on create option menu
    // layout to inflate our menu file.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.menu_main, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }
    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<MyListData> filteredlist = new ArrayList<MyListData>();

        // running a for loop to compare elements.
        for (MyListData item : myListDataArrayList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getMeterNo().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }
    private void buildRecyclerView() {

        // below line we are creating a new array list
        myListDataArrayList = new ArrayList<MyListData>();

        // below line is to add data to our array list.
        myListDataArrayList.add(new MyListData("DSA", "742932","Pending"));
        myListDataArrayList.add(new MyListData("JAVA", "623823","Pending"));
        myListDataArrayList.add(new MyListData("C++", "823822","Done"));
        myListDataArrayList.add(new MyListData("Python", "123423","Pending"));
        myListDataArrayList.add(new MyListData("Fork CPP", "723823","Pending"));

        // initializing our adapter class.
        adapter = new MyListAdapter(this, myListDataArrayList, MainActivity.this);

        // adding layout manager to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        myRV.setHasFixedSize(true);

        // setting layout manager
        // to our recycler view.
        myRV.setLayoutManager(manager);

        // setting adapter to
        // our recycler view.
        myRV.setAdapter(adapter);
    }


    @Override
    public void onItemClicked(MyListData myListData) {
        Intent intent = new Intent(this,ShowDetails.class);
        intent.putExtra("MeterNo",myListData.getMeterNo());
        intent.putExtra("name",myListData.getCustomer());
        intent.putExtra("status",myListData.getStatus());
        startActivity(intent);
    }
}