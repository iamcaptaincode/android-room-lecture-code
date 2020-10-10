package edu.weber.cs.w1234567.roomdemo;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.weber.cs.w1234567.roomdemo.db.AppDatabase;
import edu.weber.cs.w1234567.roomdemo.db.User;

public class AllUsersViewModel extends ViewModel {
    private LiveData<List<User>> userList;

    public LiveData<List<User>> getAllUsers(Context context) {

        AppDatabase db = AppDatabase.getInstance(context);

        userList = db.userDAO().getAll();

        return userList;
    }
}
