package com.daoImpl;

import java.sql.*;
import java.util.ArrayList;

import com.dao.EmploeDao;
import com.entity.Emploe;
import com.util.ConnDB;

public class EmploeDaoImpl implements EmploeDao {
	Connection conn = null;
	PreparedStatement psta = null;
	ResultSet rs = null;
    /**
     * 查询所有员工
     */
	public ArrayList<Emploe> getAllEmploe() {
		ArrayList<Emploe> list = new ArrayList<Emploe>();
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("select * from emploe where estatus=1");
			rs = psta.executeQuery();
			while (rs.next()) {
				Emploe emploe = new Emploe();
				emploe.setEid(rs.getInt("eid"));
				emploe.setEname(rs.getString("ename"));
				emploe.setEsex(rs.getString("esex"));
				emploe.setEbir(rs.getDate("ebir"));
				emploe.setEmarry(rs.getString("emarry"));
				emploe.setEphone(rs.getString("ephone"));
				emploe.setEaddr(rs.getString("eaddr"));
				emploe.setDid(rs.getInt("did"));
				emploe.setPid(rs.getInt("pid"));
				emploe.setEedu(rs.getString("eedu"));
				emploe.setEsalary(rs.getString("esalary"));
				emploe.setEpassword(rs.getString("epassword"));
				emploe.setEphoto(rs.getString("ephoto"));
				emploe.setEquestion(rs.getString("equestion"));
				emploe.setEanswer(rs.getString("eanswer"));
				list.add(emploe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return list;
	}

	/**
	 * 分页查询员工
	 */
	int pageCount = 0;
	int lineCount = 0;

	public int getPageCount() {
		return pageCount;
	}

	public int getLineCount() {
		return lineCount;
	}
	public ArrayList<Emploe> getAllEmploeByPage(int n) {

		int pageSize = 2;
		int pageNow = n;
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("select count(*) from emploe where estatus=1");
			rs = psta.executeQuery();
			if (rs.next()) {
				lineCount = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		pageCount = (int) Math.ceil(lineCount * 1.0 / pageSize);
		ArrayList<Emploe> list = new ArrayList<Emploe>();
		try {
			psta = conn.prepareStatement("select * from emploe limit ?,?");
			psta.setInt(1, (pageNow - 1) * pageSize);
			psta.setInt(2, pageSize);
			rs = psta.executeQuery();
			while (rs.next()) {
				Emploe emploe = new Emploe();
				emploe.setEid(rs.getInt("eid"));
				emploe.setEname(rs.getString("ename"));
				emploe.setEsex(rs.getString("esex"));
				emploe.setEbir(rs.getDate("ebir"));
				emploe.setEmarry(rs.getString("emarry"));
				emploe.setEphone(rs.getString("ephone"));
				emploe.setEaddr(rs.getString("eaddr"));
				emploe.setDid(rs.getInt("did"));
				emploe.setPid(rs.getInt("pid"));
				emploe.setEedu(rs.getString("eedu"));
				emploe.setEsalary(rs.getString("esalary"));
				emploe.setEpassword(rs.getString("epassword"));
				emploe.setEphoto(rs.getString("ephoto"));
				emploe.setEquestion(rs.getString("equestion"));
				emploe.setEanswer(rs.getString("eanswer"));
				list.add(emploe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return list;
	}

	/**
	 * 根据部门名查询员工
	 */
	public ArrayList<Emploe> getEmploeByDname(String dname) {
		ArrayList<Emploe> list = new ArrayList<Emploe>();
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("select * from emploe where did=(select did from dept where dname=?)");
			psta.setString(1, dname);
			rs = psta.executeQuery();
			while (rs.next()) {
				Emploe emploe = new Emploe();
				emploe.setEid(rs.getInt("eid"));
				emploe.setEname(rs.getString("ename"));
				emploe.setEsex(rs.getString("esex"));
				emploe.setEbir(rs.getDate("ebir"));
				emploe.setEmarry(rs.getString("emarry"));
				emploe.setEphone(rs.getString("ephone"));
				emploe.setEaddr(rs.getString("eaddr"));
				emploe.setDid(rs.getInt("did"));
				emploe.setPid(rs.getInt("pid"));
				emploe.setEedu(rs.getString("eedu"));
				emploe.setEsalary(rs.getString("esalary"));
				emploe.setEpassword(rs.getString("epassword"));
				emploe.setEphoto(rs.getString("ephoto"));
				emploe.setEquestion(rs.getString("equestion"));
				emploe.setEanswer(rs.getString("eanswer"));
				emploe.setEstatus(rs.getInt("estatus"));
				list.add(emploe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return list;
	}
    
	/**
	 * 根据id查询员工
	 */
	public Emploe getEmploeById(int eid) {
		Emploe emploe = new Emploe();
		conn = ConnDB.getConn();
		try {
			psta = conn.prepareStatement("select * from emploe where eid=?");
			psta.setInt(1, eid);
			rs = psta.executeQuery();
			if (rs.next()) {
				emploe.setEid(rs.getInt("eid"));
				emploe.setEname(rs.getString("ename"));
				emploe.setEsex(rs.getString("esex"));
				emploe.setEbir(rs.getDate("ebir"));
				emploe.setEmarry(rs.getString("emarry"));
				emploe.setEphone(rs.getString("ephone"));
				emploe.setEaddr(rs.getString("eaddr"));
				emploe.setDid(rs.getInt("did"));
				emploe.setPid(rs.getInt("pid"));
				emploe.setEedu(rs.getString("eedu"));
				emploe.setEsalary(rs.getString("esalary"));
				emploe.setEpassword(rs.getString("epassword"));
				emploe.setEphoto(rs.getString("ephoto"));
				emploe.setEquestion(rs.getString("equestion"));
				emploe.setEanswer(rs.getString("eanswer"));
				emploe.setEstatus(rs.getInt("estatus"));
			} else {
				emploe = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return emploe;
	}
    /**
     * 根据员工名查询员工
     */
	public Emploe getEmploeByName(String ename) {
		Emploe emploe = new Emploe();
		conn = ConnDB.getConn();
		try {
			psta = conn.prepareStatement("select * from emploe where ename=?");
			psta.setString(1, ename);
			rs = psta.executeQuery();
			if (rs.next()) {
				emploe.setEid(rs.getInt("eid"));
				emploe.setEname(rs.getString("ename"));
				emploe.setEsex(rs.getString("esex"));
				emploe.setEbir(rs.getDate("ebir"));
				emploe.setEmarry(rs.getString("emarry"));
				emploe.setEphone(rs.getString("ephone"));
				emploe.setEaddr(rs.getString("eaddr"));
				emploe.setDid(rs.getInt("did"));
				emploe.setPid(rs.getInt("pid"));
				emploe.setEedu(rs.getString("eedu"));
				emploe.setEsalary(rs.getString("esalary"));
				emploe.setEpassword(rs.getString("epassword"));
				emploe.setEphoto(rs.getString("ephoto"));
				emploe.setEquestion(rs.getString("equestion"));
				emploe.setEanswer(rs.getString("eanswer"));
				emploe.setEstatus(rs.getInt("estatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return emploe;
	}
	/**
	 * 注册
	 */
	public boolean registerEmploe(Emploe emploe) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("insert into emploe(eid,epassword,ename,equestion,eanswer,estatus) values(?,?,?,?,?,?)");
			psta.setInt(1, emploe.getEid());
			psta.setString(2, emploe.getEpassword());
			psta.setString(3, emploe.getEname());
			psta.setString(4, emploe.getEquestion());
			psta.setString(5, emploe.getEanswer());
			psta.setInt(6, 1);
			int n = psta.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return flag;
	}

	/**
	 * 
	 */
	public boolean registerEmploe2(Emploe emploe) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("insert into emploe(eid,epassword,ename,estatus) values(?,?,?,?)");
			psta.setInt(1, emploe.getEid());
			psta.setString(2, emploe.getEpassword());
			psta.setString(3, emploe.getEname());
			psta.setInt(4, 1);
			int n = psta.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return flag;
	}

	public boolean remove(int eid) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("update emploe set estatus=0 where eid=?");
			psta.setInt(1, eid);
			int n = psta.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return flag;
	}

	public boolean updateEmploe(int eid, Emploe emploe) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("update emploe set ename=?,esex=?,ebir=?,emarry=?,ephone=?,eaddr=?,did=?,pid=?,eedu=?,epassword=?,ephoto=?,equestion=?,eanswer=?,esalary=? where eid=?");
			psta.setString(1, emploe.getEname());
			psta.setString(2, emploe.getEsex());
			psta.setDate(3, new java.sql.Date(emploe.getEbir().getTime()));
			psta.setString(4, emploe.getEmarry());
			psta.setString(5, emploe.getEphone());
			psta.setString(6, emploe.getEaddr());
			psta.setInt(7, emploe.getDid());
			psta.setInt(8, emploe.getPid());
			psta.setString(9, emploe.getEedu());
			psta.setString(10, emploe.getEpassword());
			psta.setString(11, emploe.getEphoto());
			psta.setString(12, emploe.getEquestion());
			psta.setString(13, emploe.getEanswer());
			psta.setString(14, emploe.getEsalary());
			psta.setInt(15, eid);
			int n = psta.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return flag;
	}

	// Ա����ź������¼
	public int emploeLogin(int eid, String epassword) {
		int n = 0;// 1�����¼�ɹ���2�����û�������3�����������
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("select epassword from emploe where eid=?");
			psta.setInt(1, eid);
			rs = psta.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(epassword)) {
					n = 1;
				} else {
					n = 3;
				}
			} else {
				n = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return n;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psta != null) {
				psta.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Emploe> getEmploeByPname(String pname) {
		ArrayList<Emploe> list = new ArrayList<Emploe>();
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("select * from emploe where estatus=1 and pid=(select pid from post where pname=?)");
			psta.setString(1, pname);
			rs = psta.executeQuery();
			while (rs.next()) {
				Emploe emploe = new Emploe();
				emploe.setEid(rs.getInt("eid"));
				emploe.setEname(rs.getString("ename"));
				emploe.setEsex(rs.getString("esex"));
				emploe.setEbir(rs.getDate("ebir"));
				emploe.setEmarry(rs.getString("emarry"));
				emploe.setEphone(rs.getString("ephone"));
				emploe.setEaddr(rs.getString("eaddr"));
				emploe.setDid(rs.getInt("did"));
				emploe.setPid(rs.getInt("pid"));
				emploe.setEedu(rs.getString("eedu"));
				emploe.setEsalary(rs.getString("esalary"));
				emploe.setEpassword(rs.getString("epassword"));
				emploe.setEphoto(rs.getString("ephoto"));
				emploe.setEquestion(rs.getString("equestion"));
				emploe.setEanswer(rs.getString("eanswer"));
				list.add(emploe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return list;
	}

	public boolean updatePidByEid(int eid, int pid) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("update emploe set pid=? where eid=? and estatus=1");
			psta.setInt(1, pid);
			psta.setInt(2, eid);
			int n = psta.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return flag;
	}

	public boolean addEmploe(Emploe emploe) {
		boolean flag = false;
		conn = ConnDB.getConn();
		try {
			psta = conn
					.prepareStatement("insert into emploe(eid,ename,esex,esalary,ebir,emarry,eedu,did,pid,ephone,eaddr,estatus) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			psta.setInt(1, emploe.getEid());
			psta.setString(2, emploe.getEname());
			psta.setString(3, emploe.getEsex());
			psta.setString(4, emploe.getEsalary());
			psta.setDate(5, new java.sql.Date(emploe.getEbir().getTime()));
			psta.setString(6, emploe.getEmarry());
			psta.setString(7, emploe.getEedu());
			psta.setInt(8, emploe.getDid());
			psta.setInt(9, emploe.getPid());
			psta.setString(10, emploe.getEphone());
			psta.setString(11, emploe.getEaddr());
			psta.setInt(12, 1);
			int n = psta.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return flag;
	}

}
