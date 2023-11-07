package pesistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Domain.Model.hoaDon;

public class hoaDonDAOImpl implements HoaDonDAO{
    private Connection connection;
    public hoaDonDAOImpl(){
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLHD";
        String username = "sa";
        String password = "123456789";
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addHoaDon(hoaDon hoaDon) {

        String sql = "INSERT INTO sqlHoaDon(ngayHoaDon,tenKhachHang,maPhong,donGia) VALUES(?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            Date sqlDate = new Date(hoaDon.getNgayHoaDon().getTime());

            statement.setDate(1, sqlDate);
            statement.setString(2, hoaDon.getTenKhachHang());
            statement.setInt(3, hoaDon.getMaPhong());
            statement.setDouble(4, hoaDon.getDonGia());
        
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateHoaDon(hoaDon hoaDon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateHoaDon'");
    }
    @Override
    public void deleteHoaDon(int hoaDonID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteHoaDon'");
    }
    @Override
    public hoaDon findHoaDon(int hoaDonID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findHoaDon'");
    }
    @Override
    public List<hoaDon> docHoaDon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'docHoaDon'");
    }
}
