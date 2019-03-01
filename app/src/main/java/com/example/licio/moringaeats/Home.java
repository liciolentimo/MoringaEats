package com.example.licio.moringaeats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity {
    private String[] recipes = new String[] {"Sweet Potatoes with Apple Butter","Old-Fashioned Apple Pie","Beef Stew in Red Wine Sauce",
    "Butternut Squash Soup with Crisp Pancetta","Hot Mulled Cider","Pear-Cranberry Hand Pies","Caramel Lady Apples","Three-Chile Beef Chili",
    "Poached Egg over Spinach and Mushroom","10-Minute Energizing Oatmeal","Breakfast Bagel","Granola with Fresh Fruit"};

    @BindView(R.id.listView)
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        final RecipesAdapter adapter = new RecipesAdapter(this, R.layout.support_simple_spinner_dropdown_item,recipes);
        mListView.setAdapter(adapter);
    }
}
