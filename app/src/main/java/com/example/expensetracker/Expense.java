package com.example.expensetracker;


public class Expense {

    int id;
    String title,category,amount,date;

    public Expense(int id, String title, String category, String amount, String date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    public int getId(){
        return id;

    }
    public String getCategory(){
        return category;
    }
    public String getAmount(){
        return amount;

    }
    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

}

