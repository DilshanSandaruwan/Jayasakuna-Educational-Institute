package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.AttendanceDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.util.SQLUtil;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.entity.Attendance;

import java.sql.*;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendanceDAO {

    @Override
    public ArrayList<Attendance> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Attendance> data = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM Attendance");

        while (resultSet.next()) {
            data.add(new Attendance(resultSet.getString(1), resultSet.getString(2), String.valueOf(resultSet.getDouble(3)), resultSet.getDate(4)));
        }
        return data;
    }

    @Override
    public boolean save(Attendance attendanceDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Attendance(StudentID, AttendID, Attend, Date)"+ "VALUES(?, ?, ?, ?)",attendanceDTO.getStudentID(),attendanceDTO.getAttendID(),attendanceDTO.getDate(),attendanceDTO.getAttend());
    }

    @Override
    public boolean update(Attendance dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Attendance SET StudentID =?,Attend =? , Date=? WHERE AttendID = ?",dto.getStudentID(),dto.getAttendID(),dto.getDate(),dto.getAttend());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Attendance WHERE AttendID = ?",s);
    }

    @Override
    public Attendance getID(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("select * from Attendance where AttendID = ?",s);
        if (rst.next()) {
            return new Attendance(rst.getString(1), rst.getString(2), rst.getString(3),rst.getDate(4));
        }
        return null;
    }


    @Override
    public ArrayList<String> loadID(String id) throws SQLException {
        return null;
    }

}
