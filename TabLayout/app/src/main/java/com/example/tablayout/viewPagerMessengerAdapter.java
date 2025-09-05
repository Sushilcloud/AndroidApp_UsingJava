package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerMessengerAdapter extends FragmentPagerAdapter {

//when load fragment on runtime - by activity refrence
    public viewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {
        return new ChatFragment();
        }else if(position==1)
        {
            return new StatusFragment();
        }else{
            return new CallsFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    // method for title on tab
  // Remove it because method will be use  @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
      //  return super.getPageTitle(position);
        if(position==0){
            return "Chat";
        }else
            if(position==1){
            return "Status";
        }else{
            return "Calls";
        }
    }
}
