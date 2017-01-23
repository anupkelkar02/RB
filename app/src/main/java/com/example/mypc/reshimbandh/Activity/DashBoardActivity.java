package com.example.mypc.reshimbandh.Activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.reshimbandh.Database.Database;
import com.example.mypc.reshimbandh.Fragments.CancelMembershipFragment;
import com.example.mypc.reshimbandh.Fragments.ChnagePasswordFragment;
import com.example.mypc.reshimbandh.Fragments.DailyRecmFragment;
import com.example.mypc.reshimbandh.Fragments.DashBoardFragment;
import com.example.mypc.reshimbandh.Fragments.EditProfileFragment;
import com.example.mypc.reshimbandh.Fragments.FeedbackFragment;
import com.example.mypc.reshimbandh.Fragments.LoginFragment;
import com.example.mypc.reshimbandh.Fragments.OnlinePaymentFragment;
import com.example.mypc.reshimbandh.Fragments.PayFeeFragment;
import com.example.mypc.reshimbandh.Fragments.RegisterSmsFragment;
import com.example.mypc.reshimbandh.Fragments.UploadPhotoFragment;
import com.example.mypc.reshimbandh.Others.InterestTabFragment;
import com.example.mypc.reshimbandh.Others.MatchListTabFragment;
import com.example.mypc.reshimbandh.Others.SearchTabFragment;
import com.example.mypc.reshimbandh.Others.TabFragment;
import com.example.mypc.reshimbandh.R;

import java.util.HashMap;

public class DashBoardActivity extends AppCompatActivity {
    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    TextView txt_sec_info,txt_name;

    private static final String TABLE_LOGIN_ID = "id";
    private static final String TABLE_LOGIN_USERNAME = "username";
    private static final String TABLE_LOGIN_EMAIL = "email";
    private static final String TABLE_LOGIN_NAME = "name";
    private static final String TABLE_LOGIN_AGE = "age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Initializing NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View hView =  navigationView.getHeaderView(0);
        txt_name = (TextView)hView.findViewById(R.id.txt_name);
        txt_sec_info = (TextView)hView.findViewById(R.id.txt_sec_info);
        final Database db = new Database(getApplicationContext());
        HashMap user = db.getCurrentUser();
        if (user.isEmpty()){
            txt_name.setText(user.get(TABLE_LOGIN_USERNAME).toString());
            txt_sec_info.setText("Age: "+user.get(TABLE_LOGIN_AGE).toString());
        }
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame,new TabFragment()).commit();
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.menu_pay_fee:
                       // Toast.makeText(getApplicationContext(), "My Matches", Toast.LENGTH_SHORT).show();
                        PayFeeFragment payFeeFragment = new PayFeeFragment();
                        android.support.v4.app.FragmentTransaction payfeetransition = getSupportFragmentManager().beginTransaction();
                        payfeetransition.replace(R.id.frame,payFeeFragment);
                        payfeetransition.commit();
                        return true;
                    // For rest of the options we just show a toast on click

                    case R.id.menu_upload_photo:
                        Toast.makeText(getApplicationContext(), "Daily Recommendation", Toast.LENGTH_SHORT).show();
                        UploadPhotoFragment uploadPhotoFragment = new UploadPhotoFragment();
                        android.support.v4.app.FragmentTransaction uploadfragmentTransaction = getSupportFragmentManager().beginTransaction();
                        uploadfragmentTransaction.replace(R.id.frame,uploadPhotoFragment);
                        uploadfragmentTransaction.commit();
                        return true;
                    case R.id.menu_edit_profile:
                        Toast.makeText(getApplicationContext(), "Edit Profile", Toast.LENGTH_SHORT).show();
                        EditProfileFragment editProfileFragment = new EditProfileFragment();
                        android.support.v4.app.FragmentTransaction loginfragmentTransaction = getSupportFragmentManager().beginTransaction();
                        loginfragmentTransaction.replace(R.id.frame,editProfileFragment);
                        loginfragmentTransaction.commit();

                        return true;
                    case R.id.manu_search:
                        Toast.makeText(getApplicationContext(), "Mail Box", Toast.LENGTH_SHORT).show();
                        mFragmentManager = getSupportFragmentManager();
                         mFragmentTransaction = mFragmentManager.beginTransaction();
                         mFragmentTransaction.replace(R.id.frame,new SearchTabFragment()).commit();
                        return true;
                    case R.id.menu_match_list:
                        Toast.makeText(getApplicationContext(), "Mail Box", Toast.LENGTH_SHORT).show();
                        mFragmentManager = getSupportFragmentManager();
                         mFragmentTransaction = mFragmentManager.beginTransaction();
                         mFragmentTransaction.replace(R.id.frame,new MatchListTabFragment()).commit();
                        return true;
                    case R.id.menu_interest_received:
                        Toast.makeText(getApplicationContext(), "Mail Box", Toast.LENGTH_SHORT).show();
                        mFragmentManager = getSupportFragmentManager();
                         mFragmentTransaction = mFragmentManager.beginTransaction();
                         mFragmentTransaction.replace(R.id.frame,new InterestTabFragment()).commit();
                        return true;
                    case R.id.menu_interest_sent:
                        Toast.makeText(getApplicationContext(), "Mail Box", Toast.LENGTH_SHORT).show();
                        mFragmentManager = getSupportFragmentManager();
                         mFragmentTransaction = mFragmentManager.beginTransaction();
                         mFragmentTransaction.replace(R.id.frame,new InterestTabFragment()).commit();
                        return true;
                    case R.id.menu_feedback:
                        Toast.makeText(getApplicationContext(), "Feedback", Toast.LENGTH_SHORT).show();
                        FeedbackFragment feedbackFragment = new FeedbackFragment();
                        android.support.v4.app.FragmentTransaction feedbackfragmentTransaction = getSupportFragmentManager().beginTransaction();
                        feedbackfragmentTransaction.replace(R.id.frame,feedbackFragment);
                        feedbackfragmentTransaction.commit();
                        return true;
                    case R.id.menu_register_sms:
                        Toast.makeText(getApplicationContext(), "Menu Setting", Toast.LENGTH_SHORT).show();
                        RegisterSmsFragment registerSmsFragment = new RegisterSmsFragment();
                        android.support.v4.app.FragmentTransaction registerfragmentTransaction = getSupportFragmentManager().beginTransaction();
                        registerfragmentTransaction.replace(R.id.frame,registerSmsFragment);
                        registerfragmentTransaction.commit();

                        return true;
                     case R.id.menu_online_payment:
                        Toast.makeText(getApplicationContext(), "Online Payment", Toast.LENGTH_SHORT).show();
                         OnlinePaymentFragment onlinePaymentFragment = new OnlinePaymentFragment();
                        android.support.v4.app.FragmentTransaction onlinefragmentTransaction = getSupportFragmentManager().beginTransaction();
                         onlinefragmentTransaction.replace(R.id.frame,onlinePaymentFragment);
                         onlinefragmentTransaction.commit();

                        return true;
                    case R.id.menu_chnage_password:
                        Toast.makeText(getApplicationContext(), "Change Password", Toast.LENGTH_SHORT).show();
                        ChnagePasswordFragment chnagePasswordFragment = new ChnagePasswordFragment();
                        android.support.v4.app.FragmentTransaction changefragmentTransaction = getSupportFragmentManager().beginTransaction();
                        changefragmentTransaction.replace(R.id.frame,chnagePasswordFragment);
                        changefragmentTransaction.commit();

                        return true;
                    case R.id.menu_cancel_membership:
                        Toast.makeText(getApplicationContext(), "Cancel Membership", Toast.LENGTH_SHORT).show();
                        CancelMembershipFragment cancelMembershipFragment = new CancelMembershipFragment();
                        android.support.v4.app.FragmentTransaction cancelfragmentTransaction = getSupportFragmentManager().beginTransaction();
                        cancelfragmentTransaction.replace(R.id.frame,cancelMembershipFragment);
                        cancelfragmentTransaction.commit();

                        return true;
                    case R.id.menu_logout:
                        Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                        Intent log = new Intent(DashBoardActivity.this,LoginActivity.class);
                        startActivity(log);
                        db.logout();
                        finish();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
       // drawerLayout = (DrawerLayout) findViewById(R.id.drawel);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_dash_board);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
          //  return true;
        //}

        return super.onOptionsItemSelected(item);
    }
}