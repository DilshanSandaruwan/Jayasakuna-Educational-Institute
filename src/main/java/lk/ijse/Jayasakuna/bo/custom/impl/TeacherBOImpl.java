package lk.ijse.Jayasakuna.bo.custom.impl;

import lk.ijse.Jayasakuna.bo.custom.TeacherBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.TeacherDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.TeacherDAOImpl;
import lk.ijse.Jayasakuna.dto.TeacherDTO;
import lk.ijse.Jayasakuna.entity.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherBOImpl implements TeacherBO {

    TeacherDAO teacherDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Teacher);

    @Override
    public ArrayList<TeacherDTO> getAllTeacher() throws SQLException, ClassNotFoundException {
            ArrayList<Teacher> all = teacherDAO.getAll();
            ArrayList<TeacherDTO> arrayList= new ArrayList<>();
            for (Teacher teacher : all) {
                arrayList.add(new TeacherDTO(teacher.getTeacherID(),teacher.getTeacherName(),teacher.getAddress(),teacher.getPhoneNumber()));
            }
            return arrayList;
        }

    @Override
    public boolean saveTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException {
            return teacherDAO.save( new Teacher(dto.getSid(), dto.getSname(),dto.getSaddress(),dto.getSphone()));
        }

    @Override
    public boolean updateTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException {
        return teacherDAO.update(new Teacher(dto.getSid(),dto.getSname(),dto.getSaddress(),dto.getSphone()));
    }

    @Override
    public boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException {
        return teacherDAO.delete(id);
    }

    @Override
    public String getIDTeacher(String id) throws SQLException, ClassNotFoundException {
        Teacher t = teacherDAO.getID(id);
        return String.valueOf(new TeacherDTO(t.getTeacherID(),t.getTeacherName(),t.getAddress(),t.getPhoneNumber()));
    }

}
