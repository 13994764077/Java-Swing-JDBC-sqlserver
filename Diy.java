package JavaGUI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *	�Զ��幦�ܣ��Լ���������һ����䲢ָ���Ǻ������͵����
 * */

public class Diy {

	PreparedStatement stateSelect = null;//��ѯ�õ�state
	Statement stateUpdate = null;//�����õ�state
    ResultSet res = null;
    
    public Diy()
    {
        try 
        {
        	while(true)
        	{
	            System.out.println("����Ҫ�Ƿ�����Զ������(yes/no)?");
	            Scanner scan = new Scanner(System.in);
	            String flag = scan.nextLine();
	            if(flag.equals("no"))
	            {
	            	break;
	            }
                String SelfSQL,SQLType;
                System.out.println("��������Ҫִ�е�sql���:");

                SelfSQL = scan.nextLine();
                System.out.println("ָ����sql��������(����\\ɾ��\\�޸�\\��ѯ):");
                SQLType = scan.nextLine();
                if(SQLType.equals("�޸�") || SQLType.equals("����") || SQLType.equals("ɾ��"))
                {
                	//insert into Student VALUES ('3','���춫','��',20,'�����ʵ��ѧ','17�ƿ�')
                	boolean flag1 = true;
                	stateUpdate = Main.con.createStatement();
                	try {
                		stateUpdate.executeUpdate(SelfSQL);
        			} catch (Exception e) {
        				System.out.println("ִ�д���");
        				flag1 = false;
        			}
                	if(flag1)
                		System.out.println("ִ�гɹ���");
                }
                else if(SQLType.equals("��ѯ"))
                {
                    //String sql = "select *from "+tableName;//��ѯStudent��
                	stateSelect = Main.con.prepareStatement(SelfSQL);
                    res = stateSelect.executeQuery();
                }
        	}
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(stateSelect != null) stateSelect.close();
				if(stateUpdate != null) stateUpdate.close();
				if(res != null) res.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
    }
}
