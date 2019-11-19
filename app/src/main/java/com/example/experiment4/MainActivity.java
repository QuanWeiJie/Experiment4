package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText number;
    private EditText name;
    private EditText classname;
    private Button save_info;
    private Button read_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (EditText) findViewById(R.id.number);
        name = (EditText) findViewById(R.id.name);
        classname = (EditText) findViewById(R.id.classname);
        save_info = (Button)findViewById(R.id.save_info);
        save_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1 = number.getText().toString();
                String name1 = name.getText().toString();
                String classname1 = classname.getText().toString();
         if(number1.length()>0&name1.length()>0&classname1.length()>0) {
             FileOutputStream out = null;
             BufferedWriter writer = null;
             //学号存储到data1
             try {
                 out = openFileOutput("data1", Context.MODE_PRIVATE);
                 writer = new BufferedWriter(new OutputStreamWriter(out));
                 writer.write(number1);
             } catch (IOException e) {
                 e.printStackTrace();
             } finally {
                 try {
                     if (writer != null) {
                         writer.close();
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
//姓名存储到data2
             try {
                 out = openFileOutput("data2", Context.MODE_PRIVATE);
                 writer = new BufferedWriter(new OutputStreamWriter(out));
                 writer.write(name1);
             } catch (IOException e) {
                 e.printStackTrace();
             } finally {
                 try {
                     if (writer != null) {
                         writer.close();
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
//班级存储到data3
             try {
                 out = openFileOutput("data3", Context.MODE_PRIVATE);
                 writer = new BufferedWriter(new OutputStreamWriter(out));
                 writer.write(classname1);
             } catch (IOException e) {
                 e.printStackTrace();
             } finally {
                 try {
                     if (writer != null) {
                         writer.close();
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
         }
         else   Toast.makeText(MainActivity.this, "请输入信息", Toast.LENGTH_SHORT).show();
            }
        });
      read_info = (Button) findViewById(R.id.read_info);
      read_info.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              FileInputStream in = null;
              BufferedReader reader = null;
              StringBuilder content1 = new StringBuilder();
//从data1件中度姓名并显示
              try{
                  in = openFileInput("data1");
                  reader = new BufferedReader(new InputStreamReader(in));
                  String line = "";
                  while((line = reader.readLine())!=null){
                      content1.append(line);
                  }
              }catch (IOException e){
                  e.printStackTrace();
              }finally {
                  if(reader!=null){
                      try{
                          reader.close();
                      }catch (IOException e){
                          e.printStackTrace();
                      }
                  }
              }
            number.setText(content1);
              number.setSelection(content1.length());
//从data2文件中度姓名并显示
              StringBuilder content2 = new StringBuilder();
              try{
                  in = openFileInput("data2");
                  reader = new BufferedReader(new InputStreamReader(in));
                  String line = "";
                  while((line = reader.readLine())!=null){
                      content2.append(line);
                  }
              }catch (IOException e){
                  e.printStackTrace();
              }finally {
                  if(reader!=null){
                      try{
                          reader.close();
                      }catch (IOException e){
                          e.printStackTrace();
                      }
                  }
              }
              name.setText(content2);
              name.setSelection(content2.length());
//从data3文件中度姓名并显示
              StringBuilder content3 = new StringBuilder();
              try{
                  in = openFileInput("data3");
                  reader = new BufferedReader(new InputStreamReader(in));
                  String line = "";
                  while((line = reader.readLine())!=null){
                      content3.append(line);
                  }
              }catch (IOException e){
                  e.printStackTrace();
              }finally {
                  if(reader!=null){
                      try{
                          reader.close();
                      }catch (IOException e){
                          e.printStackTrace();
                      }
                  }
              }
              classname.setText(content3);
              classname.setSelection(content3.length());
              Toast.makeText(MainActivity.this,"读取成功",Toast.LENGTH_SHORT).show();
          }
      });
    }
}
