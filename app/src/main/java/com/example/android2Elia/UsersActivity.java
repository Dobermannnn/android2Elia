package com.example.android2Elia;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.android2Elia.recyclerview.UserAdapter;
import com.example.android2Elia.room.DbUser;
import com.example.android2Elia.room.UserDatabase;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private UserDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "user-database").build();

        loadUsers();
    }

    private void loadUsers() {
        AsyncTask.execute(() -> {
            List<DbUser> userList = db.userDao().getAllUsers();
            runOnUiThread(() -> {
                userAdapter = new UserAdapter(UsersActivity.this, userList);
                recyclerView.setAdapter(userAdapter);
            });
        });
    }
}
