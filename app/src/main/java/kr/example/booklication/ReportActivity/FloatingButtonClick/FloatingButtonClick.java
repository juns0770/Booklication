package kr.example.booklication.ReportActivity.FloatingButtonClick;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import kr.example.booklication.Define;
import kr.example.booklication.R;
import kr.example.booklication.ReportInfoActivity.ReportInfoActivity;

public class FloatingButtonClick {

    AppCompatActivity aFloatingButtonClick;

    FloatingActionButton fbAdd;

    public FloatingButtonClick(AppCompatActivity appCompatActivity) {
        aFloatingButtonClick = appCompatActivity;

        // BtnOnClickListener의 객체 생성.
        FbOnClickListener fbonClickListener = new FbOnClickListener();

        // 아이디 연결
        fbAdd = aFloatingButtonClick.findViewById(R.id.fbAdd);
        fbAdd.setOnClickListener(fbonClickListener);
    }

    class FbOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fbAdd:
                    Define.ins().bIscheck = false;
                    Intent intent = new Intent(aFloatingButtonClick, ReportInfoActivity.class);
                    aFloatingButtonClick.startActivity(intent);
                    aFloatingButtonClick.finish();
            }
        }
    }
}
