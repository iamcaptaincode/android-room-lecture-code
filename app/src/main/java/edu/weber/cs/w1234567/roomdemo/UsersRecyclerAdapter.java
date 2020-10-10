package edu.weber.cs.w1234567.roomdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.weber.cs.w1234567.roomdemo.db.User;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder> {
    private List<User> userList;

    public UsersRecyclerAdapter(List<User> userList) {
        this.userList = userList;
    }

    public void setUserList(List<User> list) {
        userList.clear();
        userList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);
        if ( user != null ){
            holder.item = user;
            holder.tv1.setText(user.getFirstName());
            holder.tv2.setText(user.getLastName());
            holder.itemRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO: Do something when they click.
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    // ViewHolders HOLD the UI of an *individual* item in the list.
    public class ViewHolder extends RecyclerView.ViewHolder {

        public View itemRoot;
        public TextView tv1, tv2;
        public User item;

        public ViewHolder (View view) {
            super(view);

            itemRoot = view;
            tv1 = itemRoot.findViewById(R.id.tvLine1);
            tv2 = itemRoot.findViewById(R.id.tvLine2);
        }

    }
}
