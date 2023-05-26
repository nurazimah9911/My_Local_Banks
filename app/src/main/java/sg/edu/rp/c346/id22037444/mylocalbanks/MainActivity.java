package sg.edu.rp.c346.id22037444.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView btnDBS, btnOCBC, btnUOB;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.DBSbtn);
        btnOCBC = findViewById(R.id.OCBCbtn);
        btnUOB = findViewById(R.id.UOBbtn);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

        btnDBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/"));
                startActivity(intentView);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +1800+111+1111));
                startActivity(intentCall);

            }
        });
        btnOCBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/"));
                startActivity(intentView);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +1800+363+3333));
                startActivity(intentCall);

            }
        });
        btnUOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/"));
                startActivity(intentView);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +1800+222+2121));
                startActivity(intentCall);
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        } else{
            btnDBS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}