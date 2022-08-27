package customerAdminService;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.jmdns.ServiceInfo;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import com.google.type.Color;
import java.awt.Color;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import java.awt.Font;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import co2MonitoringService.*;
import customerAdminService.CustomerAdminServiceGrpc.CustomerAdminServiceBlockingStub;
import customerAdminService.CustomerAdminServiceGrpc.CustomerAdminServiceStub;
import co2MonitoringService.Co2MonitoringServiceGrpc.Co2MonitoringServiceBlockingStub;
import co2MonitoringService.Co2MonitoringServiceGrpc.Co2MonitoringServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import taxPaymentService.AmountTotalDueGrpc;
import taxPaymentService.ListRequest;
import taxPaymentService.ListResponse;
import taxPaymentService.PaymentRequest;
import taxPaymentService.PaymentResponse;
import taxPaymentService.TaxPaymentsRequest;
import taxPaymentService.TaxPaymentsResponse;
import customerAdminService.CalculateRequest.VehicleType;

import java.awt.SystemColor;


public class governanceServiceGUI implements ActionListener {

	//private JFrame frame;
	private JTextArea textResponse;

	private JPanel contentPane;
	/////TEST
	//declare an array list of customer List
	public static ArrayList <String> customerList = null;

	//Customer Admin Service
	private static CustomerAdminServiceBlockingStub adminBlockingStub;
	private static CustomerAdminServiceStub adminAsyncStub;
	private ServiceInfo adminServiceInfo;

	//CustomerAdminService Monitoring Service
	private static Co2MonitoringServiceBlockingStub monitoringBlockingStub;
	private static Co2MonitoringServiceStub monitoringAsyncStub;
	private ServiceInfo monitoringServiceInfo;
	//stubs
	private static AmountTotalDueGrpc.AmountTotalDueBlockingStub AmountTotalDueBlockingStub;
	private static AmountTotalDueGrpc.AmountTotalDueStub AmountTotalDueAsyncStub;
	///Test

	private ServiceInfo reportServiceInfo;
	private ServiceInfo totalDueServiceInfo;

	private JFrame frame;

	//Panel Customer Administration Service
	private JTextField txt_CustomerName;
	private JTextField txt_CustomerTaxNo;
	private ButtonGroup btn_Group;
	private JRadioButton rdbtn_annual;
	private JRadioButton rdbtn_quarterly;
	private JRadioButton rdbtn_monthly;
	private JTextArea txtArea_custDetails;
	////Variable
	private String custName = "";
	private String custTaxNo = "";
	private String custPaymentType = "";
	private String selectedItem;
	private Integer numberVehicle = (int)0.00;

	private JSeparator separatorAdmin;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_custName;
	//private JTextField txt_custName;
	private JTextField txt_noVehicle;
	JTextArea textArea_totalCost;

	private JSeparator separatorCo2;

	//private JTextField txt_band;
	private JTextField txt_diastolic;
	private JTextField txt_bpCategory;

	//Panel Retrive Tax Payment Service
	JTextArea textArea_showTemp;
	private JTextField txt_setTemp;
	Integer setTemp = null;

	private javax.swing.JButton balanceBtn;
	///Payments buttons
	private javax.swing.JTextField balanceTf;
	private javax.swing.JTextArea confirmTf;
	private JTextField txt_band;
	private JTextField textField_2;

//	private static AmountTotalDueGrpc.AmountTotalDueBlockingStub balanceBlockingStub;
//	private static AmountTotalDueGrpc.AmountTotalDueStub balanceAsyncStub;


	///TEST
	public static void disableWarning() {
		System.err.close();
		System.setErr(System.out);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					governanceServiceGUI window = new governanceServiceGUI();
					window.frame.setVisible(true);
					disableWarning();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//////////////////
	public governanceServiceGUI() {

		//check if the array list customerList is empty
		if (customerList==null)

			//initalize a new Array List customerList
			customerList = new ArrayList<String>();

		//Discovering Customer Administration Service (based on service_type)
		String administration_service_type = "_administration._tcp.local.";
		discoveyCustomerAdministrationService(administration_service_type);
		int adminPort = adminServiceInfo.getPort();

		//@SuppressWarnings("deprecation")
		String adminHost = adminServiceInfo.getHostAddresses()[0];
		//int adminPort = adminServiceInfo.getPort();

		ManagedChannel adminChannel = ManagedChannelBuilder
				.forAddress(adminHost, adminPort)
				.usePlaintext()
				.build();

		adminBlockingStub = CustomerAdminServiceGrpc.newBlockingStub(adminChannel);
		adminAsyncStub = CustomerAdminServiceGrpc.newStub(adminChannel);
		//////////////////////////////////////////////////////
		//Discovering Co2 Monitoring Service (based on service_type)
		//////////////////////////////////////////////////////////
		String monitoring_service_type = "_monitoring._tcp.local.";
		discoveryCo2MonitoringService(monitoring_service_type);
		int monitoringPort = monitoringServiceInfo.getPort();
		@SuppressWarnings("deprecation")
		String monitoringHost = monitoringServiceInfo.getHostAddresses()[0];
		ManagedChannel monitoringChannel = ManagedChannelBuilder
				.forAddress(monitoringHost, monitoringPort)
				.usePlaintext()
				.build();

		monitoringBlockingStub = Co2MonitoringServiceGrpc.newBlockingStub(monitoringChannel);
		monitoringAsyncStub = Co2MonitoringServiceGrpc.newStub(monitoringChannel);

		/////////////////////////////////////////
		//////// discovering Payment service      //////////
		//////////////////////////////////////////////
		String payment_service_type = "_payment._tcp.local.";
		discoverTotalDueService(payment_service_type);
		int paymentPort = 50074; //port
		String paymentHost = "localhost"; //totalDueServiceInfo.getHostAddresses()[0];
		ManagedChannel balanceChannel = ManagedChannelBuilder
				.forAddress(paymentHost, paymentPort)
				.usePlaintext()
				.build();
		//AmountTotal stubs -- generated from proto
		AmountTotalDueBlockingStub = AmountTotalDueGrpc.newBlockingStub(balanceChannel);
		AmountTotalDueAsyncStub = AmountTotalDueGrpc.newStub(balanceChannel);

		initialize();
	}
	//////////////////////////////////////////////////
	//// Discovery Payments
	//////////////////////////////////////////////////////
	private void discoverTotalDueService(String service_type) {
		try {
			// Create a JmDNS instance
			System.out.println(JmDNS.VERSION);
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener(service_type, new ServiceListener() {

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Total Due Service resolved: " + event.getInfo());
					totalDueServiceInfo = event.getInfo();
					int port = totalDueServiceInfo.getPort();

				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Total Due Service removed: " + event.getInfo());

				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Total Due Service added: " + event.getInfo());

				}
			});
			// Wait a bit
			Thread.sleep(2000);
			jmdns.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
//////////////////////////////////////////////////
//// Discovery Co2MonitoringService
//////////////////////////////////////////////////////

	private void discoveryCo2MonitoringService(String service_type) {

		try {
			//Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener(){

				//@SuppressWarnings("deprecation")
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Co2 Monitoring Service resolved: " + event.getInfo());

					monitoringServiceInfo = event.getInfo();
					int port = monitoringServiceInfo.getPort();

					System.out.println("Resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type: " + event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + monitoringServiceInfo.getNiceTextString());
					System.out.println("\t host: " + monitoringServiceInfo.getHostAddresses());
					System.out.println("--------------------------------------------------\n");
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Co2 Monitoring Service removed: " + event.getInfo());
					System.out.println("--------------------------------------------------\n");
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Co2 Monitoring Service added: " + event.getInfo());
					System.out.println("--------------------------------------------------\n");
				}
			});

			//Wait a bit
			Thread.sleep(1500);

			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//////////////////////////////////////////////////
	////Discovery Customer
	//////////////////////////////////////////////////////
	private void discoveyCustomerAdministrationService(String service_type) {

		try {
			//Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener(){

				//@SuppressWarnings("deprecation")
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Customer Admin Service resolved: " + event.getInfo());

					adminServiceInfo = event.getInfo();
					int port = adminServiceInfo.getPort();

					System.out.println("Resolving " + service_type + "with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type: " + event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + adminServiceInfo.getNiceTextString());
					System.out.println("\t host: " + adminServiceInfo.getHostAddresses());
					System.out.println("--------------------------------------------------\n");
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Customer Admin Service removed: " +event.getInfo());
					System.out.println("--------------------------------------------------\n");
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Customer Admin Service added: " +event.getInfo());
					System.out.println("--------------------------------------------------\n");
				}
			});

			//Wait a bit
			Thread.sleep(2000);
			jmdns.close();
		}
		catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.setBounds(100, 100, 690, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 50, 660, 495);
		frame.getContentPane().add(tabbedPane);

		//Label App. Title
		JLabel lbl_appTitle = new JLabel("Smart Governance");
		lbl_appTitle.setForeground(Color.WHITE);
		lbl_appTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_appTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_appTitle.setBounds(190, 5, 300, 35);
		frame.getContentPane().add(lbl_appTitle);

		/////////////////////////////////////////////////////////////////////////////////
		/// Customer Admin Service        ///////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////

		//Panel Admin Service
		JPanel panel_administration = new JPanel();
		panel_administration.setBackground(SystemColor.inactiveCaptionBorder);
		panel_administration.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_administration.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPane.addTab("Customer Administration Service", null, panel_administration, "Vehicle Service");
		panel_administration.setLayout(null);

		/////////////////////////
		/// Register Customers ///
		/////////////////////////

		//Main Label Customer Registering Service
		JLabel lbl_administrationService = new JLabel("Customer Registration Service");
		lbl_administrationService.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_administrationService.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_administrationService.setBounds(138, -2, 360, 30);
		panel_administration.add(lbl_administrationService);

		//Lbl Customer name
		JLabel lbl_CustomerName = new JLabel("Name Surname");
		lbl_CustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_CustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CustomerName.setBounds(10, 55, 140, 30);
		panel_administration.add(lbl_CustomerName);

		//TextField Customer Name
		txt_CustomerName = new JTextField();
		txt_CustomerName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtArea_custDetails.setText("");
			}
		});
		txt_CustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_CustomerName.setBounds(20, 85, 200, 35);
		panel_administration.add(txt_CustomerName);
		txt_CustomerName.setColumns(10);

		//Label age
		JLabel lbl_CustomerAge = new JLabel("Tax No");
		lbl_CustomerAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_CustomerAge.setBounds(250, 52, 70, 30);
		panel_administration.add(lbl_CustomerAge);

		//TextField  age
		txt_CustomerTaxNo = new JTextField();
		txt_CustomerTaxNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_CustomerTaxNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtArea_custDetails.setText("");
			}
		});

		txt_CustomerTaxNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				//validate number only
				int key = e.getKeyCode();
				if((key>=KeyEvent.VK_0 && key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE){
					txt_CustomerTaxNo.setEditable(true);
				}

				else{
					//show message
					JOptionPane.showMessageDialog(null, "Please Enter numbers only");
					txt_CustomerTaxNo.setEditable(true);
					txt_CustomerTaxNo.setText("");
					txt_CustomerTaxNo.requestFocus();
				}
			}
		});
		txt_CustomerTaxNo.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_CustomerTaxNo.setBounds(235, 85, 113, 35);
		panel_administration.add(txt_CustomerTaxNo);
		txt_CustomerTaxNo.setColumns(10);

		//Label Customer Gender
		JLabel lbl_CustomerGender = new JLabel("Payment:");
		lbl_CustomerGender.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbl_CustomerGender.setBounds(387, 19, 80, 30);
		panel_administration.add(lbl_CustomerGender);

		//Radio Button Annual
		rdbtn_annual = new JRadioButton("Annual");
		rdbtn_annual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtn_annual.setBounds(377, 44, 112, 25);
		panel_administration.add(rdbtn_annual);

		//Radio Button Quarterly
		rdbtn_quarterly = new JRadioButton("Quarterly");
		rdbtn_quarterly.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtn_quarterly.setBounds(377, 72, 112, 25);
		panel_administration.add(rdbtn_quarterly);

		///Radio Button Monthly
		rdbtn_monthly = new JRadioButton("Monthly");
		rdbtn_monthly.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtn_monthly.setBounds(377, 99, 112, 25);
		panel_administration.add(rdbtn_monthly);

		btn_Group = new ButtonGroup();

		btn_Group.add(rdbtn_annual);
		btn_Group.add(rdbtn_quarterly);
		btn_Group.add(rdbtn_monthly);

		JButton btn_register = new JButton("Add");
		btn_register.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//check if the custName text field is empty
				if (txt_CustomerName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter Customer Name");
					txt_CustomerName.requestFocus();
				}

				//check if the custAge text field is empty
				else if (txt_CustomerTaxNo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter Customer Tax Number");
					txt_CustomerTaxNo.requestFocus();
				}

				else if(btn_Group.getSelection()==null){
					JOptionPane.showMessageDialog(null, "Please select Payment Method");
				}

				else {

					custName = txt_CustomerName.getText();
					custTaxNo = txt_CustomerTaxNo.getText();

					if(rdbtn_annual.isSelected()){
						custPaymentType = "annual";
					}
					if(rdbtn_quarterly.isSelected()){
						custPaymentType = "quarterly";
					}
					else if (rdbtn_monthly.isSelected()){
						custPaymentType = "monthly";
					}

					txt_CustomerName.setText("");
					txt_CustomerTaxNo.setText("");
					btn_Group.clearSelection();


					StreamObserver<RegisterResponse> responseObserver = new StreamObserver<RegisterResponse>() {

						@Override
						public void onNext(RegisterResponse value) {

							//Register Customer
							System.out.println("Server responded: Customer registered with,\n" +value.getResult());

							txtArea_custDetails.append(value.getResult());

							// GUI multiLine
							customerList.add(value.getResult() + "\n");
							comboBox_custName.addItem(custName);

						}

						@Override
						public void onError(Throwable t) {
							t.printStackTrace();
						}

						@Override
						public void onCompleted() {
							System.out.println("Customer registration completed.");
							System.out.println("-------------------------------\n");
						}
					};

					StreamObserver<RegisterRequest> requestObserver = adminAsyncStub.registerCustomers(responseObserver);
					requestObserver.onNext(RegisterRequest.newBuilder()
							.setName(custName)
							.setTaxNo(custTaxNo)
							.setPaymentType(custPaymentType)
							.build());

					//Mark the end of requests
					requestObserver.onCompleted();
				}
			}
		});
		btn_register.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_register.setBounds(495, 55, 140, 30);
		panel_administration.add(btn_register);

		//////////////////////////
		/// Show Customers list ///
		//////////////////////////

		////ButtonCustomers list
		JButton btn_custList = new JButton("Print List");
		btn_custList.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_custList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_custList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtArea_custDetails.setText("");

				//check if Array List is empty
				if (customerList.isEmpty()){
					JOptionPane.showMessageDialog(null,"The List is empty please Submit first!");
					txt_CustomerName.requestFocus();
				}

				else{

					System.out.println("Server responded; Customer list is printed: ");
					DisplayRequest request = DisplayRequest.newBuilder().setCustomerList(customerList.toString()).build();
					StreamObserver<DisplayResponse> responseObserver = new StreamObserver<DisplayResponse>() {

						@Override
						public void onNext(DisplayResponse value) {

						}

						@Override
						public void onError(Throwable t) {
							t.printStackTrace();
						}

						@Override
						public void onCompleted() {
							System.out.println("Customer list displayed has been completed.");
							System.out.println("--------------------------------------------------------\n");
						}
					};

					for (String s : customerList) {

						//Display Customer list
						txtArea_custDetails.append(s);
						System.out.println(s);
					}

					adminAsyncStub.displayCustomers(request, responseObserver);
				}
			}
		});
		btn_custList.setBounds(495, 85, 140, 35);
		panel_administration.add(btn_custList);

		//TextArea Customer Details
		txtArea_custDetails = new JTextArea();
		txtArea_custDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//txtArea_custDetails.setBounds(-13, 0, 385, 75);
		txtArea_custDetails.setBounds(63, 57, 649, 83);
		txtArea_custDetails.setEditable(false); //  not editable
		panel_administration.add(txtArea_custDetails);

		//Scrollview Text Area
		JScrollPane scroll = new JScrollPane(txtArea_custDetails);
		scroll.setSize(620, 85);
		scroll.setLocation(15, 135);
		panel_administration.add(scroll);

		//separator Admin
		separatorAdmin = new JSeparator();
		separatorAdmin.setBackground(Color.BLACK);
		separatorAdmin.setBounds(5, 235, 645, 2);
		panel_administration.add(separatorAdmin);

		/////////////////////////////////////////////////////////////////////////////////////////////////////
		/// Calculate Customer vehicle cost ////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////

		//Main Label Calculate Customer Accommodation price
		JLabel lbl_calculatePrice = new JLabel("Calculate Vehicle  Cost ");
		lbl_calculatePrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_calculatePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calculatePrice.setBounds(160, 250, 320, 30);
		panel_administration.add(lbl_calculatePrice);

		//Label Customer name
		JLabel lbl_custName = new JLabel("Customer Name");
		lbl_custName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_custName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_custName.setBounds(20, 290, 150, 30);
		panel_administration.add(lbl_custName);

		//Combo box select the Customer's name
		comboBox_custName = new JComboBox();
		comboBox_custName.setBackground(Color.WHITE);
		comboBox_custName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (custName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "The List is empty Please add a Customer.");
				}
				else {
					selectedItem = comboBox_custName.getSelectedItem().toString();

					if (selectedItem.equals("Select a Customer")) {
						JOptionPane.showMessageDialog(null, "Please select a Customer.");
					}

					else {
						selectedItem = comboBox_custName.getSelectedItem().toString();
					}
				}
			}
		});
		comboBox_custName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_custName.setModel(new DefaultComboBoxModel(new String[] {"Select Customer"}));
		comboBox_custName.setBounds(20, 320, 200, 35);
		panel_administration.add(comboBox_custName);


		//Lbl No. Vehicle
		JLabel lbl_noDays = new JLabel("No. Vehicle");
		lbl_noDays.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_noDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_noDays.setBounds(232, 290, 93, 35);
		panel_administration.add(lbl_noDays);

		//TextField
		txt_noVehicle = new JTextField();
		txt_noVehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_noVehicle.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_noVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_totalCost.setText(null);

			}
		});

		txt_noVehicle.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				//validate numbers only source https://stackoverflow.com/questions/20673804/keytyped-event-doesnt-recognize-colon-key
				int key = e.getKeyCode();
				if((key>=KeyEvent.VK_0 && key<=KeyEvent.VK_9)||(key>=KeyEvent.VK_NUMPAD0&&key<=KeyEvent.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE){
					txt_noVehicle.setEditable(true);
				}
				else{
					//display JoptionPane message
					JOptionPane.showMessageDialog(null, "Please Enter numbers only");
					txt_noVehicle.setEditable(true);
					txt_noVehicle.setText("");
					txt_noVehicle.requestFocus();
				}
			}
		});
		txt_noVehicle.setBounds(250, 320, 55, 35);
		panel_administration.add(txt_noVehicle);
		txt_noVehicle.setColumns(10);

		//Label Vehicle type cost
		JLabel lbl_piceDay = new JLabel("Vehicle Type");
		lbl_piceDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_piceDay.setBounds(335, 290, 100, 30);
		lbl_piceDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_administration.add(lbl_piceDay);

		//Combobox of Vehicle type
		JComboBox comboBox_price = new JComboBox();
		comboBox_price.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_price.setModel(new DefaultComboBoxModel(new String[] {"DIESEL", "ELECTRIC", "PETROL"}));
		comboBox_price.setBounds(330, 320, 150, 35);
		panel_administration.add(comboBox_price);

		//Btn calculate Vehicle type
		JButton btn_totalPrice = new JButton("Calculate");
		btn_totalPrice.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_totalPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_totalPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_totalCost.setText("");
				selectedItem = comboBox_custName.getSelectedItem().toString();
				if (selectedItem.equals("Select a Customer")) {
					JOptionPane.showMessageDialog(null, "Please select a Customer");
				}
				//check if Vehicle is empty
				else if (txt_noVehicle.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the Number of Vehicle");
					txt_noVehicle.requestFocus();
				}

				else {
					selectedItem = comboBox_custName.getSelectedItem().toString();
					custName = selectedItem;
					numberVehicle = Integer.parseInt(txt_noVehicle.getText());

					int indexPrice = comboBox_price.getSelectedIndex();
					VehicleType vehicleType = VehicleType.forNumber(indexPrice);

					CalculateRequest request = CalculateRequest.newBuilder()
							.setCustomerName(custName)
							.setNumberVehicle(numberVehicle)
							.setVehicleType(vehicleType)
							.build();

					CalculateResponse response = adminBlockingStub.calculatePrice(request);

					textArea_totalCost.append(response.getMessage());
					System.out.println("Server responded; Customer's Vehicle calculated,\n"
							+ response.getMessage());

					System.out.println("Calculation of the Customer's Vehicle completed.");
					System.out.println("-----------------------------------------------------------\n");
				}
			}
		});
		btn_totalPrice.setBounds(501, 320, 134, 35);
		panel_administration.add(btn_totalPrice);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 370, 615, 86);
		panel_administration.add(scrollPane_2);

		////Customer Calculation
		textArea_totalCost = new JTextArea();
		scrollPane_2.setViewportView(textArea_totalCost);
		textArea_totalCost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textArea_totalCost.setEditable(false);

		/////////////////////////////////////////////
		/// Co2 Monitoring Service            ///
		/////////////////////////////////////////////

		JPanel panel_monitoring = new JPanel();
		panel_monitoring.setBackground(SystemColor.menu);
		panel_monitoring.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_monitoring.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPane.addTab("Co2 Monitoring Service", null, panel_monitoring, "Monitoring Service");
		panel_monitoring.setLayout(null);

		/// Auto-renewal Payment On/Off

		//Main Label Activate Tax Auto-renewal
		JLabel lbl_monitoringService = new JLabel("Activate Tax Auto-renewal Payment");
		lbl_monitoringService.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_monitoringService.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_monitoringService.setBounds(175, 15, 342, 30);
		panel_monitoring.add(lbl_monitoringService);

		//Lbl Change Status
		JLabel lbl_changeStatus = new JLabel("Auto Renewal");
		lbl_changeStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_changeStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_changeStatus.setBounds(27, 79, 140, 30);
		panel_monitoring.add(lbl_changeStatus);

		//device status
		JLabel lbl_infoStatus = new JLabel("Autorenewal Status:");
		lbl_infoStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_infoStatus.setBounds(379, 44, 191, 30);
		panel_monitoring.add(lbl_infoStatus);

		//separator Co2
		separatorCo2 = new JSeparator();
		separatorCo2.setBackground(Color.BLACK);
		separatorCo2.setBounds(5, 200, 645, 2);
		panel_monitoring.add(separatorCo2);

		JComboBox comboOperation = new JComboBox();
		comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		comboOperation.setBounds(177, 82, 70, 30);
		panel_monitoring.add(comboOperation);

		JTextArea textResponse = new JTextArea(3, 20);
		textResponse.setWrapStyleWord(true);
		textResponse.setLineWrap(true);
		textResponse.setBounds(317, 85, 309, 72);
		panel_monitoring.add(textResponse);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(177, 123, 70, 30);
		panel_monitoring.add(btnOk);

		JTextArea finalTextResponse = textResponse;
		JLabel lbl_monitoringService_1 = new JLabel("Co2 BAND Converter");
		lbl_monitoringService_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_monitoringService_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_monitoringService_1.setBounds(175, 211, 342, 30);
		panel_monitoring.add(lbl_monitoringService_1);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int index = comboOperation.getSelectedIndex();
				boolean input=false;
				input= index == 0;

				System.out.println("Input: "+input);

				PowerRequest request= PowerRequest.newBuilder().setPower(input).build();

				// sending message request & receiving response
				PowerResponse response=	monitoringBlockingStub.powerSwitch(request);

				//print server response

				if(response.getPower()) {
					System.out.println("Server response: Auto-renewal turned ON ");
					finalTextResponse.append("Server response: Auto-renewal turned ON \n");

				}
				else {
					System.out.println("Server response: Auto-renewal turned OFF ");
					finalTextResponse.append("Server response: Auto-renewal turned OFF \n");

				}
			}
		});
		////////////////////////////
		/////CO2 EMISSIONS value
		///////////////////////////

		JButton btn_submit = new JButton("Submit");
		btn_submit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				float oxigeneValue = (float) 0.00;


				//check if txt_band is empty
				if (txt_band.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Pleae enter CO2 EMISSIONS value, the field can not be empty");
					txt_band.requestFocus();
				}

				else {

					//read data from text fields
					oxigeneValue = Float.parseFloat(txt_band.getText());


					StreamObserver<Co2Response> responseObserver = new StreamObserver<Co2Response>() {

						@Override
						public void onNext(Co2Response value) {
							textField_2.setText(" " + value.getResult());
							System.out.println("Server responded: The CO2 EMISSIONS: " + value.getResult());
						}

						@Override
						public void onError(Throwable t) {
							t.printStackTrace();
						}

						@Override
						public void onCompleted() {
							System.out.println("Band check completed.");
							System.out.println("-------------------------------\n");
						}
					};

					StreamObserver<Co2Request> requestObserver = monitoringAsyncStub.co2Emission(responseObserver);
					requestObserver.onNext(Co2Request.newBuilder().setCarbon(oxigeneValue).build());

					////end requests
					requestObserver.onCompleted();
				}
			}
		});
		btn_submit.setBounds(440, 375, 125, 35);
		panel_monitoring.add(btn_submit);


		//panel_1.add(btnOk);
		textResponse = new JTextArea(3, 20);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textResponse);


		///////////////////////////////////////////////////////////////////
		/////Check Tax panel balance  ////////////////////////////////////
		////////////////////////////////////////////////////////////////
		///panel balance
		JPanel balancePanel = new JPanel();
		panel_monitoring.setBackground(SystemColor.menu);
		panel_monitoring.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_monitoring.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPane.addTab("Payments", null, balancePanel, "Monitoring Service");
		balancePanel.setLayout(null);

		JLabel lblCheckpayments = new JLabel();
		lblCheckpayments.setBounds(10, 26, 153, 17);
		lblCheckpayments.setText("Check amount due");
		lblCheckpayments.setFont(new Font("Tahoma", Font.BOLD, 14));
		balancePanel.add(lblCheckpayments);

		balanceTf = new javax.swing.JTextField();

		JLabel confirmTtl = new JLabel();
		confirmTtl.setBounds(341, 141, 131, 17);
		confirmTtl.setText("Tax Due dates:");
		confirmTtl.setFont(new Font("Tahoma", Font.BOLD, 14));
		balancePanel.add(confirmTtl);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(160, 171, 485, 115);
		balancePanel.add(scrollPane_5);
		confirmTf = new javax.swing.JTextArea();
		scrollPane_5.setViewportView(confirmTf);
		confirmTf.setWrapStyleWord(true);
		confirmTf.setRows(5);
		confirmTf.setFont(new Font("Tahoma", Font.ITALIC, 12));
		confirmTf.setColumns(20);

		JButton confirmBtn_old = new JButton();
		confirmBtn_old.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StreamObserver<TaxPaymentsResponse> responseObserver = new StreamObserver<TaxPaymentsResponse>() {

					int count = 0;

					@Override
					public void onNext(TaxPaymentsResponse confirm) {
						count += 1;
						if (count == 1) {
							confirmTf.removeAll();
						} else {
							System.out.println(count);
						}
						System.out.println("Receiving tax payment dates ");
						confirmTf.append("\n\n there is a tax payment due on " + confirm.getTaxPayments() + "\n ");
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();

					}

					@Override
					public void onCompleted() {
						System.out.println("Stream is completed. Above dates are tax payments due");
					}

				};

				StreamObserver<TaxPaymentsRequest> requestObserver = AmountTotalDueAsyncStub.confirmTaxPayments(responseObserver);

				try {

					requestObserver.onNext(TaxPaymentsRequest.newBuilder().setTaxPayments("1/5/22")
							.build());
					Thread.sleep(2000);
					requestObserver.onNext(TaxPaymentsRequest.newBuilder().setTaxPayments("1/6/22")
							.build());
					Thread.sleep(2000);
					requestObserver.onNext(TaxPaymentsRequest.newBuilder().setTaxPayments("1/7/22")
							.build());
					Thread.sleep(2000);
					requestObserver.onNext(TaxPaymentsRequest.newBuilder().setTaxPayments("1/8/22")
							.build());
					Thread.sleep(2000);
					requestObserver.onNext(TaxPaymentsRequest.newBuilder().setTaxPayments("1/9/22")
							.build());
					Thread.sleep(3000);
					// Mark the end of requests
					requestObserver.onCompleted();

					// Sleep for a bit before sending the next one.
					Thread.sleep(new Random().nextInt(1000) + 500);

				} catch (RuntimeException | InterruptedException e6) {
					e6.printStackTrace();
				}

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}

			}
		});

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 2, 2);
		balancePanel.add(scrollPane_3);
		confirmBtn_old.setBounds(10, 171, 131, 37);
		confirmBtn_old.setText("Due dates:");
		confirmBtn_old.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		confirmBtn_old.setFont(new Font("Tahoma", Font.BOLD, 18));
		balancePanel.add(confirmBtn_old);

		JButton btn_balanceBtn_New = new JButton("Amount Due");
		btn_balanceBtn_New.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_balanceBtn_New.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_balanceBtn_New.setBounds(10, 54, 140, 30);
		balancePanel.add(btn_balanceBtn_New);

		JLabel lblNewLabel_2 = new JLabel("Overdue Payers");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(341, 297, 131, 19);
		balancePanel.add(lblNewLabel_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(160, 327, 485, 129);
		balancePanel.add(scrollPane_1);

		JTextArea textArea = new JTextArea(3, 30);
		scrollPane_1.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		JTextArea finalTextArea = textArea;
		panel_monitoring.setLayout(null);

		txt_band = new JTextField();
		txt_band.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_band.setFont(new Font("Tahoma", Font.BOLD, 18));
		txt_band.setColumns(10);
		txt_band.setBounds(191, 279, 90, 35);
		panel_monitoring.add(txt_band);

		btn_submit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_submit.setBounds(27, 279, 125, 35);
		panel_monitoring.add(btn_submit);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(5, 364, 621, 92);
		panel_monitoring.add(textField_2);

		JLabel lblGkm = new JLabel("g/km");
		lblGkm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGkm.setBounds(291, 284, 70, 30);
		panel_monitoring.add(lblGkm);

		btn_balanceBtn_New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentRequest balanceRequest = PaymentRequest
						.newBuilder()
						.setTotalDue("Retrieve user tax account balance.")
						.build();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
				try {
					PaymentResponse response = AmountTotalDueBlockingStub.checkAmount(balanceRequest); //changed
					balanceTf.setText("\n" + response.getTotalDue());
					///((Appendable) txtCheckTaxDue).append("stream is completed ... received ");
					System.out.println("Response: " + response);
					Thread.sleep(1000);

				} catch (StatusRuntimeException | InterruptedException e4) {
					e4.printStackTrace();
					//} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}

			}

		});

		//2nd panel
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_21 = new JLabel("Overdue Payers");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		panel_2.add(lblNewLabel_21);

		JButton btn_checkOverdueeBtn = new JButton("Check");
		btn_checkOverdueeBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_checkOverdueeBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_checkOverdueeBtn.setBounds(10, 327, 140, 30);
		balancePanel.add(btn_checkOverdueeBtn);
		btn_checkOverdueeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {

				ListRequest request= ListRequest.newBuilder().setAsk("List of Overdue Payers").build();

				StreamObserver<ListResponse> responseObserver= new StreamObserver<ListResponse>(){

					int count =0;
					@Override
					public void onNext(ListResponse value) {
						// TODO Auto-generated method stub

						System.out.println("Tax Payer: " + value.getAns());
						finalTextArea.append("Tax Payer: " + value.getAns()+"\n");
						count += 1;

					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub

						System.out.println("stream is completed ... received "+ count);
						finalTextArea.append("stream is completed ... received "+ count);

					}


				};
				AmountTotalDueAsyncStub.listoverduepayer(request, responseObserver);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException p) {
					// TODO Auto-generated catch block
					p.printStackTrace();
				}


			}
		});

		textArea = new JTextArea(3,30);
		textArea .setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane1 = new JScrollPane(textArea);
		panel_2.add(scrollPane1);


	}
}
