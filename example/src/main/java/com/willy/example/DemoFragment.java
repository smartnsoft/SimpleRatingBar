package com.willy.example;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

import com.willy.ratingbar.BaseRatingBar;
import com.willy.ratingbar.BaseRatingBar.OnRatingChangeListener;
import com.willy.ratingbar.BaseRatingBar.OnRatingDoneListener;
import com.willy.ratingbar.RotationRatingBar;
import com.willy.ratingbar.ScaleRatingBar;

public class DemoFragment extends Fragment {

    public static final String TAG = "SimpleRatingBar";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final BaseRatingBar baseRatingBar = view.findViewById(R.id.baseratingbar_main);
        final ScaleRatingBar scaleRatingBar = view.findViewById(R.id.scaleRatingBar);
        final RotationRatingBar rotationRatingBar = view.findViewById(R.id.rotationratingbar_main);
        baseRatingBar.setClearRatingEnabled(false);

        baseRatingBar.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(BaseRatingBar ratingBar, float rating, boolean fromUser) {
                Log.d(TAG, "BaseRatingBar onRatingChange: " + rating);
            }
        });
        baseRatingBar.setOnRatingDoneListener(new OnRatingDoneListener() {
            @Override
            public void onRatingDone(float rating) {
                Log.d(TAG, "BaseRatingBar onRatingDone: " + rating);
            }
        });

        baseRatingBar.setCustomFilledRatingDrawable(0, ContextCompat.getDrawable(getContext(), R.drawable.filled2));
        baseRatingBar.setCustomEmptyRatingDrawable(0, ContextCompat.getDrawable(getContext(), R.drawable.empty2));

        baseRatingBar.setCustomFilledRatingDrawable(4, ContextCompat.getDrawable(getContext(), R.drawable.filled2));
        baseRatingBar.setCustomEmptyRatingDrawable(4, ContextCompat.getDrawable(getContext(), R.drawable.empty2));


        scaleRatingBar.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
          @Override
          public void onRatingChange(BaseRatingBar ratingBar, float rating, boolean fromUser) {
            Log.d(TAG, "ScaleRatingBar onRatingChange: " + rating);
          }
        });
        scaleRatingBar.setOnRatingDoneListener(new OnRatingDoneListener() {
          @Override
          public void onRatingDone(float rating) {
            Log.d(TAG, "ScaleRatingBar onRatingDone: " + rating);
          }
        });

        rotationRatingBar.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
          @Override
          public void onRatingChange(BaseRatingBar ratingBar, float rating, boolean fromUser) {
            Log.d(TAG, "RotationRatingBar onRatingChange: " + rating);
          }
        });
        rotationRatingBar.setOnRatingDoneListener(new OnRatingDoneListener() {
          @Override
          public void onRatingDone(float rating) {
            Log.d(TAG, "RotationRatingBar onRatingDone: " + rating);
          }
        });

        Button addRatingButton = view.findViewById(R.id.button_main_add_rating);
        addRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float currentRating = baseRatingBar.getRating();
                baseRatingBar.setRating(currentRating + 0.25f);

                currentRating = scaleRatingBar.getRating();
                scaleRatingBar.setRating(currentRating + 0.25f);

                currentRating = rotationRatingBar.getRating();
                rotationRatingBar.setRating(currentRating + 0.25f);
            }
        });

        final ObjectAnimator anim = ObjectAnimator.ofFloat(scaleRatingBar, "rating", 5f, 1f, 5f);
        anim.setDuration(1000);
        anim.setStartDelay(500);
        anim.start();
    }
}
