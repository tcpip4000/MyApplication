package net.ertechnology.testy;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        if (findViewById(R.id.display_message_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            PlaceHolderFragment fragment1 = new PlaceHolderFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PlaceHolderFragment.PLACEHOLDERFRAGMENT_EXTRA_MSG, getIntent().getStringExtra(MainActivity.MAINACTIVITY_EXTRA_MESSAGE));
            fragment1.setArguments(bundle);
            getFragmentManager().beginTransaction().add(R.id.display_message_container, fragment1).commit();
        }

        /*Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MAINACTIVITY_EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        setContentView(textView);*/
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceHolderFragment extends Fragment {

        View mContainer;
        protected static final String PLACEHOLDERFRAGMENT_EXTRA_MSG = "net.ertechnology.testy.PlaceHolderFragment.MESSAGE";

        public PlaceHolderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstance) {
            mContainer = inflater.inflate(R.layout.activity_display_message, container, false);
            RelativeLayout relativeLayout = (RelativeLayout) mContainer.findViewById(R.id.display_message_container);

            Bundle bundle = this.getArguments();
            if (bundle != null) {
                String message = bundle.getString(PLACEHOLDERFRAGMENT_EXTRA_MSG);

                TextView textView = new TextView(getActivity());
                textView.setTextSize(40);
                textView.setText(message);
                //textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                relativeLayout.addView(textView);

            }

            return mContainer;
        }
    }
}
