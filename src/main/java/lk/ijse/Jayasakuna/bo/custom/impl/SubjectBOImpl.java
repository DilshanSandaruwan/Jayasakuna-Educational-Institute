package lk.ijse.Jayasakuna.bo.custom.impl;

import lk.ijse.Jayasakuna.bo.custom.SubjectBO;
import lk.ijse.Jayasakuna.dao.DAOFactory;
import lk.ijse.Jayasakuna.dao.custom.SubjectDAO;
import lk.ijse.Jayasakuna.dto.SubjectDTO;
import lk.ijse.Jayasakuna.entity.Subject;

import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectBOImpl implements SubjectBO {

    SubjectDAO subjectDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Subject);
    @Override
    public ArrayList<SubjectDTO> getAllSubject() throws SQLException, ClassNotFoundException {
        ArrayList<Subject> all = subjectDAO.getAll();
        ArrayList<SubjectDTO> arrayList= new ArrayList<>();
        for (Subject subject : all) {
            arrayList.add(new SubjectDTO(subject.getSubjectID(),subject.getSubjectName(),subject.getHallNumber(),subject.getTime()));
        }
        return arrayList;
    }

    @Override
    public boolean updateSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectDAO.update(new Subject(dto.getSubid(),dto.getSubname(),dto.getSubHallno(),dto.getSubtime()));
    }

    @Override
    public String getSubjectID(String s) throws SQLException, ClassNotFoundException {
        Subject t = subjectDAO.getID(s);
        return String.valueOf(new SubjectDTO(t.getSubjectID(),t.getSubjectName(),t.getHallNumber(),t.getTime()));
    }
}
