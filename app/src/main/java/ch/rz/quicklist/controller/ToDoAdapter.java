package ch.rz.quicklist.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

import ch.rz.quicklist.R;
import ch.rz.quicklist.model.AppDatabase;
import ch.rz.quicklist.model.ToDo;
import ch.rz.quicklist.model.ToDoDao;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    private List<ToDo> list;
    private final Context context;

    public ToDoAdapter(List<ToDo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public ToDoAdapter(Context context){

        this.context = context;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_todo_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "todos").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        ToDoDao toDoDao = db.toDoDao();
        ToDo toDo = list.get(position);
        Log.e("Todo", toDo.name);
        holder.labelName.setText(toDo.getName());
        holder.labelName.setChecked(toDo.getChecked());
        holder.labelName.setOnCheckedChangeListener((buttonView, isChecked) -> toDoDao.updateChecked(toDo.getId(),isChecked));
        holder.button.setOnClickListener(v -> toDoDao.delete(toDo));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void reload(){
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "todos").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        ToDoDao toDoDao = db.toDoDao();
        list = toDoDao.getAll();
    }

    public static class ToDoViewHolder extends RecyclerView.ViewHolder {
        public CheckBox labelName;
        public Button button;

        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.delete);
            ToDoAdapter toDoAdapter = new ToDoAdapter(itemView.getContext());
            toDoAdapter.reload();
            labelName = itemView.findViewById(R.id.fragmentContent);
        }
    }
}
