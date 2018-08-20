package com.lonewolf.together;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.joaquimley.faboptions.FabOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PollsFragment extends Fragment {

    FabOptions fabOptions;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null)
            Toast.makeText(getContext(), currentUser.toString(), Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_polls, container, false);

        fabOptions = RootView.findViewById(R.id.fab_options);
        fabOptions.setButtonsMenu(R.layout.menu);
        fabOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.faboptions_create_poll:
                        Intent intent = new Intent(getContext(), CreatePollsActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.faboptions_dummy:
                        Toast.makeText(getContext(), "Message", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        // no-op
                }
            }
        });
        mAuth.signInAnonymously()
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("random", "signInAnonymously:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getContext(), user.toString(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "dasda", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return RootView;
    }
}
