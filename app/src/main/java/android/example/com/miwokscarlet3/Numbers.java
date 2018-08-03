
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.ListView;
//
//public class Numbers extends AppCompatActivity {
//
//
//  @Override
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//
//protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.word_list);
//
//             ArrayList<Word> words = new ArrayList<Word>();
//              words.add(new Word(" Lutti  "," One "));
//              words.add(new Word(" otiko  "," two "));
//              words.add(new Word("  tolookosu "," three "));
//               words.add(new Word("  oyysa "," four "));
//               words.add(new Word(" masokka  "," five "));
//               words.add(new Word(" temokka  "," six "));
//              words.add(new Word(" kenekaku  "," seven "));
//              words.add(new Word(" kawinta  "," eight "));
//               words.add(new Word(" woo  "," nine "));
//               words.add(new Word(" na accha  "," ten "));
// WordAdapter  adapter = new WordAdapter(this,  words); ListView listView = (ListView) findViewById(R.id.list);
//       listView.setAdapter(adapter);
//   }
//}


package android.example.com.miwokscarlet3;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
public class Numbers extends AppCompatActivity {
  private MediaPlayer mMediaPlayer ;


  private AudioManager mAudioManager ;
  AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
          new AudioManager.OnAudioFocusChangeListener(){

              public void onAudioFocusChange(int focusChange) {

                  if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                          focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                      mMediaPlayer.pause();
                      mMediaPlayer.seekTo(0);
                  }
                  else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                      mMediaPlayer.start();
                  }
                  else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                      releaseMediaPlayer();
                  }
              }
          };
  private  MediaPlayer.OnCompletionListener mCompletionListener= new MediaPlayer.OnCompletionListener() {
      @Override
      public void onCompletion(MediaPlayer mp) {
          releaseMediaPlayer();
      }
  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five", "massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        final WordAdapter miwokAdapter = new WordAdapter(this, words,R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(miwokAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = words.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                        if (result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                mMediaPlayer = MediaPlayer.create(Numbers.this,word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        }

            }


        });
    }

    @Override
    protected void onStop (){
        super.onStop();
        releaseMediaPlayer();
    }
                private void releaseMediaPlayer(){
                    if (mMediaPlayer !=null){
                        mMediaPlayer.release();
                        mMediaPlayer = null ;
                        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
                    }
                }

    }

//        ArrayList<String> words = new ArrayList<>();
//        words.add("one");
//        words.add("two");
//        words.add("three");
//        words.add("four");
//        words.add("five");
//        words.add("six");
//        words.add("seven");
//        words.add("eight");
//        words.add("nine");
//        words.add("ten");
//        words.add("eleven");

//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.list_item, words);
//        ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(itemsAdapter);
//    }
//}
//
// ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>
//(this, android.R.layout.simple_list_item_1, words);

// ArrayAdapter<String> itemsAdapter=new ArrayAdapter<String>
//                (this,android.R.layout.simple_list_item_1,words);
//        GridView listView = (GridView)findViewById(R.id.list);
//        listView.setAdapter(itemsAdapter);
//    }
//}

//       LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
//         for (int index = 0 ;index  <  words.size(); index++)
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//                                                }
//        index = index+1 ;
//        TextView wordView1 = new TextView(this);
//        wordView1.setText(words.get(1));
//        rootView.addView(wordView1);
//        index = index+1 ;
//        TextView wordView2 = new TextView(this);
//        wordView2.setText(words.get(2));
//        rootView.addView(wordView2);
//        index = index+1 ;
//        TextView wordView3 = new TextView(this);
//        wordView3.setText(words.get(3));
//        rootView.addView(wordView3);
//        index = index+1 ;
//        TextView wordView4 = new TextView(this);
//        wordView4.setText(words.get(4));
//        rootView.addView(wordView4);
//        index = index+1 ;
//        TextView wordView5 = new TextView(this);
//        wordView5.setText(words.get(5));
//        rootView.addView(wordView5);
//        index = index+1 ;
//        TextView wordView6 = new TextView(this);
//        wordView6.setText(words.get(6));
//        rootView.addView(wordView6);
//        index = index+1 ;
//        TextView wordView7 = new TextView(this);
//        wordView7.setText(words.get(7));
//        rootView.addView(wordView7);
//        index = index+1 ;
//        TextView wordView8 = new TextView(this);
//        wordView8.setText(words.get(8));
//        rootView.addView(wordView8);
//        index = index+1 ;
//        TextView wordView9 = new TextView(this);
//        wordView9.setText(words.get(9));
//        rootView.addView(wordView9);
//        index = index+1 ;
//        TextView wordView10 = new TextView(this);
//        wordView10.setText(words.get(10));
//        rootView.addView(wordView10);
//        index = index+1 ;
//        Log.v("Numbers","Word at index 0 :" + words[0]);
//        Log.v("Numbers","Word at index 1 :" + words[1]);
//         String  words [] = new String[10];
//           words [0] = "one";
//           words [1] = "two";
//           words [2] = "three";
//           words [3] = "four";
//           words [4] = "five";
//           words [5] = "six";
//           words [6] = "seven";
//           words [7] = "eight";
//           words [8] = "nine";
//           words [9] = "ten";
//
//           int index = 0 ;
//           while (index  <  words.size()){
//
//          TextView wordView = new TextView(this);
//          wordView.setText(words.get(index));
//          rootView.addView(wordView);
//          index++;
//           }