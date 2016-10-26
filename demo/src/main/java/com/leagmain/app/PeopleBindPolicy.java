package com.leagmain.app;

import android.graphics.Color;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Leon on 10/26/2016.
 */

public class PeopleBindPolicy extends XListBindPolicy<People> {

    @Override
    public int getNormalRes() {
        return R.layout.people_item;
    }

    @Override
    public int getFooterRes() {
        return R.layout.load_more;
    }

    @Override
    public int getEmptyRes() {
        return R.layout.load_more;
    }

    @Override
    public void forNormal(View itemView, int position, People data) {
        itemView.findViewById(R.id.indicator).setBackgroundColor(
                data.getSex().equals("male") ? Color.BLUE : Color.MAGENTA);


        TextView name = (TextView) itemView.findViewById(R.id.name);
        name.setText(data.getName());


        TextView age = (TextView) itemView.findViewById(R.id.age);
        age.setText(data.getAge());


        AppCompatCheckedTextView sex = (AppCompatCheckedTextView) itemView.findViewById(R.id.sex);
        switch (String.valueOf(data.getSex())) {
            case "male":
                sex.setChecked(false);
                break;
            case "female":
                sex.setChecked(true);
                break;
        }
    }

    @Override
    public void forFooter(View footer) {

    }

    @Override
    public void forEmpty(View itemView) {

    }
}
