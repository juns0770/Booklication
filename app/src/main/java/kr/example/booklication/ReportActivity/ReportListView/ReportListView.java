package kr.example.booklication.ReportActivity.ReportListView;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import kr.example.booklication.Define;
import kr.example.booklication.R;
import kr.example.booklication.ReportInfoActivity.ReportInfoActivity;

public class ReportListView {

    AppCompatActivity aReportListView;

    ReportListViewAdapter cReportListViewAdapter;

    ListView lvList_Report;

    public ReportListView(AppCompatActivity appCompatActivity) {
        aReportListView = appCompatActivity;

        cReportListViewAdapter = new ReportListViewAdapter();

        lvList_Report = aReportListView.findViewById(R.id.lvList_Report);
    }

    public void setReportListView() {
        lvList_Report.setAdapter(cReportListViewAdapter);


        System.out.println("Define.ins().lstBookReport.size() : " + Define.ins().lstBookReport.size());
        for (int i = 0; i < Define.ins().lstBookReport.size(); i++) {
            cReportListViewAdapter.addItem(Define.ins().lstBookReport.get(i).get(0), Define.ins().lstBookReport.get(i).get(1), Define.ins().lstBookReport.get(i).get(2));
        }


        lvList_Report.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Define.ins().bIscheck = true;

                Define.ins().lstBookReportInfo.add(Define.ins().lstBookReport.get(position).get(0));
                Define.ins().lstBookReportInfo.add(Define.ins().lstBookReport.get(position).get(1));
                Define.ins().lstBookReportInfo.add(Define.ins().lstBookReport.get(position).get(2));
                Define.ins().lstBookReportInfo.add(Define.ins().lstBookReport.get(position).get(3));
                Define.ins().lstBookReportInfo.add(Define.ins().lstBookReport.get(position).get(4));
                Define.ins().lstBookReportInfo.add(Define.ins().lstBookReport.get(position).get(5));

                Define.ins().lstBookReport.remove(position);

                Intent intent = new Intent(aReportListView, ReportInfoActivity.class);
                aReportListView.startActivity(intent);
                aReportListView.finish();
            }
        });
    }
}
