package kr.example.booklication.AppInfoActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.example.booklication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppInfoMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppInfoMain extends Fragment {

    AppCompatActivity aReportMain;

    public AppInfoMain(AppCompatActivity appCompatActivity) {
        aReportMain = appCompatActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_info_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}