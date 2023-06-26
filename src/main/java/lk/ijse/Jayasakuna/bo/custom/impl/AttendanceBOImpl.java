package lk.ijse.Jayasakuna.bo.custom.impl;

import lk.ijse.Jayasakuna.bo.custom.AttendanceBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.AttendanceDAO;
import lk.ijse.Jayasakuna.dto.AttendanceDTO;
import lk.ijse.Jayasakuna.entity.Attendance;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceBOImpl implements AttendanceBO {

    AttendanceDAO attendanceDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Attendance);

    @Override
    public ArrayList<AttendanceDTO> getAllAttendance() throws SQLException, ClassNotFoundException {
        ArrayList<Attendance> all = attendanceDAO.getAll();
        ArrayList<AttendanceDTO> arrayList= new ArrayList<>();
        for (Attendance attendance : all) {
            arrayList.add(new AttendanceDTO(attendance.getStudentID(),attendance.getAttendID(),attendance.getDate(),attendance.getAttend()));
        }
        return arrayList;
    }

    @Override
    public boolean saveAttendance(AttendanceDTO attendanceDTO) throws SQLException, ClassNotFoundException {
        return attendanceDAO.save( new Attendance(attendanceDTO.getId(), attendanceDTO.getAttandId(),attendanceDTO.getAttend(),attendanceDTO.getDate()));
    }

    @Override
    public boolean updateAttendance(AttendanceDTO dto) throws SQLException, ClassNotFoundException {
       return attendanceDAO.update(new Attendance(dto.getId(),dto.getAttandId(),dto.getAttend(),dto.getDate()));
    }

    @Override
    public boolean deleteAttendance(String s) throws SQLException, ClassNotFoundException {
        return attendanceDAO.delete(s);
    }

    @Override
    public String getIDAttendance(String s) throws SQLException, ClassNotFoundException {
        Attendance t = attendanceDAO.getID(s);
        return String.valueOf(new Attendance(t.getStudentID(),t.getAttendID(),t.getAttend(),t.getDate()));
    }
}
