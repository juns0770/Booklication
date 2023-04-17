package kr.example.booklication.ReportActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import kr.example.booklication.Define;
import kr.example.booklication.FileIOStream.FileIOStreamCheckDir;
import kr.example.booklication.FileIOStream.FileIOStreamCheckFile;
import kr.example.booklication.FileIOStream.FileIOStreamRead;

public class GetFileText {

    AppCompatActivity aGetFileText;

    FileIOStreamCheckFile cFileIOStreamCheckFile;
    FileIOStreamCheckDir cFileIOStreamCheckDir;
    FileIOStreamRead cFileIOStreamRead;

    public GetFileText(AppCompatActivity appCompatActivity) {
        aGetFileText = appCompatActivity;

        cFileIOStreamCheckDir = new FileIOStreamCheckDir(aGetFileText);
        cFileIOStreamCheckFile = new FileIOStreamCheckFile(aGetFileText);
        cFileIOStreamRead = new FileIOStreamRead(aGetFileText);
    }

    public void setGetFileText() {
        cFileIOStreamCheckDir.reportCheckDir();
        cFileIOStreamCheckFile.reportCheckFile("BookReport.txt");
        String sTemp = cFileIOStreamRead.reportReadData("BookReport.txt");
        System.out.println("읽어온값 : " + sTemp);

        System.out.println("sTemp : " + sTemp);
        if (!sTemp.equals("")) {
            String[] splitSharp = sTemp.split("#");
            Define.ins().lstBookReport.clear();
            for (int i = 0; i < splitSharp.length; i++) {
                ArrayList<String> lstText = new ArrayList<String>();
                String[] splitComma = splitSharp[i].split(",");
                System.out.println("splitComma : " + splitComma[0]);
                System.out.println("splitComma : " + splitComma[1]);
                System.out.println("splitComma : " + splitComma[2]);
                lstText.add(splitComma[0]);
                lstText.add(splitComma[1]);
                lstText.add(splitComma[2]);
                if (splitComma[3].equals("\\")) {
                    lstText.add("\\");
                } else {
                    lstText.add(splitComma[3]);
                }
                if (splitComma[4].equals("\\")) {
                    lstText.add("\\");
                } else {
                    lstText.add(splitComma[4]);
                }
                if (splitComma[5].equals("\\")) {
                    lstText.add("\\");
                } else {
                    lstText.add(splitComma[5]);
                }
                Define.ins().lstBookReport.add(lstText);
                System.out.println("Define.ins().lstBookReport : " + Define.ins().lstBookReport);
            }
        } else {
        }

        System.out.println("Define.ins().lstBookReport : " + Define.ins().lstBookReport);
    }
}
