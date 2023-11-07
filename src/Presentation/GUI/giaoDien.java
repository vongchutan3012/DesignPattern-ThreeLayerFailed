package Presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import Domain.hoaDonService;
import Domain.hoaDonServiceImpl;
import Domain.Model.hoaDonGio;
import Presentation.Controller.CommandProcessor;
import Presentation.Controller.addCommand;

public class giaoDien extends JFrame implements ActionListener{
	//Field
	private JTable table_hoaDon;
	private DefaultTableModel table_Model;
	private JLabel lb_maHoaDon;
	private JLabel lb_maPhong;
	private JLabel lb_ngayLapHoaDon;
	private JLabel lb_tenKhachHang;
	private JLabel lb_donGia;
	private JLabel lb_soGioThue;
	private JLabel lb_soNgayThue;
	private JLabel lb_thanhTien;
	private JLabel lb_loaiHoaDon;
	private JComboBox<String> cb_loaiHoaDon;
	private JTextField txt_maHoaDon;
	private JTextField txt_maPhong;
	private JTextField txt_ngayLapHoaDon;
	private JTextField txt_tenKhachHang;
	private JTextField txt_donGia;
	private JTextField txt_soGioThue;
	private JTextField txt_soNgayThue;
	private JTextField txt_thanhTien;
	private JButton addButton;
	private JButton deleteButton;
	private JButton findButton;
	private JButton updateButton;
	private JButton resetButton;

	private Date ngayLapHoaDon;
	private String tenKhachHang;
	private int maPhong;
	private double donGia;
	private hoaDonService hoaDonService;
	private CommandProcessor commandProcessor;
	//Constructor
    public giaoDien()
    {
        InitializeComponents();
    }
	//Methods
    private void InitializeComponents()
    {
		commandProcessor = new CommandProcessor();
		hoaDonService = new hoaDonServiceImpl();
		//label
		lb_loaiHoaDon = new JLabel("Loại Hoá Đơn");
		lb_maHoaDon = new JLabel("Mã Hoá Đơn");
		lb_maPhong = new JLabel("Mã Phòng");
		lb_ngayLapHoaDon = new JLabel("Ngày Lập Hoá Đơn");
		lb_tenKhachHang = new JLabel("Tên Khách Hàng");
		lb_donGia = new JLabel("Đơn Giá");
		lb_soGioThue = new JLabel("Số Giờ Thuê");
		lb_soNgayThue = new JLabel("Số Ngày Thuê");
		lb_thanhTien = new JLabel("Thành Tiền");

		//textfield
		txt_maHoaDon = new JTextField(5);
		txt_maPhong = new JTextField(5);
		txt_ngayLapHoaDon = new JTextField(20);
		txt_tenKhachHang = new JTextField(20);
		txt_donGia = new JTextField(10);
		txt_soGioThue = new JTextField(5);
		txt_soNgayThue = new JTextField(5);
		txt_thanhTien = new JTextField(10);

		//comboBox
		cb_loaiHoaDon = new JComboBox<>(new String[]{
			"Hoá Đơn Giờ","Hoá Đơn Ngày"
		});
		
		//button
		addButton = new JButton("Thêm");
		addButton.addActionListener(this);
		deleteButton = new JButton("Xoá");
		updateButton = new JButton("Cập nhật");
		resetButton = new JButton("Làm mới");
		findButton = new JButton("Tìm Kiếm");

		//table setup
		String [] dulieuTable = {"Mã Hoá Đơn","Mã Phòng","Ngày Lập Hoá Đơn","Tên Khách Hàng","Đơn Gía","Số Giờ Thuê","Số Ngày Thuê","Thành Tiền"};
		table_Model = new DefaultTableModel(dulieuTable,0);
		table_hoaDon = new JTable(table_Model);


		//Layout setup
		JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

		inputPanel.add(lb_loaiHoaDon,gbc);
		gbc.gridx++;

		inputPanel.add(cb_loaiHoaDon,gbc);
		gbc.gridy++;
		gbc.gridx=0;

        inputPanel.add(lb_maHoaDon, gbc);
        gbc.gridx++;

       	inputPanel.add(txt_maHoaDon,gbc);
		gbc.gridy++;
		gbc.gridx=0;

		inputPanel.add(lb_maPhong,gbc);
		gbc.gridx++;

		inputPanel.add(txt_maPhong,gbc);
		gbc.gridy++;
		gbc.gridx=0;

		inputPanel.add(lb_ngayLapHoaDon,gbc);
		gbc.gridx++;

		inputPanel.add(txt_ngayLapHoaDon,gbc);
		gbc.gridy++;
		gbc.gridx=0;

		inputPanel.add(lb_tenKhachHang,gbc);
		gbc.gridx++;

		inputPanel.add(txt_tenKhachHang,gbc);
		gbc.gridy++;
		gbc.gridx=0;

		inputPanel.add(lb_donGia);
		gbc.gridx++;

		inputPanel.add(txt_donGia);
		gbc.gridy++;
		gbc.gridx=0;

		inputPanel.add(lb_soGioThue);
		gbc.gridx++;

		inputPanel.add(txt_soGioThue);
		gbc.gridy++;
		gbc.gridy=0;

		inputPanel.add(lb_soNgayThue);
		gbc.gridx++;

		inputPanel.add(txt_soNgayThue);
		gbc.gridy++;
		gbc.gridy=0;

		inputPanel.add(lb_thanhTien);
		gbc.gridx++;

		inputPanel.add(txt_thanhTien);

		JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
		buttonPanel.add(resetButton);
        buttonPanel.add(findButton);

		JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(table_hoaDon), BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
       	mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.setTitle("Hệ thống quản lý hoá đơn");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.add(mainPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton){
			this.addHoaDon();
		}
	}
	public void addHoaDon(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			ngayLapHoaDon = dateFormat.parse(txt_ngayLapHoaDon.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tenKhachHang = txt_tenKhachHang.getText();
		maPhong =Integer.parseInt(txt_maPhong.getText());
		donGia = Double.parseDouble(txt_donGia.getText());
		hoaDonGio hoaDonGio = new hoaDonGio(1, ngayLapHoaDon, tenKhachHang, maPhong, donGia, 6);
		
		commandProcessor.execute(new addCommand(hoaDonService, hoaDonGio));
	}
}
