package JavaGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *	���ڲ���sql��ѯ������: ����֧�ֵĲ�ѯֻ��ȫ���ѯ
 * */

public class Search {

	PreparedStatement statement = null;
    ResultSet res = null;
	
	public Search()
	{
		try 
		{
//				���������ѯ�ı�ǩ
//				JLabel AskLabel = new JLabel("���ݿ��ѯ����");
//				AskLabel.setBounds(160, 20,100, 20);//(x,y,width,height)
//				Main.panelSearch.add(AskLabel);
				
//	            System.out.println("�����Ƿ�Ҫ���в�ѯ(yes/no)?");
				
				// ���������ѯ�ı�ǩ
	    		JLabel AskLabel = new JLabel("�����Ƿ�Ҫ���в�ѯ(yes/no)? ");
	    		AskLabel.setBounds(10,150, 200, 25);
	    		Main.panel.add(AskLabel);
	    		// �����ı���
	    		JTextField Ask = new JTextField(20);
	    		Ask.setBounds(190, 150, 100, 25);
	    		Main.panel.add(Ask);
	    		// ����ȷ������İ�ť
	    		JButton AskButton = new JButton("ȷ��");
	    		AskButton.setBounds(300, 150, 70, 25);
	    		Main.panel.add(AskButton);
	    		//Ϊ��ť���һ������¼�(��������ť�ͻ�ִ�ж�Ӧ��actionPerformed()����
	    		ActionListener al1 = new ActionListener() 
	    		{
	    			@Override
	    			public void actionPerformed(ActionEvent e) 
	    			{					
	    				String inputAsk = Ask.getText();
	    				if(inputAsk.equals("yes"))
	    				{
	    					//��ʼ���в�ѯ
	    					try 
	    					{
	    						System.out.println("��ʼ���в�ѯ");
//	    			            Scanner scan = new Scanner(System.in);
//	    			            System.out.println("��������Ҫ��ѯ�ı���:");
//	    			            String tableName = scan.nextLine();
	    						
	    			    		JLabel TableLabel = new JLabel("��������Ҫ��ѯ�ı���:");
	    			    		TableLabel.setBounds(10,180, 200, 25);
	    			    		Main.panel.add(TableLabel);
	    			    		// �����ı���
	    			    		JTextField AskText = new JTextField(20);
	    			    		AskText.setBounds(190, 180, 100, 25);
	    			    		Main.panel.add(AskText);
	    			    		// ����ȷ������İ�ť
	    			    		JButton AskButton = new JButton("ȷ��");
	    			    		AskButton.setBounds(300, 180, 70, 25);
	    			    		Main.panel.add(AskButton);
	    			    		ActionListener al2 = new ActionListener() 
	    			    		{
	    			    			@Override
	    			    			public void actionPerformed(ActionEvent e) 
	    			    			{					
	    			    				String tableName = AskText.getText();
	    			    				System.out.println("Ҫ��ѯ�ı���: "+tableName);
	    			    				
	    			    				try 
	    			    				{
											String sql = "select *from "+tableName;//��ѯStudent��
											statement = Main.con.prepareStatement(sql);
											res = statement.executeQuery();
											ShowTableInfo(tableName);
											
											System.out.println("���ҳɹ���");
										
	    			    				}
	    			    				catch (Exception e2) 
	    			    				{
											System.out.println("����ʧ�ܣ�");
	    			    					
											e2.printStackTrace();
										}
	    			    			}
	    			    		};
	    			    		AskButton.addActionListener(al2);
	    			    		
	    			    		//��ѯ�Ժ�ʼ���²���
	    			    		Update update = new Update(); //newһ��Update��ִ�и��²���
	    			    		
							} 
	    					catch (Exception e2) 
	    					{
								e2.printStackTrace();
							}
	    				}
	    				else 
	    				{
	    					//����ѯ��ֱ���˳�������
	    					System.exit(-1);
	    				}
	    			}
	    		};
	    		AskButton.addActionListener(al1);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(statement != null) statement.close();
				if(res != null) res.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}

	}

	public void ShowTableInfo(String tableName)
	{
		try 
		{
			//��ѯ���� - Ҫ�ŵ�gui��
			if(tableName.equals("Student"))
	        {
//	            System.out.println("Student:");
//	            System.out.println("ѧ��\t\t����\t�Ա�\t����\tϵ��\t\t�༶");
				JTextField info1 = new JTextField("Student:");
				JTextField info2 = new JTextField("ѧ��\t����\t�Ա�\t����\tϵ��\t\t�༶");
				info1.setBounds(10,210,100,20);
				info2.setBounds(10,230,540,20);
				Main.panel.add(info1);
				Main.panel.add(info2);
				
				int highth = 230;
	            while(res.next()){
	            	//��ȡ��ѯ���
	            	String Sno = res.getString("Sno");
	                String SName = res.getString("SName");
	                String Sex = res.getString("Sex");
	                String Age = res.getString("Age");
	                String Dept = res.getString("Dept");
	                String Class = res.getString("Class");
	                System.out.println(Sno+"\t"+SName+"\t"+Sex+"\t"+Age+"\t"+Dept+"\t"+Class);
	                //ÿ�ζ�����һ���ı��������������
	                JTextField info = new JTextField(Sno+"\t"+SName+"\t"+Sex+"\t"+Age+"\t"+Dept+"\t"+Class);
	                highth += 18;
					info.setBounds(10,highth,540,20);
					Main.panel.add(info);
	            }
	    		JLabel TrueLabel = new JLabel("���ҳɹ���");
	    		TrueLabel.setFont(new Font("΢���ź�",1,15)); 
	    		highth += 18;
	    		TrueLabel.setBounds(10,highth,100,20);
	    		Main.panel.add(TrueLabel);
	            System.out.println();
	        }
	        else if(tableName.equals("Course"))
	        {
	            System.out.println("Course:");
	            System.out.println("�γ̺�\t�γ���\t��ʦ");
				JTextField info1 = new JTextField("Course:");
				JTextField info2 = new JTextField("�γ̺�\t�γ���\t��ʦ");
				info1.setBounds(10,210,100,20);
				info2.setBounds(10,230,540,20);
				Main.panel.add(info1);
				Main.panel.add(info2);
	            
				int highth = 230;
	            while(res.next()){
	            	//��ȡ��ѯ���
	            	String Cno = res.getString("Cno");
	                String CName = res.getString("CName");
	                String Teacher = res.getString("Teacher");
	                System.out.println(Cno+"\t"+CName+"\t"+Teacher);
	                //ÿ�ζ�����һ���ı��������������
	                JTextField info = new JTextField(Cno+"\t"+CName+"\t"+Teacher);
	                highth += 18;
					info.setBounds(10,highth,540,20);
					Main.panel.add(info);
	            }
	    		JLabel TrueLabel = new JLabel("���ҳɹ���");
	    		TrueLabel.setFont(new Font("΢���ź�",1,15)); 
	    		highth += 18;
	    		TrueLabel.setBounds(10,highth,100,20);
	    		Main.panel.add(TrueLabel);
	            System.out.println();
	        }
	        else if(tableName.equals("Scores"))
	        {
	            System.out.println("Scores:");
	            System.out.println("ѧ��\t�γ̺�\t�ɼ�");
				JTextField info1 = new JTextField("Scores:");
				JTextField info2 = new JTextField("ѧ��\t�γ̺�\t�ɼ�");
				info1.setBounds(10,210,100,20);
				info2.setBounds(10,230,540,20);
				Main.panel.add(info1);
				Main.panel.add(info2);
	            
				int highth = 230;
	            while(res.next()){
	            	//��ȡ��ѯ���
	            	String Sno = res.getString("Sno");
	                String Cno = res.getString("Cno");
	                String Grade = res.getString("Grade");
	                System.out.println(Sno+"\t"+Cno+"\t"+Grade);
	                //ÿ�ζ�����һ���ı��������������
	                JTextField info = new JTextField(Sno+"\t"+Cno+"\t"+Grade);
	                highth += 18;
					info.setBounds(10,highth,540,20);
					Main.panel.add(info);
	            }
	    		JLabel TrueLabel = new JLabel("���ҳɹ���");
	    		TrueLabel.setFont(new Font("΢���ź�",1,15)); 
	    		highth += 18;
	    		TrueLabel.setBounds(10,highth,100,20);
	    		Main.panel.add(TrueLabel);
	    		System.out.println();
	        }
	        else if(tableName.equals("Hobby"))
	        {
	            System.out.println("Hobby:");
	            System.out.println("���ñ��\t\t��������");
				JTextField info1 = new JTextField("Hobby:");
				JTextField info2 = new JTextField("���ñ��\t\t��������");
				info1.setBounds(10,210,100,20);
				info2.setBounds(10,230,540,20);
				Main.panel.add(info1);
				Main.panel.add(info2);
	            
				int highth = 230;
	            while(res.next()){
	            	//��ȡ��ѯ���
	            	String HNo = res.getString("HNo");
	                String HName = res.getString("HName");
	                System.out.println(HNo+"\t"+HName);
	                //ÿ�ζ�����һ���ı��������������
	                JTextField info = new JTextField(HNo+"\t"+HName);
	                highth += 18;
					info.setBounds(10,highth,540,20);
					Main.panel.add(info);
	            }
	    		JLabel TrueLabel = new JLabel("���ҳɹ���");
	    		TrueLabel.setFont(new Font("΢���ź�",1,15)); 
	    		highth += 18;
	    		TrueLabel.setBounds(10,highth,100,20);
	    		Main.panel.add(TrueLabel);
	    		System.out.println();
	        }
	        else if(tableName.equals("StuHobby"))
	        {
	            System.out.println("StuHobby:");
	            System.out.println("ѧ�����\t\t���ñ��\t\t���ó̶�");
				JTextField info1 = new JTextField("StuHobby:");
				JTextField info2 = new JTextField("ѧ�����\t\t���ñ��\t\t���ó̶�");
				info1.setBounds(10,210,100,20);
				info2.setBounds(10,230,540,20);
				Main.panel.add(info1);
				Main.panel.add(info2);
	            
				int highth = 230;
	            while(res.next()){
	            	//��ȡ��ѯ���
	            	String SNo = res.getString("SNo");
	            	String HNo = res.getString("HNo");
	                String HLevel = res.getString("HLevel");
	                System.out.println(SNo+"\t"+HNo+"\t"+HLevel);
	                //ÿ�ζ�����һ���ı��������������
	                JTextField info = new JTextField(SNo+"\t"+HNo+"\t"+HLevel);
	                highth += 18;
					info.setBounds(10,highth,540,20);
					Main.panel.add(info);
	            }
	    		JLabel TrueLabel = new JLabel("���ҳɹ���");
	    		TrueLabel.setFont(new Font("΢���ź�",1,15)); 
	    		highth += 18;
	    		TrueLabel.setBounds(10,highth,100,20);
	    		Main.panel.add(TrueLabel);
	    		System.out.println();
	        }
	        else if(tableName.equals("University"))
	        {
	            System.out.println("University:");
	            System.out.println("��ѧ���\t��ѧ����\t\t��ѧ������Ϣ");
				JTextField info1 = new JTextField("University:");
				JTextField info2 = new JTextField("��ѧ���\t\t��ѧ����\t\t��ѧ������Ϣ");
				info1.setBounds(10,210,100,20);
				info2.setBounds(10,230,540,20);
				Main.panel.add(info1);
				Main.panel.add(info2);
	            
				int highth = 230;
	            while(res.next()){
	            	//��ȡ��ѯ���
	            	String UNo = res.getString("UNo");
	            	String UName = res.getString("UName");
	                String Info = res.getString("Info");
	                System.out.println(UNo+"\t"+UName+"\t"+Info);
	                //ÿ�ζ�����һ���ı��������������
	                JTextField info = new JTextField(UNo+"\t"+UName+"\t"+Info);
	                highth += 18;
					info.setBounds(10,highth,540,20);
					Main.panel.add(info);
	            }
	    		JLabel TrueLabel = new JLabel("���ҳɹ���");
	    		TrueLabel.setFont(new Font("΢���ź�",1,15)); 
	    		highth += 18;
	    		TrueLabel.setBounds(10,highth,100,20);
	    		Main.panel.add(TrueLabel);
	    		System.out.println();
	        }
	        else if(tableName.equals("Graduate"))
	        {
	            System.out.println("Graduate:");
	            System.out.println("ѧ��\t\t��ѧ���\t\t¼ȡ��Ϣ");
				JTextField info1 = new JTextField("Graduate:");
				JTextField info2 = new JTextField("ѧ��\t\t��ѧ���\t\t¼ȡ��Ϣ");
				info1.setBounds(10,210,100,20);
				info2.setBounds(10,230,540,20);
				Main.panel.add(info1);
				Main.panel.add(info2);
	            
				int highth = 230;
	            while(res.next()){
	            	//��ȡ��ѯ���
	            	String SNo = res.getString("SNo");
	            	String UNo = res.getString("UNo");
	                String Diff = res.getString("Diff");
	                System.out.println(SNo+"\t"+UNo+"\t"+Diff);
	                //ÿ�ζ�����һ���ı��������������
	                JTextField info = new JTextField(SNo+"\t"+UNo+"\t"+Diff);
	                highth += 18;
					info.setBounds(10,highth,540,20);
					Main.panel.add(info);
	            }
	    		JLabel TrueLabel = new JLabel("���ҳɹ���");
	    		TrueLabel.setFont(new Font("΢���ź�",1,15)); 
	    		highth += 18;
	    		TrueLabel.setBounds(10,highth,100,20);
	    		Main.panel.add(TrueLabel);
	    		System.out.println();
	        }
	        else {
                JTextField info = new JTextField("�������û��"+tableName+"��");
				info.setBounds(10,210,540,20);
				Main.panel.add(info);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
