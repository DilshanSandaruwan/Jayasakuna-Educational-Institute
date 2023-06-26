package lk.ijse.Jayasakuna.bo.custom;

import lk.ijse.Jayasakuna.bo.SuperBO;
import lk.ijse.Jayasakuna.dto.AttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceBO extends SuperBO {
    public ArrayList<AttendanceDTO> getAllAttendance() throws SQLException, ClassNotFoundException;

    public boolean saveAttendance(AttendanceDTO attendanceDTO) throws SQLException, ClassNotFoundException ;

    public boolean updateAttendance(AttendanceDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteAttendance(String s) throws SQLException, ClassNotFoundException ;

    public String getIDAttendance(String s) throws SQLException, ClassNotFoundException ;

}
