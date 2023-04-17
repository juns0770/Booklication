package kr.example.booklication.ReportInfoActivity.ButtonClick;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import kr.example.booklication.Define;
import kr.example.booklication.FileIOStream.FileIOStreamCheckDir;
import kr.example.booklication.FileIOStream.FileIOStreamCheckFile;
import kr.example.booklication.FileIOStream.FileIOStreamRead;
import kr.example.booklication.FileIOStream.FileIOStreamWrite;
import kr.example.booklication.MainActivity;
import kr.example.booklication.R;
import kr.example.booklication.ReportActivity.ReportMain;

public class ButtonClick {

    AppCompatActivity aButtonClick;

    Button btnSave;
    EditText etBookTitle;
    EditText etBookAuthor;
    TextView tvBookDate;
    EditText etMotivation;
    EditText etSummary;
    EditText etRealization;

    FileIOStreamCheckFile cFileIOStreamCheckFile;
    FileIOStreamCheckDir cFileIOStreamCheckDir;
    FileIOStreamWrite cFileIOStreamWrite;
    FileIOStreamRead cFileIOStreamRead;

    public ButtonClick(AppCompatActivity appCompatActivity) {
        aButtonClick = appCompatActivity;

        // 아이디 연결
        btnSave = aButtonClick.findViewById(R.id.btnSave);
        etBookTitle = aButtonClick.findViewById(R.id.etBookTitle);
        etBookAuthor = aButtonClick.findViewById(R.id.etBookAuthor);
        tvBookDate = aButtonClick.findViewById(R.id.tvBookDate);
        etMotivation = aButtonClick.findViewById(R.id.etMotivation);
        etSummary = aButtonClick.findViewById(R.id.etSummary);
        etRealization = aButtonClick.findViewById(R.id.etRealization);

        cFileIOStreamCheckDir = new FileIOStreamCheckDir(aButtonClick);
        cFileIOStreamCheckFile = new FileIOStreamCheckFile(aButtonClick);
        cFileIOStreamWrite = new FileIOStreamWrite(aButtonClick);
        cFileIOStreamRead = new FileIOStreamRead(aButtonClick);
    }

    public void setButtonClick() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInfo();
            }
        });
    }

    public void SaveInfo() {
        if (!etBookTitle.getText().toString().equals("")) {
            if (!etBookAuthor.getText().toString().equals("")) {
                ArrayList<String> lstArray = new ArrayList<String>();
                lstArray.add(etBookTitle.getText().toString());
                lstArray.add(etBookAuthor.getText().toString());
                lstArray.add(tvBookDate.getText().toString());
                if(etMotivation.getText().toString().equals("")){
                    lstArray.add("\\");
                }else {
                    lstArray.add(etMotivation.getText().toString());
                }
                if(etSummary.getText().toString().equals("")){
                    lstArray.add("\\");
                }else {
                    lstArray.add(etSummary.getText().toString());
                }
                if(etRealization.getText().toString().equals("")){
                    lstArray.add("\\");
                }else {
                    lstArray.add(etRealization.getText().toString());
                }
                Define.ins().lstBookReport.add(lstArray);

                String sTemp = "";
                for (int i = 0; i < Define.ins().lstBookReport.size(); i++) {
                    sTemp += Define.ins().lstBookReport.get(i).get(0) + ",";
                    sTemp += Define.ins().lstBookReport.get(i).get(1) + ",";
                    sTemp += Define.ins().lstBookReport.get(i).get(2) + ",";
                    sTemp += Define.ins().lstBookReport.get(i).get(3) + ",";
                    sTemp += Define.ins().lstBookReport.get(i).get(4) + ",";
                    sTemp += Define.ins().lstBookReport.get(i).get(5) + "#";
                }
                System.out.println("sTemp24 : " + sTemp);
                cFileIOStreamCheckDir.reportCheckDir();
                cFileIOStreamCheckFile.reportCheckFile("BookReport.txt");
                cFileIOStreamWrite.reportWriteData("BookReport.txt", sTemp);
                Log.d("읽기결과", cFileIOStreamRead.reportReadData("BookReport.txt"));


                Intent intent = new Intent(aButtonClick, MainActivity.class);
                aButtonClick.startActivity(intent);
                // 현재 화면 종료
                aButtonClick.finish();
                // 독후감에 관한 정보가 있는 싱글톤 변수 초기화
                Define.ins().lstBookReportInfo.clear();
            } else {
                Toast.makeText(aButtonClick, "지은이를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(aButtonClick, "제목을 입력해주세요.", Toast.LENGTH_SHORT).show();
        }

        System.out.println("Define.ins().lstBookReport : " + Define.ins().lstBookReport);
    }
}
