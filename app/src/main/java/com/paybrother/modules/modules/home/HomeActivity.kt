package com.paybrother.modules.modules.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mikepenz.iconics.typeface.FontAwesome
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.SectionDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.paybrother.R
import com.paybrother.modules.modules.masters.MastersFragment
import com.paybrother.modules.modules.reservations.ReservationsFragment


class HomeActivity : AppCompatActivity() {

    internal val MASTERS_ITEM = 0
    internal val RESERVATIONS_ITEM = 1
    internal val unidentified = 2
    internal val SETTINGS_ITEM = 3
    internal val ABOUT_ITEM = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        Drawer()
            .withActivity(this)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withHeader(R.layout.drawer_header)
            .addDrawerItems(

                PrimaryDrawerItem().withName(R.string.drawer_item_masters).withIcon(FontAwesome.Icon.faw_users).withBadge( "99").withIdentifier(MASTERS_ITEM),

                PrimaryDrawerItem().withName(R.string.drawer_item_reservations).withIcon(FontAwesome.Icon.faw_gamepad).withIdentifier(RESERVATIONS_ITEM),

                PrimaryDrawerItem().withName("unidentified").withIcon(FontAwesome.Icon.faw_eye).withBadge("6").withIdentifier(unidentified),

                SectionDrawerItem().withName(R.string.drawer_item_settings),

                SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog).withIdentifier(SETTINGS_ITEM),

                DividerDrawerItem(),

                SecondaryDrawerItem().withName(R.string.drawer_item_about).withIcon(FontAwesome.Icon.faw_home).withIdentifier(ABOUT_ITEM)
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener{
                override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long, drawerItem: IDrawerItem?) {
                    when(drawerItem?.identifier){

                        MASTERS_ITEM ->
                            supportFragmentManager.beginTransaction().addToBackStack(HomeFragment::class.java.name).replace(R.id.parent_container, MastersFragment()).commit()
                        RESERVATIONS_ITEM ->
                            supportFragmentManager.beginTransaction().addToBackStack(HomeFragment::class.java.name).replace(R.id.parent_container, ReservationsFragment()).commit()

                    }
                }
            })
            .build()

        supportFragmentManager?.beginTransaction()?.add(
            R.id.parent_container,
            HomeFragment()
        )?.commit()
    }
}
