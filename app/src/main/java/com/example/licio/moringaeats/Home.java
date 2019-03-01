package com.example.licio.moringaeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity {
    private String[] recipes = new String[] {"Sweet Potatoes with Apple Butter","Old-Fashioned Apple Pie","Beef Stew in Red Wine Sauce",
    "Butternut Squash Soup with Crisp Pancetta","Hot Mulled Cider","Pear-Cranberry Hand Pies","Caramel Lady Apples","Three-Chile Beef Chili",
    "Poached Egg over Spinach and Mushroom","10-Minute Energizing Oatmeal","Breakfast Bagel","Granola with Fresh Fruit"};

    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.txtRecipe)
    TextView mTxtRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        final RecipesAdapter adapter = new RecipesAdapter(this, R.layout.support_simple_spinner_dropdown_item,recipes);
        mListView.setAdapter(adapter);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String recipe = ((TextView)view).getText().toString();
                Toast.makeText(Home.this, recipe, Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mTxtRecipe.setText("The following recipes are loved by "+ name);
    }
}
