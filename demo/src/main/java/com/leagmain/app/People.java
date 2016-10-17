package com.leagmain.app;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by leagmain on 10/17/2016.
 */

public class People {

    private String name;
    private String age;
    private String sex;

    public People(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static class BindPolicy extends XListPolicy {

        public BindPolicy(@LayoutRes int layout) {
            super(layout);
        }

        @Override
        protected XListPresenter forField(String field) {
            switch (field) {
                case "name":
                    return new XListPresenter<TextView>(R.id.name) {
                        @Override
                        public void show(TextView view, Object name) {
                            view.setText(name.toString());
                        }
                    };
                case "age":
                    return new XListPresenter<TextView>(R.id.age) {
                        @Override
                        public void show(TextView view, Object age) {
                            view.setText(age.toString());
                        }
                    };
                case "sex":
                    return new XListPresenter<AppCompatCheckedTextView>(R.id.sex) {
                        @Override
                        public void show(AppCompatCheckedTextView view, Object value) {
                            switch (String.valueOf(value)) {
                                case "male":
                                    view.setChecked(false);
                                    break;
                                case "female":
                                    view.setChecked(true);
                                    break;
                            }
                        }
                    };
                default:
                    return null;
            }
        }

        @Override
        public void forOthers(View itemView, Object data) {
            itemView.findViewById(R.id.indicator).setBackgroundColor(
                    ((People) data).getSex().equals("male") ? Color.BLUE : Color.MAGENTA);
        }
    }
}
