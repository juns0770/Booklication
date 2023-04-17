package kr.example.booklication.ReportInfoActivity;

import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.example.booklication.Define;
import kr.example.booklication.R;

public class TextSetting {

    AppCompatActivity aTextSetting;

    EditText etBookTitle;
    EditText etBookAuthor;
    TextView tvBookDate;
    EditText etMotivation;
    EditText etSummary;
    EditText etRealization;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");

    public TextSetting(AppCompatActivity appCompatActivity) {
        aTextSetting = appCompatActivity;

        etBookTitle = aTextSetting.findViewById(R.id.etBookTitle);
        etBookAuthor = aTextSetting.findViewById(R.id.etBookAuthor);
        tvBookDate = aTextSetting.findViewById(R.id.tvBookDate);
        etMotivation = aTextSetting.findViewById(R.id.etMotivation);
        etSummary = aTextSetting.findViewById(R.id.etSummary);
        etRealization = aTextSetting.findViewById(R.id.etRealization);
    }

    public void setTextSetting() {
        if (Define.ins().lstBookReportInfo.size() != 0) {
            etBookTitle.setText(Define.ins().lstBookReportInfo.get(0));
            etBookAuthor.setText(Define.ins().lstBookReportInfo.get(1));
            tvBookDate.setText(Define.ins().lstBookReportInfo.get(2));
            if (Define.ins().lstBookReportInfo.get(3).equals("\\")) {
                etMotivation.setText("");
            } else {
                etMotivation.setText(Define.ins().lstBookReportInfo.get(3));
            }
            if (Define.ins().lstBookReportInfo.get(4).equals("\\")) {
                etSummary.setText("");
            } else {
                etSummary.setText(Define.ins().lstBookReportInfo.get(4));
            }
            if (Define.ins().lstBookReportInfo.get(5).equals("\\")) {
                etRealization.setText("");
            } else {
                etRealization.setText(Define.ins().lstBookReportInfo.get(5));
            }
        } else {
            etBookTitle.setText("");
            etBookAuthor.setText("");
            tvBookDate.setText(getDate());
            etMotivation.setText("");
            etSummary.setText("");
            etRealization.setText("");
        }
    }

    private String getDate() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }
}
