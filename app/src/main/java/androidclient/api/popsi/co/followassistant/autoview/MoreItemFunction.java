package androidclient.api.popsi.co.followassistant.autoview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoLinearLayout;

import androidclient.api.popsi.co.followassistant.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/3/2.
 */

public class MoreItemFunction extends AutoLinearLayout {

    String itemText;
    Drawable drawable;

    @BindView(R.id.iv_item_icon)
    ImageView iv_item_icon;
    @BindView(R.id.tv_item_text)
    TextView tv_item_text;


    public MoreItemFunction(Context context) {
        this(context, null);
    }

    public MoreItemFunction(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoreItemFunction(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.more_fragment_item, 0, 0);
        itemText = typedArray.getString(R.styleable.more_fragment_item_item_text);
        drawable = typedArray.getDrawable(R.styleable.more_fragment_item_item_icon);
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.more_fragment_item, this, true);
        ButterKnife.bind(view);
        iv_item_icon.setImageDrawable(drawable);
        tv_item_text.setText(itemText);
    }
}
