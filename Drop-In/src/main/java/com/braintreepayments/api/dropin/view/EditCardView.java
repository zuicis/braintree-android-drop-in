package com.braintreepayments.api.dropin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.braintreepayments.api.dropin.R;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;

/**
 * Created by qneumiiller on 6/21/16.
 */
public class EditCardView extends LinearLayout {

    private EditText mCardNumber;
    private EditText mExpirationDate;
    private EditText mSecurityCode;
    private EditText mPhoneNumber;
    private Button mNext;

    private AddPaymentUpdateListener mListener;

    public EditCardView(Context context) {
        super(context);
        init(context);
    }

    public EditCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EditCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        if (isInEditMode()) {
            return;
        }
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.bt_edit_card, this);

        mCardNumber = (EditText)findViewById(R.id.card_number);
        mExpirationDate = (EditText)findViewById(R.id.expiration_date);
        mSecurityCode = (EditText)findViewById(R.id.security_code);
        mPhoneNumber = (EditText)findViewById(R.id.phone_number);
        mNext = (Button)findViewById(R.id.add_card_button);

        mNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onPaymentUpdated(EditCardView.this);
                }
            }
        });
    }

    public void setAddPaymentUpdatedListener(AddPaymentUpdateListener listener) {
        mListener = listener;
    }
}
