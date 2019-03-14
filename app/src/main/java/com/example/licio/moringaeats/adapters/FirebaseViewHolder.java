package com.example.licio.moringaeats.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.licio.moringaeats.Constants;
import com.example.licio.moringaeats.R;
import com.example.licio.moringaeats.models.Recipe;
import com.example.licio.moringaeats.ui.RecipeDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void onBindRecipe(Recipe recipe){
        ImageView recipeImageView = (ImageView) mView.findViewById(R.id.recipeImage);
        TextView nameTextView = (TextView) mView.findViewById(R.id.recipeName);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.txtCuisine);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingTextView);

        Picasso.get()
                .load(recipe.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(recipeImageView);

        nameTextView.setText(recipe.getRecipeName());
        categoryTextView.setText(recipe.getSource());
        ratingTextView.setText("Rating: " + recipe.getRating() + "/5");
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Recipe> recipes = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    recipes.add(snapshot.getValue(Recipe.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, RecipeDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(recipes));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

            }
