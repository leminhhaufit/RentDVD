/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import DAO.TieudeDAO;
import Entity.Tieude;

/**
 *
 * @author Minh Hau
 */
public class ThemtieudeGD extends javax.swing.JFrame {

	TieudeDAO tddao = new TieudeDAO();
    /**
     * Creates new form ThemtieudeGD
     */
    public ThemtieudeGD() {
        initComponents();
        try {
			txtTrangthai.setText("Còn hàng");
			capnhatcomboboxLoaiDVD();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        txtGiathue.addKeyListener(new KeyListener() {
				
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String giathue = txtGiathue.getText().trim();
		         if(giathue.length()==0){
		            lbMessGiaThue.setText("");
		        }else{
		            if(!(giathue.length()>0 && giathue.matches("^[1-9]{1}\\d+"))){
		            	lbMessGiaThue.setText("Giá thuê có số đầu khác 0");

		           }else{
		        	   lbMessGiaThue.setText("");
		            }
		         }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        txtPhitrehan.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String giathue = txtPhitrehan.getText().trim();
		         if(giathue.length()==0){
		            lbMessPhitrehan.setText("");
		        }else{
		            if(!(giathue.length()>0 && giathue.matches("^[1-9]{1}\\d+"))){
		            	lbMessPhitrehan.setText("Phí trễ hạn có số đầu khác 0");

		           }else{
		        	   lbMessPhitrehan.setText("");
		            }
		         }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        txtHanThue.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String hanthue = txtHanThue.getText().trim();
		         if(hanthue.length()==0){
		            lbMessHanthue.setText("");
		        }else{
		            if(!(hanthue.length()>0 && hanthue.matches("^[1-9]{1}\\d+"))){
		            	lbMessHanthue.setText("Hạn thuê có số đầu khác 0");

		           }else{
		        	   lbMessHanthue.setText("");
		            }
		         }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        txtTentieude.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				String tentieude = txtTentieude.getText().trim();
		        if (tentieude.length() == 0) {
		            lbMessTenTieude.setText("");
		        } else {
		        	 if (!(tentieude.length() > 0 && tentieude.matches("^[A-Z]{1}[A-Z\\p{L}\\d,. -]*"))) {
		        		 lbMessTenTieude.setText("Viết hoa chữ cái đầu và có cách nhau");
		            } else {
		            	lbMessTenTieude.setText("");
		            }
		        }
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        txtMota.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String mota = txtMota.getText().trim();
			       if(mota .length()==0){
			            lbMessMota.setText("");
			        }else{
			            if(!(mota.length()>0 && mota.matches("[A-Z\\p{L}\\d,. ]+"))){
			            	lbMessMota.setText("Không chứa kí tự đặt biết");
			             }else{
			            	 lbMessMota.setText("");
			            }
			       }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        btnThemKH.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				double giathue = Double.valueOf(txtGiathue.getText());
		        int hanthue = Integer.valueOf(txtHanThue.getText());
		        String loai = (String) cbxLoaidvd.getSelectedItem();
				String tentieude = txtTentieude.getText();
				String mota = txtMota.getText();
				String trangthai = txtTrangthai.getText();
				double phitrehan = Double.valueOf(txtPhitrehan.getText());
				int soluong =0;
				Tieude td = new Tieude(tentieude, giathue, hanthue, soluong, phitrehan, loai, mota, trangthai);
				
				 
				if(!(txtTentieude.getText().equalsIgnoreCase("")&& txtPhitrehan.getText().equalsIgnoreCase("") && txtMota.getText().equalsIgnoreCase("") && txtGiathue.getText().equalsIgnoreCase("") && txtHanThue.getText().equalsIgnoreCase(""))) {
					if(vaildData()==true) {
						try {
							if(tddao.addTieude(td)==true) {
								txtTentieude.setText("");
								txtMota.setText("");
								txtPhitrehan.setText("");
								txtGiathue.setText("");
								txtHanThue.setText("");
								JOptionPane.showMessageDialog(null, "Thêm tiêu đề thành công !");
								
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Không được để trống!");
				}
				
			}
		});
        	btnThoat.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemtieudeGD.this.setVisible(false);
				
			}
		});
        
    }
   
    private void capnhatcomboboxLoaiDVD() throws Exception {
        
        cbxLoaidvd.addItem("Phim");
        cbxLoaidvd.addItem("Game");
        
        
    }
 
    	private boolean vaildData(){
    		  String tentieude = txtTentieude.getText().trim();
    	        
    	        String mota = txtMota.getText().trim();
            
            String giathue = txtGiathue.getText().trim();
            String phitrehan = txtPhitrehan.getText().trim();
            String hanthue = txtHanThue.getText().trim();
            String loai = (String) cbxLoaidvd.getSelectedItem();
            
            
            
            if(!(tentieude.length()>0 && tentieude.matches("(^[A-Z]{1}[\\p{L}\\s]+)[A-Z]{1}[\\p{L}\\s]+"))){
                lbMessTenTieude.setText("Tên tiêu đề không hợp lệ");
                
                return false;
            }
            if(!(mota.length()>0 && mota.matches("[A-Z\\p{L}\\d,. ]+"))){
                lbMessMota.setText("Mô tả không hợp lệ");
                return false;
            }
            if(!(phitrehan.length()>0 && phitrehan.matches("^[1-9]{1}\\d+"))){
                lbMessGiaThue.setText("Phí trễ hạn không hợp lệ");
                
                return false;
            }if(!(giathue.length()>0 && giathue.matches("^[1-9]{1}\\d+"))){
                lbMessGiaThue.setText("Giá thuê không hợp lệ");
                
                return false;
            }
            if(!(hanthue.length()>0 && hanthue.matches("^[1-9]{1}\\d+"))){
                lbMessHanthue.setText("Hạn thuê không hợp lệ");
                return false;
            }
           
            lbMessPhitrehan.setText("");
            lbMessGiaThue.setText("");
            lbMessHanthue.setText("");
            lbMessTenTieude.setText("");
            lbMessMota.setText("");
            
            return true;
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            pnChinh = new javax.swing.JPanel();
            lbTieude = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            txtTentieude = new javax.swing.JTextField();
            txtMota = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            btnThoat = new javax.swing.JButton();
            btnThemKH = new javax.swing.JButton();
            lbMessTenTieude = new javax.swing.JLabel();
            lbMessMota = new javax.swing.JLabel();
            txtHanThue = new javax.swing.JTextField();
            cbxLoaidvd = new javax.swing.JComboBox<>();
            txtGiathue = new javax.swing.JTextField();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            lbMessHanthue = new javax.swing.JLabel();
            lbMessGiaThue = new javax.swing.JLabel();
            lbMessPhitrehan = new javax.swing.JLabel();
            txtPhitrehan = new javax.swing.JTextField();
            jLabel8 = new javax.swing.JLabel();
            txtTrangthai = new javax.swing.JLabel();
            setTitle("Phần mềm cho thuê đĩa");
         	//dat cua so giua man hinh
            setLocationRelativeTo(null);
            //khong cho phong to cua so
            setResizable(false);

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            lbTieude.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
            lbTieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbTieude.setText("THÊM TIÊU ĐỀ");

            jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel2.setText("Tên tiêu đề:");

            txtTentieude.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

            txtMota.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

            jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel3.setText("Mô tả tiêu đề:");

            jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel4.setText("Trạng thái:");

            btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\exit.png")); // NOI18N
            btnThoat.setText("Thoát");
            btnThoat.setPreferredSize(new java.awt.Dimension(220, 100));

            btnThemKH.setIcon(new javax.swing.ImageIcon("D:\\Workspace\\XayDungPM\\XDPMDemo\\icon\\title.png")); // NOI18N
            btnThemKH.setText("Thêm tiêu đề");
            btnThemKH.setPreferredSize(new java.awt.Dimension(220, 100));

            lbMessTenTieude.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
            lbMessTenTieude.setForeground(new java.awt.Color(255, 0, 0));

            lbMessMota.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
            lbMessMota.setForeground(new java.awt.Color(255, 0, 0));

            txtHanThue.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

            cbxLoaidvd.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

            txtGiathue.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

            jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel5.setText("Giá thuê:");

            jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
            jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel6.setText("Hạn thuê:");

            jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
            jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel7.setText("Loại DVD:");

            lbMessHanthue.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
            lbMessHanthue.setForeground(new java.awt.Color(255, 0, 0));

            lbMessGiaThue.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
            lbMessGiaThue.setForeground(new java.awt.Color(255, 0, 0));

            lbMessPhitrehan.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
            lbMessPhitrehan.setForeground(new java.awt.Color(255, 0, 0));

            txtPhitrehan.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

            jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
            jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            jLabel8.setText("Phí trễ hạn:");

            txtTrangthai.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

            javax.swing.GroupLayout pnChinhLayout = new javax.swing.GroupLayout(pnChinh);
            pnChinh.setLayout(pnChinhLayout);
            pnChinhLayout.setHorizontalGroup(
                pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnChinhLayout.createSequentialGroup()
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnChinhLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbTieude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnChinhLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnChinhLayout.createSequentialGroup()
                                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbMessGiaThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtHanThue)
                                        .addComponent(lbMessHanthue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPhitrehan)))
                                .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbMessTenTieude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTentieude, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                                    .addGroup(pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMota, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                            .addComponent(lbMessMota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createSequentialGroup()
                                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnThemKH, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnChinhLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbMessPhitrehan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxLoaidvd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGap(0, 102, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            pnChinhLayout.setVerticalGroup(
                pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnChinhLayout.createSequentialGroup()
                    .addComponent(lbTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTentieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbMessTenTieude, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbMessMota, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lbMessGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHanThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbMessHanthue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhitrehan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lbMessPhitrehan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxLoaidvd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(txtTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(38, 38, 38)
                    .addGroup(pnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>                        

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(ThemtieudeGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(ThemtieudeGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(ThemtieudeGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(ThemtieudeGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ThemtieudeGD().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton btnThemKH;
        private javax.swing.JButton btnThoat;
        private javax.swing.JComboBox<String> cbxLoaidvd;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel lbMessGiaThue;
        private javax.swing.JLabel lbMessHanthue;
        private javax.swing.JLabel lbMessMota;
        private javax.swing.JLabel lbMessPhitrehan;
        private javax.swing.JLabel lbMessTenTieude;
        private javax.swing.JLabel lbTieude;
        private javax.swing.JPanel pnChinh;
        private javax.swing.JTextField txtGiathue;
        private javax.swing.JTextField txtHanThue;
        private javax.swing.JTextField txtMota;
        private javax.swing.JTextField txtPhitrehan;
        private javax.swing.JTextField txtTentieude;
        private javax.swing.JLabel txtTrangthai;
        // End of variables declaration                   
}
