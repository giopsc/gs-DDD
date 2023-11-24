package br.com.fiap.seriesapi.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.seriesapi.model.Responsavel;

public class ResponsavelDao {
	
	List<Responsavel> lista = new ArrayList<>();
	
	private Connection conexao;
	
	public ResponsavelDao(){
        try {
            conexao = ConnectionFactory.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public void inserir(Responsavel responsavel) throws SQLException{
        var sql = "INSERT INTO gs_responsavel (id, nome, cpf, telefone, email, senha) VALUES (7, 'Elizabeth Webber', 62312958007, 1187865432, 'liz@gmail.com', 23230912);";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, responsavel.nome());
        comando.setLong(2, responsavel.cpf());
        comando.setInt(3, responsavel.telefone());
        comando.setInt(4, responsavel.telefone2());
        comando.setString(5, responsavel.email());
        comando.setString(5, responsavel.senha());
        comando.executeUpdate();
        
        lista.add(responsavel);
    }

	public List<Responsavel> findAll() throws SQLException  {
		var comando = conexao.prepareStatement("SELECT * FROM gs_responsavel");
        var resultado = comando.executeQuery();

        while(resultado.next()){
            lista.add (
                new Responsavel(
                    resultado.getLong("id"), 
                    resultado.getString("nome"), 
                    resultado.getLong("cpf"),
                    resultado.getInt("telefone"),
                    resultado.getInt("telefone2"),
                    resultado.getString("email"),
                    resultado.getString("senha")
                 )
            );
        }
		return lista;
	}

	public Responsavel findById(Long id) throws SQLException {
		var sql = "SELECT * FROM SERIES WHERE ID=?";
		var comando = conexao.prepareStatement(sql);
		comando.setLong(1, id);
		var resultado = comando.executeQuery();
		if(resultado.next()) {
			var responsavel = new Responsavel(
					resultado.getLong("id"),
					resultado.getString("nome"),
					resultado.getLong("cpf"),
					resultado.getInt("telefone"),
					resultado.getInt("telefone2"),
					resultado.getString("email"),
					resultado.getString("senha")
			);
			
			return responsavel;
		} else {
			return null;
		}
		
	}

	public void delete(Long id) throws SQLException {
		var comando = conexao.prepareStatement("DELETE FROM gs_responsavel WHERE ID=?");
		comando.setLong(1, id);
		comando.executeUpdate();
		var user = findById(id);
		lista.remove(user);
//		System.out.println(lista);
	}

	public void create(Responsavel responsavel) {
//		var sql = INSERT INTO
		lista.add(responsavel);
	}

	public void update(Responsavel responsavel) throws SQLException {
		var comando = conexao.prepareStatement("UPDATE gs_responsavel SET nome = ?, cpf = ?, telefone = ?, telefone2 = ?, email = ?, senha = ? WHERE id = ?");
		comando.setString(1, responsavel.nome());
		comando.setLong(2, responsavel.cpf());
		comando.setInt(3, responsavel.telefone());
		comando.setInt(4, responsavel.telefone2());
		comando.setString(5, responsavel.email());
		comando.setString(6, responsavel.senha());
		comando.setLong(7, responsavel.id());
		
		comando.executeUpdate();
	}

}
