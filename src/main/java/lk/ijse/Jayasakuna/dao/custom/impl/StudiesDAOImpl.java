package lk.ijse.Jayasakuna.dao.custom.impl;

import lk.ijse.Jayasakuna.dao.custom.StudiesDAO;
import lk.ijse.Jayasakuna.dao.custom.impl.util.SQLUtil;
import lk.ijse.Jayasakuna.db.DBconnection;
import lk.ijse.Jayasakuna.dto.StudiesDTO;
import lk.ijse.Jayasakuna.entity.Studies;
import lk.ijse.Jayasakuna.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudiesDAOImpl implements StudiesDAO {

    public static Boolean save(ArrayList<StudiesDTO> list) throws SQLException {
        Boolean allSaved = true;
        for (StudiesDTO dto:list) {
            Boolean saved = CrudUtil.execute("INSERT INTO Studies VALUES(?,?,?)",dto.getStudentId(),dto.getSubjectId(),dto.getSubjectName());
            if (!saved){
                allSaved = false;
            }
        }
        return allSaved? true:false;
    }

    public static Boolean Update(ArrayList<StudiesDTO> list) throws SQLException {
        Boolean allSaved = true;
        for (StudiesDTO dto:list) {
            Boolean saved = CrudUtil.execute("UPDATE Studies SET SubjectID=?,SubjectName =? WHERE StudentID=?",dto.getSubjectId(),dto.getSubjectName(),dto.getStudentId());
            if (!saved){
                allSaved = false;
            }
        }
        return allSaved? true:false;
    }

    public static ArrayList<String> findAllBYStudentId(String id) throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Studies WHERE StudentID=?", id);
        ArrayList<String> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(resultSet.getString(3));
        }
        return list;
    }

    public static boolean delete(ArrayList<StudiesDTO>list) throws SQLException {

        Connection con = DBconnection.getInstance().getConnection();

        String sql = "DELETE  FROM Studies WHERE StudentID = ?";

        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1,list.get(0).getStudentId() );

        if (pstm.executeUpdate() > 0) {
            return true;

        } else {
          return false;
        }
    }
    public ArrayList<String> loadstudentId(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT StudentID FROM Student",id);
        ArrayList<String> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    @Override
    public ArrayList<Studies> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(Studies dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Studies dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Studies getID(String s) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public ArrayList<String> loadID(String id) throws SQLException {
        return null;
    }
}
