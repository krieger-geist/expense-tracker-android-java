package com.example.expense_tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expensetracker.Expense;
import com.example.expensetracker.R;

import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {
    Context context;
    ArrayList<Expense> list;
    OnItemLongClickListener longClickListener;

    public interface OnItemLongClickListener {
        void onItemLongClick(Expense expense, int position);
    }

    public ExpenseAdapter(Context context, ArrayList<Expense> list, OnItemLongClickListener longClickListener){
        this.list = list;
        this.context = context;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ExpenseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.expense_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.ViewHolder holder, int position) {
        Expense expense = list.get(position);
        holder.title.setText(expense.getTitle());
        holder.amount.setText("₹ " + expense.getAmount());
        holder.date.setText(expense.getDate());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickListener != null) {
                    longClickListener.onItemLongClick(expense, holder.getAdapterPosition());
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, amount, date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            amount = itemView.findViewById(R.id.tvAmount);
            date = itemView.findViewById(R.id.tvDate);
        }
    }
}
