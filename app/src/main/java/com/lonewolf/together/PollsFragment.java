package com.lonewolf.together;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.joaquimley.faboptions.FabOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PollsFragment extends Fragment {

    FabOptions fabOptions;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        return RootView;
    }
}
