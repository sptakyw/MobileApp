package com.example.assign07audio_6206021620141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    ListView listMc;
    int index_music = -1;
    boolean checkPause = true;
    Button btnPlay , btnStop, btnPause;

    Integer [] song = {R.raw.theweeknd_outoftime,R.raw.theweeknd_saveyourtears,R.raw.theweeknd_blindinglights,
            R.raw.theweeknd_starboy,R.raw.theweeknd_ifeelitcoming};

    Integer [] img = {R.drawable.outoftime,R.drawable.saveyourtears,R.drawable.blindinglights,
            R.drawable.starboy, R.drawable.ifeelitcoming };

    String [] name = {"The Weeknd - Out Of Time","The Weeknd - Save Your Tears","The Weeknd - Blinding Lights",
            "The Weeknd - Starboy","The Weeknd -  I Feel It Coming"};

    MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnPause = (Button) findViewById(R.id.btnPause);

        Music music = new Music(this,img,name);
        listMc = (ListView) findViewById(R.id.listMc);
        listMc.setAdapter(music);
        listMc.setOnItemClickListener(this);

        // buttonPlay
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ถ้ายังไม่ได้เลือกเพลง
                if (index_music == -1) {
                    Toast.makeText(MainActivity.this, "Select Music", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Playing Music", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(MainActivity.this, song[index_music]);
                    mediaPlayer.start();
                }
            }
        });

        // buttonStop
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // กำลังเล่นเพลงอยู่
                if(mediaPlayer != null) {
                    Toast.makeText(MainActivity.this,"Music Stop",Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    index_music = -1;
                }
            }
        });

        // buttonPause
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ถ้าไม่ได้เลือกเพลง
                if (mediaPlayer == null) return;

                // ถ้ากดหยุด
                if(checkPause) {
                    Toast.makeText(MainActivity.this,"Music Pause",Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                    checkPause = false;
                }
                else {
                    Toast.makeText(MainActivity.this,"Music Resume",Toast.LENGTH_SHORT).show();
                    mediaPlayer.start();
                    checkPause = true;
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"Music Number: "+(i+1),Toast.LENGTH_SHORT).show();
        index_music = i;
    }
}

class Music extends ArrayAdapter <Integer> {
    private final Context context;
    private final Integer [] detailmusic;
    private final String [] name;

    public Music(Context context,Integer [] Detailmusic,String[] name){
        super(context,R.layout.list_music,Detailmusic);
        this.context = context;
        this.detailmusic = Detailmusic;
        this.name = name;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_music,null,true);
        ImageView image = (ImageView) rowView.findViewById(R.id.imageMusic);
        TextView nameMusic = (TextView) rowView.findViewById(R.id.nameMusic);

        nameMusic.setText(name[position]);
        image.setImageResource(detailmusic[position]);
        return rowView;
    }
}