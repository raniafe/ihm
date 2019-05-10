package com.example.gaspimiamva.fragments;

import android.Manifest;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.adapters.CustomListView;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static android.app.Activity.RESULT_OK;

public class CalenderFragment extends Fragment {

    public CalenderFragment() {
    }
    static final int GET_ACCOUNT_NAME_REQUEST = 1;  //
    EditText queryAccountResult ;
    View myView ;
    Button account;
    Button permission;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_calender, container, false);

        permission=myView.findViewById(R.id.request_permission);
        permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_CALENDAR,
                                Manifest.permission.WRITE_CALENDAR}, 1);
            }
        });
        account=myView.findViewById(R.id.query_account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = AccountPicker.newChooseAccountIntent(null, null,
                            new String[] { GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE }, false, null, null, null, null);
                    startActivityForResult(intent, GET_ACCOUNT_NAME_REQUEST );  //GET_ACCOUNT_NAME_REQUEST是一個自訂的int, 用作分辨所返回的結果
                } catch (ActivityNotFoundException e) {
                    // TODO
                }
            }
        });
        Button calender=myView.findViewById(R.id.query_calendar);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] EVENT_PROJECTION = new String[]{
                        CalendarContract.Calendars._ID,                             // 0 日歷ID
                        CalendarContract.Calendars.ACCOUNT_NAME,                // 1 日歷所屬的帳戶名稱
                        CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,       // 2 日歷名稱
                        CalendarContract.Calendars.OWNER_ACCOUNT,                  // 3 日歷擁有者
                        CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL,       // 4 對此日歷所擁有的權限
                };
                // 根據上面的設定，定義各資料的索引，提高代碼的可讀性
                int PROJECTION_ID_INDEX = 0;
                int PROJECTION_ACCOUNT_NAME_INDEX = 1;
                int PROJECTION_DISPLAY_NAME_INDEX = 2;
                int PROJECTION_OWNER_ACCOUNT_INDEX = 3;
                int PROJECTION_CALENDAR_ACCESS_LEVEL = 4;
                // 取得在EditText的帳戶名稱
                String targetAccount = ((EditText) myView.findViewById(R.id.account)).getText().toString();
                // 查詢日歷
                Cursor cur;
                ContentResolver cr = getActivity().getContentResolver();
                Uri uri = CalendarContract.Calendars.CONTENT_URI;
                // 定義查詢條件，找出屬於上面Google帳戶及可以完全控制的日歷
                String selection = "((" + CalendarContract.Calendars.ACCOUNT_NAME + " = ?) AND ("
                        + CalendarContract.Calendars.ACCOUNT_TYPE + " = ?) AND ("
                        + CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL + " = ?))";
                String[] selectionArgs = new String[]{targetAccount,
                        "com.google",
                        Integer.toString(CalendarContract.Calendars.CAL_ACCESS_OWNER)};
                // 因為targetSDK=25，所以要在Apps運行時檢查權限
                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_CALENDAR);
                // 建立List來暫存查詢的結果
                final List<String> accountNameList = new ArrayList<>();
                final List<Integer> calendarIdList = new ArrayList<>();
                // 如果使用者給了權限便開始查詢日歷
                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);
                    if (cur != null) {
                        while (cur.moveToNext()) {
                            long calendarId = 0;
                            String accountName = null;
                            String displayName = null;
                            String ownerAccount = null;
                            int accessLevel = 0;
                            // 取得所需的資料
                            calendarId = cur.getLong(PROJECTION_ID_INDEX);
                            accountName = cur.getString(PROJECTION_ACCOUNT_NAME_INDEX);
                            displayName = cur.getString(PROJECTION_DISPLAY_NAME_INDEX);
                            ownerAccount = cur.getString(PROJECTION_OWNER_ACCOUNT_INDEX);
                            accessLevel = cur.getInt(PROJECTION_CALENDAR_ACCESS_LEVEL);
                            Log.i("query_calendar", String.format("calendarId=%s", calendarId));
                            Log.i("query_calendar", String.format("accountName=%s", accountName));
                            Log.i("query_calendar", String.format("displayName=%s", displayName));
                            Log.i("query_calendar", String.format("ownerAccount=%s", ownerAccount));
                            Log.i("query_calendar", String.format("accessLevel=%s", accessLevel));
                            // 暫存資料讓使用者選擇
                            accountNameList.add(displayName);
                            calendarIdList.add((int) calendarId);
                        }
                        cur.close();
                    }
                    if (calendarIdList.size() != 0) {
                        // 建立一個Dialog讓使用者選擇日歷
                        AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
                        CharSequence items[] = accountNameList.toArray(new CharSequence[accountNameList.size()]);
                        adb.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText targetCalendarId = (EditText) myView.findViewById(R.id.calendar_id);
                                targetCalendarId.setText(String.format("%s", calendarIdList.get(which)));
                                dialog.dismiss();
                            }
                        });
                        adb.setNegativeButton("CANCEL", null);
                        adb.show();
                    }
                    else {
                        Toast toast = Toast.makeText(getActivity(), "找不到日歷", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getContext(), "沒有所需的權限", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        Button event=myView.findViewById(R.id.query_event);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String[] INSTANCE_PROJECTION = new String[]{
                            CalendarContract.Instances.EVENT_ID,      // 0 活動ID
                            CalendarContract.Instances.BEGIN,         // 1 活動開始日期時間
                            CalendarContract.Instances.TITLE,          // 2 活動標題
                    };
                    // 根據上面的設定，定義各資料的索引，提高代碼的可讀性
                    int PROJECTION_ID_INDEX = 0;
                    int PROJECTION_BEGIN_INDEX = 1;
                    int PROJECTION_TITLE_INDEX = 2;
                    // 取得在EditText的日歷ID
                    String targetCalendar = ((EditText)myView.findViewById(R.id.calendar_id)).getText().toString();
                    // 指定一個時間段，查詢以下時間內的所有活動
                    // 月份是從0開始，0-11
                    Calendar beginTime = Calendar.getInstance();
                    beginTime.set(2017, 0, 1, 8, 0);
                    long startMillis = beginTime.getTimeInMillis();
                    Calendar endTime = Calendar.getInstance();
                    endTime.set(2017, 4, 1, 8, 0);
                    long endMillis = endTime.getTimeInMillis();
                    // 查詢活動
                    Cursor cur = null;
                    ContentResolver cr = getActivity().getContentResolver();
                    Uri.Builder builder = CalendarContract.Instances.CONTENT_URI.buildUpon();
                    // 定義查詢條件，找出上面日歷中指定時間段的所有活動
                    String selection = CalendarContract.Events.CALENDAR_ID + " = ?";
                    String[] selectionArgs = new String[]{targetCalendar};
                    ContentUris.appendId(builder, startMillis);
                    ContentUris.appendId(builder, endMillis);
                    // 因為targetSDK=25，所以要在Apps運行時檢查權限
                    int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.READ_CALENDAR);
                    // 建立List來暫存查詢的結果
                    final List<Integer> eventIdList = new ArrayList<>();
                    final List<Long> beginList = new ArrayList<>();
                    final List<String> titleList = new ArrayList<>();
                    // 如果使用者給了權限便開始查詢日歷
                    if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                        cur = cr.query(builder.build(),
                                INSTANCE_PROJECTION,
                                selection,
                                selectionArgs,
                                null);
                        if (cur != null) {
                            while (cur.moveToNext()) {
                                long eventID = 0;
                                long beginVal = 0;
                                String title = null;
                                // 取得所需的資料
                                eventID = cur.getLong(PROJECTION_ID_INDEX);
                                beginVal = cur.getLong(PROJECTION_BEGIN_INDEX);
                                title = cur.getString(PROJECTION_TITLE_INDEX);
                                Log.i("query_event", String.format("eventID=%s", eventID));
                                Log.i("query_event", String.format("beginVal=%s", beginVal));
                                Log.i("query_event", String.format("title=%s", title));
                                // 暫存資料讓使用者選擇
                                eventIdList.add((int) eventID);
                                beginList.add((long) beginVal);
                                titleList.add(title);
                            }
                            cur.close();
                        }
                        if (eventIdList.size() != 0) {
                            // 建立一個Dialog讓使用者選擇活動
                            AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
                            CharSequence items[] = titleList.toArray(new CharSequence[titleList.size()]);
                            adb.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    EditText targetEventId = myView.findViewById(R.id.event_id);
                                    EditText targetStartDateTime = myView.findViewById(R.id.start_date_time);
                                    EditText targetTitle = myView.findViewById(R.id.title);
                                    targetEventId.setText(String.format("%s", eventIdList.get(which)));
                                    String startDateTime = DateFormat.getDateTimeInstance().format(beginList.get(which));
                                    targetStartDateTime.setText(startDateTime);
                                    targetTitle.setText(String.format("%s", titleList.get(which)));
                                    dialog.dismiss();
                                }
                            });
                            adb.setNegativeButton("CANCEL", null);
                            adb.show();
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity(), "找不到活動", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                    else {
                        Toast toast = Toast.makeText(getActivity(), "沒有所需的權限", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            });
        Button insert = myView.findViewById(R.id.insert_event);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String targetCalendarId = ((EditText) myView.findViewById(R.id.calendar_id)).getText().toString();
                long calendarId = Long.parseLong(targetCalendarId);
                // 取得現在的時間作為活動開始時間
                long currentTimeMillis = System.currentTimeMillis();
                // 設定活動結束時間為15分鐘後
                long endTimeMillis = currentTimeMillis + 900000;
                // 取得在EditText的標題
                String targetTitle = ((EditText) myView.findViewById(R.id.title)).getText().toString();
                // 新增活動
                ContentResolver cr = getActivity().getContentResolver();
                ContentValues values = new ContentValues();
                values.put(CalendarContract.Events.DTSTART, currentTimeMillis);
                values.put(CalendarContract.Events.DTEND, endTimeMillis);
                values.put(CalendarContract.Events.TITLE, targetTitle);
                values.put(CalendarContract.Events.DESCRIPTION, "Description");
                values.put(CalendarContract.Events.CALENDAR_ID, calendarId);
                values.put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().getDisplayName());
                // 因為targetSDK=25，所以要在Apps運行時檢查權限
                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.WRITE_CALENDAR);
                // 如果使用者給了權限便開始新增日歷
                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
                    // 返回新建活動的ID
                    if (uri != null) {
                        long eventID = Long.parseLong(uri.getLastPathSegment());
                        EditText targetEventId = (EditText) myView.findViewById(R.id.event_id);
                        targetEventId.setText(String.format("%s", eventID));
                    }
                }
            }
        });



        return myView;

    }


        @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == GET_ACCOUNT_NAME_REQUEST && resultCode == RESULT_OK) {
            String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME); // 使用者所選的帳戶名稱
            EditText queryAccountResult = (EditText) myView.findViewById(R.id.account);
            queryAccountResult.setText(accountName);
        }
    }






    public void update_event(View view) {
        // 取得在EditText的活動ID
        String targetEventId = ((EditText) myView.findViewById(R.id.event_id)).getText().toString();
        long eventId = Long.parseLong(targetEventId);
        // 取得在EditText的標題
        String targetTitle = ((EditText) myView.findViewById(R.id.title)).getText().toString();
        // 更新活動
        ContentResolver cr = getActivity().getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.TITLE, targetTitle);
        // 因為targetSDK=25，所以要在Apps運行時檢查權限
int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.WRITE_CALENDAR);
        // 如果使用者給了權限便開始更新日歷
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Uri uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, eventId);
            cr.update(uri, values, null, null);
        }
    }
    public void delete_event(View view) {
        // 取得在EditText的活動ID
        String targetEventId = ((EditText) myView.findViewById(R.id.event_id)).getText().toString();
        long eventId = Long.parseLong(targetEventId);
        // 刪除活動
        ContentResolver cr = getActivity().getContentResolver();
        // 因為targetSDK=25，所以要在Apps運行時檢查權限
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.WRITE_CALENDAR);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Uri uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, eventId);
            cr.delete(uri, null, null);
        }
    }


}
