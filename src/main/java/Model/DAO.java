package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?userTimezone=true&severTimezone=UTC";
	private String user = "walan";
	private String passwor = "359483wa@";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, passwor);
			return con;
		} catch (Exception e) {
			return null;
		}

	}

	public void inserirContato(javaBeans contato) {
		String sql = "insert into tbcontatos (nome,fone,email) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getFone());
			stmt.setString(3, contato.getEmail());

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<javaBeans> listaContatos() {
		ArrayList<javaBeans> lista = new ArrayList<>();
		String sql = "select * from tbcontatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				lista.add(new javaBeans(idcon, nome, fone, email));

			}
			con.close();
			return lista;

		} catch (Exception e) {
			return null;
		}

	}

	public void buscarContado(javaBeans contato) {
		String sql = "select * from tbcontatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, contato.getIdcon());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				contato.setIdcon(rs.getInt(1));	
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
}
