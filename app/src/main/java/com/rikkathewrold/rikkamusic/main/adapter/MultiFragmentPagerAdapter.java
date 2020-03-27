package com.rikkathewrold.rikkamusic.main.adapter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rikkathewrold.rikkamusic.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**FragmentPagerAdapter与FragmentStatePagerAdapter不同之处
 * FragmentStatePagerAdapter中fragment实例在destroyItem的时候被真正释放，
 * 所以FragmentStatePagerAdapter省内存。
 * FragmentPagerAdapter中的fragment实例在destroyItem的时候并没有真正释放
 * fragment对象只是detach，所以FragmentPagerAdapter消耗更多的内存，
 * 带来的好处就是效率更高一些。所以得出这样的结论：
 * FragmentPagerAdapter适用于页面比较少的情况，
 * FragmentStatePagerAdapter适用于页面比较多的情况

 * 多Fragment切换、高复用的PagerAdapter
 */
public class MultiFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "MultiFragmentPagerAdapt";

    private List<BaseFragment> fragments = new ArrayList<>();

    public MultiFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void init(List<BaseFragment> fragmentList) {
        fragments.clear();
        fragments.addAll(fragmentList);
    }

    @Override
    public Fragment getItem(int i) {
        if (fragments != null && i < fragments.size()) {
            return fragments.get(i);
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (getItem(position) instanceof BaseFragment) {
            return ((BaseFragment) getItem(position)).getTitle();
        }
        return super.getPageTitle(position);
    }
}
