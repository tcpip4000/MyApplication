package net.ertechnology.testy;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Juan on 12/04/2015.
 */
public class PlaceHolderFragment extends Fragment {

    private View mContainer;
    protected static final String PLACEHOLDERFRAGMENT_EXTRA_MSG = "net.ertechnology.testy.PlaceHolderFragment.MESSAGE";

    public PlaceHolderFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstance) {
        mContainer = inflater.inflate(R.layout.activity_display_message, container, false);
        RelativeLayout relativeLayout = (RelativeLayout) mContainer.findViewById(R.id.display_message_container);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String message = bundle.getString(PLACEHOLDERFRAGMENT_EXTRA_MSG) + " fg1";

            TextView textView = new TextView(getActivity());
            textView.setTextSize(40);
            textView.setText(message);
            //textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            relativeLayout.addView(textView);

        }

        return mContainer;
    }
}