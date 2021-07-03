package hamza.bendahmane.SihatiMob;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.button.MaterialButton;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.IntStream;

import hamza.bendahmane.SihatiMob.R;

public class AddReminder extends Fragment {

    EditText editText,editText2 ,dname,ddesc,dtime,ddose;
    MaterialButton textView181 ,textView1811,textView1810,textView1812;

    public AddReminder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_reminder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        MainActivity.fragment_on = new AddReminder();
        editText = view.findViewById(R.id.editText);
        ddesc = view.findViewById(R.id.ddesc);
        dtime = view.findViewById(R.id.dtime);
        ddose = view.findViewById(R.id.ddose);
        dname = view.findViewById(R.id.dname);


        editText2 = view.findViewById(R.id.editText2);
        textView181 = view.findViewById(R.id.textView181);
        textView1812= view.findViewById(R.id.textView1812);
        textView1811 = view.findViewById(R.id.textView1811);
        textView1810 = view.findViewById(R.id.textView1810);

  view.findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          getActivity().onBackPressed();
      }
  });

  editText.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
              @Override
              public void onDateSet(DatePicker view, int year, int monthOfYear,
                                    int dayOfMonth) {
                  int s=monthOfYear+1;
                  String a = dayOfMonth+"/"+s+"/"+year;
                  editText.setText(""+a);
              }
          };

          Time date = new Time();
          DatePickerDialog d = new DatePickerDialog(getContext(), dpd, date.year ,date.month, date.monthDay);
          date.setToNow();
          d.show();
      }
  });

        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        int s=monthOfYear+1;
                        String a = dayOfMonth+"/"+s+"/"+year;
                        editText2.setText(""+a);
                    }
                };

                Time date = new Time();
                DatePickerDialog d = new DatePickerDialog(getContext(), dpd, date.year ,date.month, date.monthDay);
                date.setToNow();
                d.show();
            }
        });

        textView181.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener dpd = new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String a = hourOfDay+":"+minute;
                        textView181.setText(""+a);
                    }
                };

                Time date = new Time();
                TimePickerDialog d = new TimePickerDialog(getContext(),dpd,date.hour,date.minute,true);
                date.setToNow();
                d.show();

            }
        });

        textView1811.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener dpd = new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String a = hourOfDay+":"+minute;
                        textView1811.setText(""+a);
                    }
                };

                Time date = new Time();
                TimePickerDialog d = new TimePickerDialog(getContext(),dpd,date.hour,date.minute,true);
                date.setToNow();
                d.show();

            }
        });
        textView1810.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener dpd = new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String a = hourOfDay+":"+minute;
                        textView1810.setText(""+a);
                    }
                };

                Time date = new Time();
                TimePickerDialog d = new TimePickerDialog(getContext(),dpd,date.hour,date.minute,true);
                date.setToNow();
                d.show();

            }
        });

        textView1812.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener dpd = new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String a = hourOfDay+":"+minute;
                        textView1812.setText(""+a);
                    }
                };

                Time date = new Time();
                TimePickerDialog d = new TimePickerDialog(getContext(),dpd,date.hour,date.minute,true);
                date.setToNow();
                d.show();

            }
        });
        view.findViewById(R.id.materialButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("Are you sure ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                                Intent notificationIntent = new Intent(getContext(), AlarmReceiver.class);
                                Bundle b = new Bundle();
                                Calendar objCalendar = Calendar.getInstance();
                                String [] ht= textView181.getText().toString().split(":");
                                String [] dt = editText.getText().toString().split("/");
                                String [] dt2 = editText2.getText().toString().split("/");

                                Calendar c1 = Calendar.getInstance();
                                c1.set(Calendar.YEAR, Integer.parseInt(dt[2]));
                                c1.set(Calendar.MONTH, Integer.parseInt(dt[1]) -1);
                                c1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dt[0]));

                                Calendar c2 = Calendar.getInstance();
                                c2.set(Calendar.YEAR, Integer.parseInt(dt2[2]));
                                c2.set(Calendar.MONTH, Integer.parseInt(dt2[1]) -1);
                                c2.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dt2[0]));

                                Log.d("hbhb",getDatesBetween(c1.getTime(),c2.getTime()).toString());

                                objCalendar.set(Calendar.YEAR, Integer.parseInt(dt[2]));
                                objCalendar.set(Calendar.MONTH, Integer.parseInt(dt[1]) -1);
                                objCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dt[0]));
                                objCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(ht[0]));
                                objCalendar.set(Calendar.MINUTE, Integer.parseInt(ht[1]));
                                objCalendar.set(Calendar.SECOND, 0);
                                objCalendar.set(Calendar.MILLISECOND, 0);
                                //objCalendar.set(Calendar.AM_PM, Calendar.AM);
                                notificationIntent.putExtra("dname",dname.getText().toString().trim());
                                notificationIntent.putExtra("ddesc",ddesc.getText().toString().trim());
                                notificationIntent.putExtra("ddose",ddose.getText().toString().trim());
                                notificationIntent.putExtra("dtime",dtime.getText().toString().trim());

                                PendingIntent broadcast = PendingIntent.getBroadcast(getContext(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                                alarmManager.setExact(AlarmManager.RTC_WAKEUP, objCalendar.getTimeInMillis(), broadcast);
                            }
                        }).setNegativeButton("No",null).show();
            }
        });
    }
    public List<Date> getDatesBetween(
            Date startDate, Date endDate) {

            List<Date> datesInRange = new ArrayList<>();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(startDate);

            Calendar endCalendar = new GregorianCalendar();
            endCalendar.setTime(endDate);

            while (calendar.before(endCalendar)) {
                Date result = calendar.getTime();
                datesInRange.add(result);
                calendar.add(Calendar.DATE, 1);
            }
            return datesInRange;
    }
}