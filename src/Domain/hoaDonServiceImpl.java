package Domain;

import java.util.List;

import Domain.Model.hoaDon;
import pesistence.HoaDonDAO;
import pesistence.hoaDonDAOImpl;


public class hoaDonServiceImpl implements hoaDonService{
    private HoaDonDAO hoaDonDAO;
    public hoaDonServiceImpl(){
        hoaDonDAO = new hoaDonDAOImpl();
    }
    @Override
    public void addHoaDon(hoaDon hoaDon) {
        hoaDonDAO.addHoaDon(hoaDon);
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
    public List<hoaDon> loadHoaDon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadHoaDon'");
    }
    
}
