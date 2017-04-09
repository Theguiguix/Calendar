package com.miage.soorak.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

/**
 * Created by Guillaume on 10/02/2017.
 */

public class Tuile extends GridLayout {

    private boolean extended;
    private String data;

    public Tuile(Context context){
        super(context);
        this.extended = false;
        setBackgroundResource(R.drawable.tuile);
    }

    public Tuile(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.extended = false;
        setBackgroundResource(R.drawable.tuile);
    }

    public Tuile(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.extended = false;
        setBackgroundResource(R.drawable.tuile);
    }

    @Override
    public boolean callOnClick() {
        LinearLayout.LayoutParams newParams;

        if(!this.extended) {
            // Si la tuile n'était pas étendu on l'étend (on ajoute 200 pixels de hauteur)
            newParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(this.getWidth(), this.getHeight() + 200));
            this.extended = true;
        } else {
            // Si la tuile était étendu on la rétracte (on retire 200 pixels de hauteur)
            newParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(this.getWidth(), this.getHeight() - 200));
            this.extended = false;
        }

        //On reprend le margin des paramêtre existants pour les nouveaux paramètres
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
        newParams.setMargins(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin);

        // On set les nouveau paramètres
        this.setLayoutParams(newParams);
        return true;
    }
}
