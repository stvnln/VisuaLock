package com.example.visualock.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.visualock.LoginActivity;
import com.example.visualock.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuFragment extends Fragment {

    private ListView mMenuListView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        mMenuListView = root.findViewById(R.id.list_menu);

        String[] options = {"Profile", "About Us", "Setting", "Logout"};
        int[] icons = {
                R.drawable.user_24,
                R.drawable.info_24,
                R.drawable.setting_24,
                R.drawable.logout_24
        };

        CustomListAdapter adapter = new CustomListAdapter(requireContext(), options, icons);
        mMenuListView.setAdapter(adapter);

        mMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Navigate to profile page
                        break;
                    case 1:
                        // Navigate to about us page
                        break;
                    case 2:
                        // Navigate to setting page
                        break;
                    case 3:
                        FirebaseAuth.getInstance().signOut();
                        Intent i = new Intent(requireContext(), LoginActivity.class);
                        startActivity(i);
                        requireActivity().finish();
                        break;
                }
            }
        });

        return root;
    }
}

