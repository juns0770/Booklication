package kr.example.booklication;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import kr.example.booklication.AppInfoActivity.AppInfoMain;
import kr.example.booklication.CalendarActivity.CalendarMain;
import kr.example.booklication.FileIOStream.FileIOStreamCheckDir;
import kr.example.booklication.FileIOStream.FileIOStreamCheckFile;
import kr.example.booklication.RecordActivity.RecordMain;
import kr.example.booklication.ReportActivity.ReportMain;
import kr.example.booklication.Search_ListView.SearchMain;

public class Setmain {

    AppCompatActivity aSetmain;
    private BottomNavigationView mBottomNV;
    Menu menu;
    FileIOStreamCheckFile cFileIOStreamCheckFile;
    FileIOStreamCheckDir cFileIOStreamCheckDir;

    int Page = 1;

    public Setmain(AppCompatActivity appCompatActivity) {
        aSetmain = appCompatActivity;
        cFileIOStreamCheckDir = new FileIOStreamCheckDir(aSetmain);
        cFileIOStreamCheckFile = new FileIOStreamCheckFile(aSetmain);
    }

    // 하단 메뉴 버튼 설정, 프레그먼트 설정
    public void Setting() {

        // 파일 저장 위치 기본 경로로 설정
        cFileIOStreamCheckDir.checkDir();

        cFileIOStreamCheckFile.checkFile("startday_1", "");      // 읽은 책을 읽기 시작한 날 모음 파일
        cFileIOStreamCheckFile.checkFile("startday_2", "");      // 읽고 있는 책을 읽기 시작한 날 모음 파일

        cFileIOStreamCheckFile.checkFile("lastday", "");         // 읽은 책을 다 읽은 날 모음 파일

        cFileIOStreamCheckFile.checkFile("image_url_1", "");    // 읽은 책 이미지 url 모음 파일
        cFileIOStreamCheckFile.checkFile("image_url_2", "");    // 읽고 있는 책 이미지 url 모음 파일
        cFileIOStreamCheckFile.checkFile("image_url_3", "");    // 읽고 싶은 책 이미지 url 모음 파일

        cFileIOStreamCheckFile.checkFile("book_name_1", "");     // 읽은 책 제목 모음 파일
        cFileIOStreamCheckFile.checkFile("book_name_2", "");     // 읽고 있는 책 제목 모음 파일
        cFileIOStreamCheckFile.checkFile("book_name_3", "");     // 읽고 싶은 책 제목 모음 파일

        cFileIOStreamCheckFile.checkFile("book_aut_1", "");      // 읽은 책 저자 모음 파일
        cFileIOStreamCheckFile.checkFile("book_aut_2", "");      // 읽고 있는 책 저자 모음 파일
        cFileIOStreamCheckFile.checkFile("book_aut_3", "");      // 읽고 싶은 책 저자 모음 파일

        cFileIOStreamCheckFile.checkFile("book_total", "");      // 읽고 있는 책 총 페이지수 모음 파일
        cFileIOStreamCheckFile.checkFile("book_reading", "");    // 읽고 있는 책 읽은 페이지 수 모음 파일
        cFileIOStreamCheckFile.checkFile("book_exp", "");        // 읽고 싶은 책 기대평 모음 파일

        cFileIOStreamCheckFile.checkFile("today_1", "");         // 읽은 책을 저장한 날 모음 파일
        cFileIOStreamCheckFile.checkFile("today_2", "");         // 읽고 있는 책을 저장한 날 모음 파일
        cFileIOStreamCheckFile.checkFile("today_3", "");         // 읽고 싶은 책을 저장한 날 모음 파일

        cFileIOStreamCheckFile.checkFile("percentage", "");     // 읽고 있는 책 퍼센티지 모음 파일

        mBottomNV = aSetmain.findViewById(R.id.nav_view);
        menu = mBottomNV.getMenu();
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // 바텀내비게이션 아이템 클릭 이벤트
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager fragmentManager = aSetmain.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    /**
                     * 성민이 오면 여기 수정해야됨
                     */
                    // 서재 버튼을 클릭 했을때
                    case R.id.item_1:
                        if (Page != 0) {
                            menuItem.setIcon(R.drawable.bookshelf_down);
                            menu.findItem(R.id.item_2).setIcon(R.drawable.btn_docu_up);
                            menu.findItem(R.id.item_3).setIcon(R.drawable.btn_home_up);
                            menu.findItem(R.id.item_4).setIcon(R.drawable.btn_bookreport_up);
                            menu.findItem(R.id.item_5).setIcon(R.drawable.btn_appinfo_up);
                            // 프레그먼트 변경
                            fragmentTransaction.replace(R.id.content_layout, new RecordMain(aSetmain)).commitAllowingStateLoss();
                            Page = 0;
                        } else {
                        }
                        break;
                    // 홈 버튼을 클릭 했을때
                    case R.id.item_2:
                        if (Page != 1) {
                            menuItem.setIcon(R.drawable.btn_docu_down);
                            menu.findItem(R.id.item_1).setIcon(R.drawable.bookshelf_up);
                            menu.findItem(R.id.item_3).setIcon(R.drawable.btn_home_up);
                            menu.findItem(R.id.item_4).setIcon(R.drawable.btn_bookreport_up);
                            menu.findItem(R.id.item_5).setIcon(R.drawable.btn_appinfo_up);
                            // 프레그먼트 변경
                            fragmentTransaction.replace(R.id.content_layout, new CalendarMain(aSetmain)).commitAllowingStateLoss();
                            Page = 1;
                        } else {
                        }
                        break;
                    // 기록 버튼을 클릭 했을때
                    case R.id.item_3:
                        if (Page != 2) {
                            menuItem.setIcon(R.drawable.btn_home_down);
                            menu.findItem(R.id.item_2).setIcon(R.drawable.btn_docu_up);
                            menu.findItem(R.id.item_1).setIcon(R.drawable.bookshelf_up);
                            menu.findItem(R.id.item_4).setIcon(R.drawable.btn_bookreport_up);
                            menu.findItem(R.id.item_5).setIcon(R.drawable.btn_appinfo_up);
                            // 프레그먼트 변경
                            fragmentTransaction.replace(R.id.content_layout, new SearchMain(aSetmain)).commitAllowingStateLoss();
                            Page = 2;
                        } else {
                        }
                        break;
                    // 독후감 버튼을 클릭 했을때
                    case R.id.item_4:
                        if (Page != 3) {
                            menuItem.setIcon(R.drawable.btn_bookreport_down);
                            menu.findItem(R.id.item_1).setIcon(R.drawable.bookshelf_up);
                            menu.findItem(R.id.item_2).setIcon(R.drawable.btn_docu_up);
                            menu.findItem(R.id.item_3).setIcon(R.drawable.btn_home_up);
                            menu.findItem(R.id.item_5).setIcon(R.drawable.btn_appinfo_up);
                            // 프레그먼트 변경
                            fragmentTransaction.replace(R.id.content_layout, new ReportMain(aSetmain)).commitAllowingStateLoss();
                            Page = 3;
                        } else {
                        }
                        break;
                    // 앱 소개 버튼을 클릭 했을때
                    case R.id.item_5:
                        if (Page != 4) {
                            menuItem.setIcon(R.drawable.btn_appinfo_down);
                            menu.findItem(R.id.item_1).setIcon(R.drawable.bookshelf_up);
                            menu.findItem(R.id.item_2).setIcon(R.drawable.btn_docu_up);
                            menu.findItem(R.id.item_3).setIcon(R.drawable.btn_home_up);
                            menu.findItem(R.id.item_4).setIcon(R.drawable.btn_bookreport_up);
                            // 프레그먼트 변경
                            fragmentTransaction.replace(R.id.content_layout, new AppInfoMain(aSetmain)).commitAllowingStateLoss();
                            Page = 4;
                        } else {
                        }
                        break;
                }
                return true;
            }
        });
        // 기본화면을 홈 화면으로 설정
        if (Define.ins().lstBookReport.size() != 0) {
            mBottomNV.setSelectedItemId(R.id.item_4);
        } else {
            mBottomNV.setSelectedItemId(R.id.item_3);
        }
    }
}