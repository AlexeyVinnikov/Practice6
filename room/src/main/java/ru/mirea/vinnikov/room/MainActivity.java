package ru.mirea.vinnikov.room;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = ru.mirea.vinnikov.room.MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ru.mirea.vinnikov.room.AppDatabase db = ru.mirea.vinnikov.room.App.getInstance().getDatabase();
        ru.mirea.vinnikov.room.EmployeeDao employeeDao = db.employeeDao();
        ru.mirea.vinnikov.room.Employee employee = new ru.mirea.vinnikov.room.Employee();
        employee.id = 1;
        employee.name = "John Smith";
        employee.salary = 10000;
// запись сотрудников в базу
        employeeDao.insert(employee);
// Загрузка всех работников
        List<ru.mirea.vinnikov.room.Employee> employees = employeeDao.getAll();
// Получение определенного работника с id = 1
        employee = employeeDao.getById(1);
// Обновление полей объекта
        employee.salary = 20000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.salary);
    }
}