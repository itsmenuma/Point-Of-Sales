package Sales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_pcode;
	private JTextField txt_pname;
	private JTextField txt_price;
	private JTextField txt_amt;
	private JTextField txt_total;
	private JTextField txt_pay;
	private JTextField txt_balance;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pos frame = new pos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public pos() {
		setTitle("SALES POS AND PRINT  BILL\r\n");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(356, 10, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 24, 548, 189);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product code");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 26, 106, 13);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(132, 26, 106, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Qty");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(259, 26, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(326, 26, 45, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(401, 26, 85, 13);
		panel_1.add(lblNewLabel_4);
		
		txt_pcode = new JTextField();
		txt_pcode.setSelectedTextColor(Color.YELLOW);
		txt_pcode.setDisabledTextColor(Color.YELLOW);
		txt_pcode.setCaretColor(Color.YELLOW);
		txt_pcode.setForeground(UIManager.getColor("Button.highlight"));
		txt_pcode.setBackground(Color.BLACK);
		
		txt_pcode.addKeyListener(new KeyAdapter() {
		
			
			public void keyPressed(KeyEvent evt) {
				Connection con;
				PreparedStatement pst;
				ResultSet rs;
				
				 if(evt.getKeyCode() == KeyEvent.VK_ENTER)
			        {
			            String pcode = txt_pcode.getText();   
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                con = DriverManager.getConnection("jdbc:mysql://localhost/salespos","root","");
			                pst = con.prepareStatement("select * from product where id = ?");
			                pst.setString(1, pcode);
			                rs = pst.executeQuery();
			                
			                if(rs.next() == false)
			                {     
			                    JOptionPane.showInputDialog(this, "Product Code Not Found");  
			                }
			                else
			                {
			                    String pname = rs.getString("Product_name");
			                     String price = rs.getString("price");
			                     txt_pname.setText(pname.trim());
			                     txt_price.setText(price.trim());
			                }
			            } catch (ClassNotFoundException ex) {
			                Logger.getLogger(pos.class.getName()).log(Level.SEVERE, null, ex);
			            } catch (SQLException ex) {
			                Logger.getLogger(pos.class.getName()).log(Level.SEVERE, null, ex);
			            }
			        }
			    }
		});
		txt_pcode.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_pcode.setBounds(10, 49, 96, 19);
		panel_1.add(txt_pcode);
		txt_pcode.setColumns(10);
		
		txt_pname = new JTextField();
		txt_pname.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_pname.setBounds(132, 49, 96, 19);
		panel_1.add(txt_pname);
		txt_pname.setColumns(10);
		
		txt_price = new JTextField();
		txt_price.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_price.setBounds(326, 49, 55, 19);
		panel_1.add(txt_price);
		txt_price.setColumns(10);
		
		txt_amt = new JTextField();
		txt_amt.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_amt.setBounds(401, 49, 96, 19);
		panel_1.add(txt_amt);
		txt_amt.setColumns(10);

		JSpinner txt_qty = new JSpinner();
		txt_qty.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int qty=Integer.parseInt(txt_qty.getValue().toString());
				int price=Integer.parseInt(txt_price.getText());
				int tot=qty*price;
				txt_amt.setText(String.valueOf(tot));
			}
			
			
		});
		JTextArea txt_bill = new JTextArea();
		txt_bill.setCaretColor(new Color(0, 0, 0));
		txt_bill.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txt_bill.setBackground(new Color(255, 255, 255));
		txt_bill.setBounds(607, 233, 288, 205);
		contentPane.add(txt_bill);
		
		JButton PrintBill = new JButton("PrintBill");
		PrintBill.setFont(new Font("Tahoma", Font.BOLD, 15));
		PrintBill.addActionListener(new ActionListener() {
			public void Balance() {
				int total=Integer.parseInt(txt_total.getText());
				int pay=Integer.parseInt(txt_pay.getText());
				int bal=pay-total;
				txt_balance.setText(String.valueOf(bal));
			}
			public void bill()
			{
				String total=txt_total.getText();
				String pay=txt_pay.getText();
				String bal=txt_balance.getText();
				DefaultTableModel model = new DefaultTableModel();
		         model = (DefaultTableModel)table.getModel();
		         txt_bill.setText(txt_bill.getText()+"******************************************************\n");
		         txt_bill.setText(txt_bill.getText()+"	    POS BILL						\n");
		         txt_bill.setText(txt_bill.getText()+"******************************************************\n");
		         //heading
		         txt_bill.setText(txt_bill.getText()+"Product" + "\t" + "Price" + "\t" + "Amount" + "\n");
		         
		         for(int i = 0; i < model.getRowCount(); i++)
		          {
		              
		              String pname = (String)model.getValueAt(i, 1);
		              String price = (String)model.getValueAt(i, 3);
		              String amount = (String)model.getValueAt(i, 4); 
		              
		           txt_bill.setText(txt_bill.getText() + pname  + "\t" + price + "\t" + amount  + "\n"  );
		    
		          }
		         txt_bill.setText(txt_bill.getText() + "\n");     
		          
		          txt_bill.setText(txt_bill.getText() + "\t" + "\t" + "Subtotal :" + total + "\n");
		          txt_bill.setText(txt_bill.getText() + "\t" + "\t" + "Pay :" + pay + "\n");
		          txt_bill.setText(txt_bill.getText() + "\t" + "\t" + "Balance :" + bal + "\n");
		          txt_bill.setText(txt_bill.getText() + "\n");
		          txt_bill.setText(txt_bill.getText() + "*******************************************************\n");
		          txt_bill.setText(txt_bill.getText() + "THANK YOU COME AGIN             \n");
				
			}
			
			public void actionPerformed(ActionEvent e) {
				
				Balance();
				bill();
			}
			
		});
		
		txt_qty.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_qty.setBounds(255, 51, 34, 37);
		panel_1.add(txt_qty);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	 DefaultTableModel model = new DefaultTableModel();
		         model = (DefaultTableModel)table.getModel();
		         model.addRow(new Object[]
		                 
		         {
		             txt_pcode.getText(),
		             txt_pname.getText(),
		             txt_qty.getValue().toString(),
		             txt_price.getText(),
		             txt_amt.getText(),           
		         });   
		                 
		             int sum = 0;
		                     
		         for(int i = 0; i<table.getRowCount(); i++)
		         {
		             sum = sum + Integer.parseInt(table.getValueAt(i, 4).toString());
		         }
		         
		         txt_total.setText(Integer.toString(sum));
		            
		           txt_pcode.setText("");
		            txt_pname.setText("");
		            txt_price.setText("");
		            txt_amt.setText("");
		         txt_pcode.requestFocus();
		     
		    }
		});


		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(401, 85, 85, 21);
		panel_1.add(btnNewButton);
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 51, 255));
		panel_2.setBounds(581, 24, 314, 189);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("TOTAL");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(32, 10, 58, 13);
		panel_2.add(lblNewLabel_6);
		
		txt_total = new JTextField();
		txt_total.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_total.setBounds(32, 34, 96, 19);
		panel_2.add(txt_total);
		txt_total.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("PAY");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_7.setBounds(45, 122, 45, 13);
		panel_2.add(lblNewLabel_7);
		
		txt_pay = new JTextField();
		txt_pay.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_pay.setBounds(32, 145, 96, 19);
		panel_2.add(txt_pay);
		txt_pay.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("BALANCE");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(191, 55, 85, 13);
		panel_2.add(lblNewLabel_8);
		
		txt_balance = new JTextField();
		txt_balance.setBounds(191, 79, 96, 19);
		panel_2.add(txt_balance);
		txt_balance.setColumns(10);
		
		
		
		PrintBill.setBounds(166, 129, 138, 27);
		panel_2.add(PrintBill);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(64, 0, 64));
		scrollPane.setBounds(10, 234, 567, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(UIManager.getColor("Button.light"));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product Code", "Product Name", "Qty", "Price", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		table_1 = new JTable();
		table_1.setBounds(28, 438, 538, 0);
		contentPane.add(table_1);
		
		
	}
}
