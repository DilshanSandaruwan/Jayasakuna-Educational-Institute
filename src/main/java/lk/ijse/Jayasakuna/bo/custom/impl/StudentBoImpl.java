package lk.ijse.Jayasakuna.bo.custom.impl;

import lk.ijse.Jayasakuna.bo.custom.StudentBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.StudentDAO;
import lk.ijse.Jayasakuna.dao.custom.SubjectDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.StudentDAOImpl;
import lk.ijse.Jayasakuna.dao.custom.impl.SubjectDAOImpl;
import lk.ijse.Jayasakuna.dto.StudentDTO;
import lk.ijse.Jayasakuna.dto.SubjectDTO;
import lk.ijse.Jayasakuna.entity.Student;
import lk.ijse.Jayasakuna.entity.Subject;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBoImpl implements StudentBO {

    StudentDAO studentDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Student);
    SubjectDAO subjectDAO =DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Subject);

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException {
        ArrayList<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> arrayList= new ArrayList<>();
        for (Student student : all) {
            arrayList.add(new StudentDTO(student.getStudentID(),student.getStudentName(),student.getAddress(),student.getPhoneNumber()));
        }
        return arrayList;
    }

    @Override
    public boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.save( new Student(dto.getSid(), dto.getSname(),dto.getSaddress(),dto.getSphone()));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.update(new Student(dto.getSid(),dto.getSname(),dto.getSaddress(),dto.getSphone()));
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(id);
    }

    @Override
    public String getIDStudent(String id) throws SQLException, ClassNotFoundException {
        Student student = studentDAO.getID(id);
        return String.valueOf(new StudentDTO(student.getStudentID(),student.getStudentName(),student.getAddress(),student.getPhoneNumber()));
    }

    @Override
    public String findIdByNameStudent(String subject) throws SQLException, ClassNotFoundException {
      return null;
    }

    @Override
    public String getIDSubject(Subject subid) throws SQLException, ClassNotFoundException {
        Subject subject = subjectDAO.getID(String.valueOf(subid));
        return String.valueOf(new SubjectDTO(subject.getSubjectID(),subject.getSubjectName(),subject.getHallNumber(),subject.getTime()));
    }
}
