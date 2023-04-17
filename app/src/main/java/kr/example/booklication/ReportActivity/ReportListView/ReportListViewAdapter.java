package kr.example.booklication.ReportActivity.ReportListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kr.example.booklication.R;
import kr.example.booklication.RecordActivity.Fragment3ListView.Fragment3ListViewItem;

public class ReportListViewAdapter extends BaseAdapter {
    public ArrayList<ReportListViewItem> lstlistViewItem = new ArrayList<ReportListViewItem>();

    @Override
    public int getCount() {
        return lstlistViewItem.size();
    }

    @Override
    public Object getItem(int position) {
        return lstlistViewItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listviewitem_report, parent, false);
        }

        TextView tvTitle_Report = (TextView) convertView.findViewById(R.id.tvTitle_Report);
        TextView tvAuthor_Report = (TextView) convertView.findViewById(R.id.tvAuthor_Report);
        TextView tvDate_Report = (TextView) convertView.findViewById(R.id.tvDate_Report);

        ReportListViewItem cReportListViewItem = lstlistViewItem.get(position);

        tvTitle_Report.setText(cReportListViewItem.getTitle());
        tvAuthor_Report.setText(cReportListViewItem.getAuthor());
        tvDate_Report.setText(cReportListViewItem.getDate());

        return convertView;

    }

    public void addItem(String Title, String Author, String Date) {
        ReportListViewItem cReportListViewItem = new ReportListViewItem();

        cReportListViewItem.setTitle(Title);
        cReportListViewItem.setAuthor(Author);
        cReportListViewItem.setDate(Date);

        lstlistViewItem.add(cReportListViewItem);
    }
}
