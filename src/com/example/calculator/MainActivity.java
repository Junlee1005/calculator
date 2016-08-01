package com.example.calculator;





import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener{ 

	Button btn_0;
	Button btn_1;
	Button btn_2;
	Button btn_3;
	Button btn_4;
	Button btn_5;
	Button btn_6;
	Button btn_7;
	Button btn_8;
	Button btn_9;
	Button btn_point;// 小数点
	Button btn_divide;// 除以
	Button btn_multiply;// 乘以
	Button btn_minus;// 减去
	Button btn_pluse;// 加
	Button btn_equal;// 等于

	Button btn_clear;
	Button btn_del;
	EditText et_showview;
	boolean needclear;

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=(Button) findViewById(R.id.btn_0);
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3=(Button) findViewById(R.id.btn_3);
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_5=(Button) findViewById(R.id.btn_5);
        btn_6=(Button) findViewById(R.id.btn_6);
        btn_7=(Button) findViewById(R.id.btn_7);
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_9=(Button) findViewById(R.id.btn_9);
        btn_point=(Button) findViewById(R.id.btn_point);
        btn_divide=(Button) findViewById(R.id.btn_divide);
        btn_multiply=(Button) findViewById(R.id.btn_multiply);
        btn_minus=(Button) findViewById(R.id.btn_minus);
        btn_pluse=(Button) findViewById(R.id.btn_pluse);
        btn_equal=(Button) findViewById(R.id.btn_equal);
        btn_clear=(Button) findViewById(R.id.btn_clear);
        btn_del=(Button) findViewById(R.id.btn_del);
        et_showview=(EditText) findViewById(R.id.et_showview);
        
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_pluse.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        
    }



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str=et_showview.getText().toString();
		switch (v.getId()){
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_point:
			if(needclear){
				str="";
				et_showview.setText("");
				needclear=false;
			}		
			et_showview.setText(str+((Button) v).getText());
			break;
		case R.id.btn_divide:
		case R.id.btn_multiply:
		case R.id.btn_minus:
		case R.id.btn_pluse:
			et_showview.setText(str+" "+((Button) v).getText()+" ");
			break;
		case R.id.btn_equal:
			getResult();
			break;
		case R.id.btn_del:
			if(str!=null && !str.equals(" ")){
				et_showview.setText(str.substring(0,str.length()-1 ));
			}
			break;
		case R.id.btn_clear:
			et_showview.setText(" ");
			break;
		}
			
		
		}
	public void getResult(){		
		needclear=true;				
		String exp=et_showview.getText().toString();
		int space=exp.indexOf(' ');
		int point=exp.indexOf(".");
		double r=0;
		String s1=exp.substring(0,space);
		String s2=exp.substring(space+3);
		String op=exp.substring(space+1,space+2);
		double arg1=Double.parseDouble(s1);
		double arg2=Double.parseDouble(s2);
		if(op.equals("+")){
			r=arg1+arg2;
		}else if(op.equals("-")){
			r=arg1 - arg2;
		}else if(op.equals("×")){
			r=arg1*arg2;
		}else if(op.equals("÷")){
			if(arg2==0){
				r=0;
			}else{
				r=arg1/arg2;
			}
		}
		String pr=" "+r;
		pr =pr.replaceAll("0+?$", "");
		pr =pr.replaceAll("[.]$", "");
		et_showview.setText(pr);
	}
}
