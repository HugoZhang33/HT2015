package edu.pitt.is.UMAP2015;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeaderView extends LinearLayout {

    private Context context;
    private TextView button;
    private WebView wv;

    public HeaderView(Context context) {
        super(context);
        initialize(context);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(edu.pitt.is.UMAP2015.R.layout.list_view_header, null);
        button = (TextView) view.findViewById(edu.pitt.is.UMAP2015.R.id.expandbutton);
        wv = (WebView) view.findViewById(edu.pitt.is.UMAP2015.R.id.WebView01);
        addView(view);
    }

    public void setWebView(String content) {
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadData(content, "text/html", "utf-8");
    }

}
