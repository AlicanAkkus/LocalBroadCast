package com.example.localbroadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

public class MyClass {
	public static final String LOCAL_NOTIFICATION_STRING = "my-local-notification";

	private static MyClass INSTANCE;
	private final Context context;

	private MyClass(final Context context) {
		this.context = context;
		LocalBroadcastManager.getInstance(context).registerReceiver(
				mMessageReceiver, new IntentFilter(LOCAL_NOTIFICATION_STRING));
	}

	public static MyClass getInstance(final Context context) {
		if (INSTANCE == null) {
			INSTANCE = new MyClass(context);
		}

		return INSTANCE;
	}

	public void unRegister() {
		LocalBroadcastManager.getInstance(context).unregisterReceiver(
				mMessageReceiver);
	}

	private final BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(final Context context, final Intent intent) {
			// TODO Auto-generated method stub
			final int duration = Toast.LENGTH_SHORT;
			final Toast toast = Toast.makeText(context,
					"Local Notification alindi..", duration);
			toast.show();
		}
	};
}
