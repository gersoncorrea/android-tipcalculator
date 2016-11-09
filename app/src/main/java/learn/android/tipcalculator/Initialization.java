package learn.android.tipcalculator;

import android.content.Context;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by GersonCorrea on 17-Jun-16.
 */
public class Initialization {

    private Context context;
    private TextView amountTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    private SeekBar percentSeekBar;


    public Initialization(Context context, TextView amountTextView, TextView tipTextView, TextView totalTextView, SeekBar percentSeekBar) {
        this.context = context;
        this.amountTextView = amountTextView;
        this.tipTextView = tipTextView;
        this.totalTextView = totalTextView;
        this.percentSeekBar = percentSeekBar;
    }
}
