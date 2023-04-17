package kr.example.booklication.ReportActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.example.booklication.R;
import kr.example.booklication.ReportActivity.FloatingButtonClick.FloatingButtonClick;
import kr.example.booklication.ReportActivity.ReportListView.ReportListView;

public class ReportMain extends Fragment {

    AppCompatActivity aReportMain;

    FloatingButtonClick cFloatingButtonClick;
    ReportListView cReportListView;
    GetFileText cGetFileText;

    public ReportMain(AppCompatActivity appCompatActivity) {
        aReportMain = appCompatActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.report_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // FloatingButtonClick 객체 생성
        cFloatingButtonClick = new FloatingButtonClick(aReportMain);
        cGetFileText = new GetFileText(aReportMain);
        // ReportListView 객체 생성
        cReportListView = new ReportListView(aReportMain);
        cGetFileText.setGetFileText();

        cReportListView.setReportListView();
    }
}