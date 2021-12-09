package ch.rz.quicklist.view;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDoAdapter extends RecyclerView.Adapter <ToDoAdapter.ToDoViewHolder>{

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder {
        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
