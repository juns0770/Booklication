package kr.example.booklication.ReportInfoActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import kr.example.booklication.Define;
import kr.example.booklication.MainActivity;
import kr.example.booklication.R;
import kr.example.booklication.ReportInfoActivity.ButtonClick.ButtonClick;

public class ReportInfoActivity extends AppCompatActivity {

    ButtonClick cButtonClick;
    TextSetting cTextSetting;

    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_info);

        // TextSetting 객체 생성
        cTextSetting = new TextSetting(this);
        // ButtonClick 객체 생성
        cButtonClick = new ButtonClick(this);

        cTextSetting.setTextSetting();
        cButtonClick.setButtonClick();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // 기존 뒤로 가기 버튼의 기능을 막기 위해 주석 처리 또는 삭제

        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지났으면 Toast 출력
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 현재 페이지가 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지나지 않았으면 종료
        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            if (Define.ins().bIscheck) {
                cButtonClick.SaveInfo();
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                // 독후감에 관한 정보가 있는 싱글톤 변수 초기화
                Define.ins().lstBookReportInfo.clear();
            }
        }
    }
}